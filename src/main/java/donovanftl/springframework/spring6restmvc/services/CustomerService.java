package donovanftl.springframework.spring6restmvc.services;


import donovanftl.springframework.spring6restmvc.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteCustomerById(UUID idCustomer);

    void patchCustomerById(UUID customerId, Customer customer);
}
