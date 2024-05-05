package donovanftl.springframework.spring6restmvc.controller;

import donovanftl.springframework.spring6restmvc.entities.Customer;
import donovanftl.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CostumerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCostumers() {
        return customerService.getAllCostumers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCostumerByID(@PathVariable("customerId") UUID id) {
        return customerService.getCostumerById(id);
    }
}
