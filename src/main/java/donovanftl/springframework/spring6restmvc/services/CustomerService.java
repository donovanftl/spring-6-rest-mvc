package donovanftl.springframework.spring6restmvc.services;


import donovanftl.springframework.spring6restmvc.entities.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerById(UUID customerId, CustomerDTO customer);

    void deleteCustomerById(UUID idCustomer);

    void patchCustomerById(UUID customerId, CustomerDTO customer);
}
