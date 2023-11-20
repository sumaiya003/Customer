package Sunbase.assignment.Customer.Controller;

import Sunbase.assignment.Customer.Model.Customer;
import Sunbase.assignment.Customer.Repo.CustomerRepo;
import Sunbase.assignment.Customer.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Service service;

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Customer customer){

         return service.createCustomer(customer);
    }

    @GetMapping("get_customer_list")
    public ResponseEntity<List<Customer>> fetchCustomer(){
        return service.getCustomerList();
    }

//   @PostMapping("delete/{uuid}")
//    public ResponseEntity<String> delete(PathVariable UUID uuid ){
//     return service.deleteCustomer(uuid);
////        return customerRepo.deleteCustomerById(uuid);
//    }

    @PostMapping("delete/{cid}")
    public ResponseEntity<String> delete(@PathVariable int cid){
        return service.deleteCustomer(cid);
    }

    @PostMapping("update/{cid}")
    public ResponseEntity<String> update(@PathVariable int cid , @RequestBody Customer customer){
        return service.updateCustomer(cid,customer);
    }


}
