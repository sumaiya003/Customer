package Sunbase.assignment.Customer.Repo;

import Sunbase.assignment.Customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepo extends JpaRepository<Customer , Integer> {
//   @Query(value = "select * from customer where uuid = ?",nativeQuery = true)
//    public List<Customer> findallbyid(UUID uuid);
}
