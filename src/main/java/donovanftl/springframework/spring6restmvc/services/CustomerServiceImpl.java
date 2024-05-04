package donovanftl.springframework.spring6restmvc.services;

import donovanftl.springframework.spring6restmvc.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> costumerMap;

    public CustomerServiceImpl() {
        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        costumerMap = new HashMap<>();
        costumerMap.put(customer1.getId(), customer1);
        costumerMap.put(customer2.getId(), customer2);
        costumerMap.put(customer3.getId(), customer3);
    }

    public List<Customer> getAllCostumers() {
        return new ArrayList<>(costumerMap.values());
    }

    @Override
    public Customer getCostumerById(UUID id) {

        return costumerMap.get(id);
    }

}
