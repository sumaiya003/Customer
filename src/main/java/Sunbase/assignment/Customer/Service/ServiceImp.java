package Sunbase.assignment.Customer.Service;

import Sunbase.assignment.Customer.Model.Customer;
import Sunbase.assignment.Customer.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class ServiceImp implements Service{

    @Autowired
    CustomerRepo repo;
    @Override
    public ResponseEntity<String> createCustomer(Customer customer) {

        if(customer.getFirst_name()=="" || customer.getLast_name() =="")
            return new ResponseEntity<>("Failure: 400, First Name or Last Name is missing", HttpStatus.BAD_REQUEST);
        else {
            repo.save(customer);
            return new ResponseEntity<>("Success: 201, Successfully Created", HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<List<Customer>> getCustomerList(){
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> deleteCustomer(UUID uuid) {

        List<Customer> ll = repo.findAll();
        for ( Customer uid:ll){
            if (uid.getUuid() == uuid){
                repo.deleteById(uuid);
                return new ResponseEntity<>("200, Successfully deleted",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("400, UUID not found",HttpStatus.BAD_REQUEST);

     // handle 500 Error Not deleted  ???

    }

    @Override
    public ResponseEntity<String> updateCustomer(UUID uuid,Customer customer) {

        List<Customer> customerList = repo.findAll();
        for (Customer cuid: customerList){
            if (cuid.getUuid() == uuid){
                cuid.setFirst_name(customer.getFirst_name());
                cuid.setLast_name(customer.getLast_name());
                cuid.setStreet(customer.getStreet());
                cuid.setAddress(customer.getAddress());
                cuid.setCity(customer.getCity());
                cuid.setState(customer.getState());
                cuid.setEmail(customer.getEmail());
                cuid.setPhone(customer.getPhone());

                return new ResponseEntity<>("200, Successfully Updated",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("500, UUID not found",HttpStatus.INTERNAL_SERVER_ERROR);

        // how to check if body is empty or not

        // -------------------------------------------------------------------------------------

        //----in backend :
        // header , security using tokens
        // above 2 errors to be handled;

        //--- frontend left

    }
}
