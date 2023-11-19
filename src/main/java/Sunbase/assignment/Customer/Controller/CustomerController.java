package Sunbase.assignment.Customer.Controller;

import Sunbase.assignment.Customer.Model.Customer;
import Sunbase.assignment.Customer.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Service service;

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Customer customer){
        return service.createCustomer(customer);
    }

    @GetMapping("get_customer_list")
    public ResponseEntity<List<Customer>> fetchCustomer(){
        return service.getCustomerList();
    }

    @PostMapping("delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid ){
        return service.deleteCustomer(uuid);
    }

    @PostMapping("update/{uuid}")
    public ResponseEntity<String> update(@PathVariable UUID uuid , @RequestBody Customer customer){
        return service.updateCustomer(uuid,customer);
    }


}
