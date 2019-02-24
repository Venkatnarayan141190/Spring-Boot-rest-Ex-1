package currency.inrvalue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import currency.inrvalue.responseentity.ResponseEntityPage;
import currency.inrvalue.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value={"/currency"})
@Api(value = "CurrencyController", description = "REST APIs Convert Currency into inr value!!!!")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	
	/**
	 * This API is used to get Currency INR value using currency code.
	 * @author Venkatnarayan
	 * @param request
	 * @return
	 * @throws 
	 */
	@GetMapping(value = "/{currency_code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get currency inr value by code in the System ", response = List.class, tags = "fetchcurrencyinrvalue")
	public ResponseEntity<ResponseEntityPage> getCurrencyInrValueById(@PathVariable("currency_code") Long currencycode) {
		log.info("Fetching currency inr value with currency code " + currencycode);
		ResponseEntityPage responseEntityPage = currencyService.findById(currencycode);
        if (responseEntityPage.getStatusMessageResponseEntity().getCode() == "SUCCESS") {
            return new ResponseEntity<ResponseEntityPage>(responseEntityPage, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseEntityPage>(responseEntityPage, HttpStatus.NOT_FOUND);    
	}	
}
