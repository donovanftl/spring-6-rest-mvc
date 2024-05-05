package donovanftl.springframework.spring6restmvc.controller;

import donovanftl.springframework.spring6restmvc.entities.Customer;
import donovanftl.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CostumerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCostumer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCostumers() {
        return customerService.getAllCostumers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCostumerByID(@PathVariable("customerId") UUID id) {
        return customerService.getCostumerById(id);
    }
}
