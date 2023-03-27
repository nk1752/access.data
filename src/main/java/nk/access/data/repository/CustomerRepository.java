package nk.access.data.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nk.access.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Customer findById(Integer id);

    List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameAndFirstName(String firstName, String lastName);
    

    
}
