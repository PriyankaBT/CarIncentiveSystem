package com.cg.project;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Dealer;
import com.cg.repository.DealerRepository;
import com.cg.service.DealerService;
import com.cg.exception.DealerIdNotFoundException;

@SpringBootTest
class DealerTest {
	@Autowired
	DealerService dealerService;

	@MockBean
	DealerRepository dealerRepository;
	Dealer d1;

	@BeforeEach
	void setUp() {

		d1 = new Dealer();
		d1.setDealerId(1);
		d1.setDealerMailid("komalwarpade123@gmail.com");
		d1.setDealerName("komal");
		d1.setDealerContact(9011000752L);
		d1.setDealerAddress("Pune");
		d1.setPassword("Bottle");

	}

	@Test
	void testAddDealer() {
		Mockito.when(dealerRepository.save(d1)).thenReturn(d1);
		assertThat(dealerService.addDealer(d1)).isEqualTo(d1);
	}

	@Test
	void testGetDealerById(Integer dealerId) {
		Mockito.when(dealerRepository.getById(d1.getDealerId())).thenReturn(d1);
		assertThat(dealerService.getDealerById(d1.getDealerId())).isEqualTo(d1);
	}

	@Test
	void testDealerLogin() throws DealerIdNotFoundException {
		Mockito.when(dealerRepository.doDealerLogin(d1.getDealerMailid(), d1.getPassword())).thenReturn(d1);
		assertThat(dealerService.dealerLogin(d1.getDealerMailid(), d1.getPassword())).isEqualTo(d1);
	}
}

//package com.cg.project;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.entity.Dealer;
//import com.cg.exception.DealerIdNotFoundException;
//import com.cg.repository.DealerRepository;
//import com.cg.service.DealerService;
//
//@SpringBootTest
//public class DealerTest {
//
//	@Autowired
//	DealerService dealerService;
//
//	@MockBean
//	DealerRepository dealerRepository;
//
//	@Test
//	void testsaveDealer() {
//		Dealer d1 = new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", "pass");
//		Mockito.when(dealerRepository.save(d1)).thenReturn(d1);
//		assertThat(dealerService.addDealer(d1)).isEqualTo(d1);
//	}
//
//	@Test
//	void updateDealer() throws Exception {
//		Dealer d1 = new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", "pass");
//		Dealer d2 = d1;
//		Mockito.when(dealerRepository.getById(22)).thenReturn(d2);
//		d1.setDealerName("monu");
//
//		Mockito.when(dealerRepository.save(d1)).thenReturn(d1);
//		assertThat(dealerService.updateDealer(d1)).isEqualTo(d1);
//
//	}
//
//	@Test
//	void getDealerById() throws DealerIdNotFoundException {
//		Dealer d1 = new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", "pass");
//		Dealer d2 = d1;
//		Mockito.when(dealerRepository.getById(22)).thenReturn(d2);
//		assertThat(dealerService.getDealerById(22)).isEqualTo(d2);
//	}
//
//}
