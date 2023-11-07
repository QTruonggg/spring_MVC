package com.example.spring_mvc.service.impl;


import com.example.spring_mvc.entity.Customer;
import com.example.spring_mvc.repository.CustomerRepository;
import com.example.spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        // Thực hiện xóa khách hàng từ cơ sở dữ liệu dựa trên ID
        // Ví dụ:
        customerRepository.deleteById(customerId);
    }
}
