package donovanftl.springframework.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import donovanftl.springframework.spring6restmvc.entities.Customer;
import donovanftl.springframework.spring6restmvc.services.CustomerService;
import donovanftl.springframework.spring6restmvc.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CostumerController.class)
class CostumerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerServiceImpl customerServiceImpl;

    @BeforeEach
    void setUp() {
        customerServiceImpl = new CustomerServiceImpl();
    }

    @Test
    void testCreateNewCostumer() throws Exception {
        Customer customer = customerServiceImpl.getAllCostumers().get(0);
        customer.setVersion(null);
        customer.setId(null);

        given(customerService.saveNewCostumer(any(Customer.class))).willReturn(customerServiceImpl.getAllCostumers().get(1));

        mockMvc.perform(post ("/api/v1/customer")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));


    }

    @Test
    void listAllCostumers() throws Exception {
        given(customerService.getAllCostumers()).willReturn(customerServiceImpl.getAllCostumers());

        mockMvc.perform(get("/api/v1/customer")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getCostumerByID() throws Exception {

        Customer customer = customerServiceImpl.getAllCostumers().get(0);

        given(customerService.getCostumerById(customer.getId())).willReturn(customer);

        mockMvc.perform(get("/api/v1/customer/" + customer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(customer.getName())));
    }
}