package currency.inrvalue.controllertest;

import currency.inrvalue.bean.CurrencyMasterEntity;
import currency.inrvalue.controller.CurrencyController;
import currency.inrvalue.responseentity.ResponseEntityPage;
import currency.inrvalue.service.CurrencyService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class CurrencyControllerTest {

	 @Autowired
	 private CurrencyController controller;

	 @Test
	    public void findById_TodoEntryFound_ShouldReturnFoundTodoEntry() throws Exception {
	        CurrencyMasterEntity found =CurrencyMasterEntity.builder()
	        		.currencycode(156L)
	                .build();
	        
	        when(controller.getCurrencyInrValueById(156L));
	 
	        mockMvc.perform(get("/api/currency/{currency_code}", 156L))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
	                
	        verify(controller, times(1)).getCurrencyInrValueById(156L);
	        verifyNoMoreInteractions(controller);
	    }
}
