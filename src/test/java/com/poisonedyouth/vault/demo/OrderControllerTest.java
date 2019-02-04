package com.poisonedyouth.vault.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	public void shouldReturnAllOrders() throws Exception {
		when(orderRepository.findAll()).thenReturn(createOrdersList());
		mockMvc.perform(get("/api/orders")).andExpect(status().isOk()).andExpect(content().string(containsString("ProductA")));
	}

	private List<Order> createOrdersList() {
		Order order1 = new Order(1, "Max", "ProductA", new Date(6661L));
		Order order2 = new Order(1, "Trevor", "ProductB", new Date(123L));
		return Arrays.asList(order1, order2);
	}

	//https://github.com/spring-projects/spring-vault/blob/master/spring-vault-core/src/test/java/org/springframework/vault/client/VaultClientsUnitTests.java

}