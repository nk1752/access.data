package nk.access.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nk.access.data.entity.Customer;
import nk.access.data.service.CustomerService;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
        value="/hello",
        params = {"num1", "num2"},
        method = RequestMethod.GET)
    public String sayHello(@RequestParam Integer num1, @RequestParam Integer num2) {

        String str = "total: " + Integer.toString(num1 + num2);
        return str;
    }

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    
    @RequestMapping(path = "/customer/id", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer id) {
  
        return customerService.getCustomerById(id);
    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET)
    public List<Customer> getCustomerByLastName(@RequestParam String lastName) {
  
        return customerService.getCustomerByLastName(lastName);
    }


    @RequestMapping(path = "/customer1", method = RequestMethod.GET)
    public List<Customer> getCustomerByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName) {

        return customerService.getCustomerByLastNameAndFirstName(lastName, firstName);
    }


    @RequestMapping(method=RequestMethod.POST, value="/customer")
    public void addCustomer(@RequestBody Customer customer) {

        //Customer customer = new Customer(id, firstName, lastName);
        customerService.addCustomer(customer);

        //return customer;

    }
    
}
