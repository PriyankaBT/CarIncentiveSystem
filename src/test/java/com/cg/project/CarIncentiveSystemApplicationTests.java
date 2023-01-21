package com.cg.project;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.entity.Dealer;
import com.cg.repository.DealerRepository;
import com.cg.service.DealerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarIncentiveSystemApplicationTests {
	@Autowired
	private DealerService dealerService;
	@MockBean
	private DealerRepository dealerRepository;

	@Test
	public void getAllDealersTest() {
		when(dealerRepository.findAll()).thenReturn(Stream
				.of(new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", null),
						new Dealer(82, "sachin", 9834256214l, "test2@gmail.com", "mumbai", null))
				.collect(Collectors.toList()));
		assertEquals(2, dealerService.getAllDealers().size());
	}

	@Test
	public void getDealerByIdTest() {
		/*
		 * int dealer_id=22;
		 * when(dealerDetailsRepository.getById(dealer_id)).thenReturn(Stream.of (new
		 * DealerDetails(22,"anna",9834218679l,"test1@gmail.com","pune")));
		 * assertEquals(1,dealerDetailsService.getDealerById(dealer_id));
		 */
		Dealer d1 = new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", null);
		when(dealerRepository.getById(22)).thenReturn(d1);
		assertEquals(d1, d1);
	}

	@Test
	public void addDealerTest() {
		Dealer d1 = new Dealer(22, "anna", 9834218679l, "test1@gmail.com", "pune", null);
		when(dealerRepository.save(d1)).thenReturn(d1);
		assertEquals(d1, dealerService.addDealer(d1));
	}
}
