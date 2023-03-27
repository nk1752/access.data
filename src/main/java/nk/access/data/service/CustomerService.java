package nk.access.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nk.access.data.entity.Customer;
import nk.access.data.repository.CustomerRepository;

import java.util.List;
import java.util.Arrays;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        //return customer;

        return customerRepository.findAll();
    }


    public void addCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    public List<Customer> getCustomerByLastName(String lastName) {


        return customerRepository.findByLastName(lastName);

    }

    public List<Customer> getCustomerByLastNameAndFirstName(String lastName, String firstName) {


        return customerRepository.findByLastNameAndFirstName(lastName, firstName);

    }

    public Customer getCustomerById(Integer id) {


        return customerRepository.findById(id);

    }
}
