package com.example.spring_mvc.controller;

import com.example.spring_mvc.entity.Customer;
import com.example.spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getFormCreate")
    public String getFormCreate(ModelMap modelMap){
        String view="createOrUpdateCustomerForm";
        try {
            Customer customer = new Customer();
            modelMap.addAttribute("customer", customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @PostMapping("/createOrUpdate")
    public String saveOrUpdate(@ModelAttribute("customer") Customer customer, ModelMap modelMap){
        String view = "redirect:/customer/getAll";
        try {
            customerService.saveCustomer(customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @GetMapping("/getAll")
    public String getAll(ModelMap modelMap){
        String view = "listCustomer";
        try {
            List<Customer> customer = customerService.getAllCustomer();
            modelMap.addAttribute("customers", customer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomerById(customerId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            // Xử lý exception ở đây nếu cần
        }
        return "redirect:/customer/getAll";
    }

    @GetMapping("/getFormUpdate/{customerId}")
    public String getFormUpdate(@PathVariable Long customerId, ModelMap modelMap) {
        String view = "createOrUpdateCustomerForm";
        try {
            Customer customer = customerService.getCustomerById(customerId);
            modelMap.addAttribute("customer", customer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @PostMapping("/update/{customerId}")
    public String updateCustomer(@PathVariable Long customerId, @ModelAttribute("customer") Customer customer, ModelMap modelMap) {
        String view = "redirect:/customer/getAll";
        try {
            customer.setId(customerId); // Cập nhật ID cho khách hàng
            customerService.saveCustomer(customer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

}
