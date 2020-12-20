package com.triznet.DemoWithDB.repository;

import com.triznet.DemoWithDB.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastNameIgnoreCase(String lastName);
    Customer findByCustomerNr(long clientNr);

//    @Query("SELECT * FROM Client c WHERE c.client_nr = %:nr%")
//    List<Client> searchByClientNr(@Param("nr") long nr);

}
