package donovanftl.springframework.spring6restmvc.services;


import donovanftl.springframework.spring6restmvc.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCostumers();

    Customer getCostumerById(UUID id);

    Customer saveNewCostumer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID idCustomer);

    void patchCustomerById(UUID customerId, Customer customer);
}
