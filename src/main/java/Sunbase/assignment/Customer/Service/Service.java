package Sunbase.assignment.Customer.Service;

import Sunbase.assignment.Customer.Model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface Service {
    ResponseEntity<String> createCustomer(Customer customer);

    ResponseEntity<List<Customer>> getCustomerList();

    ResponseEntity<String> deleteCustomer(int uuid);

    ResponseEntity<String> updateCustomer(int uuid , Customer customer);



}
