package currency.inrvalue.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
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
@RequestMapping(value={"/inrvalue"})
@Api(value = "CurrencyInrValue", description = "REST APIs Convert Currency into inr value!!!!")
public class CurrencyInrValue {

	@Autowired
	CurrencyService currencyService;
	
	/**
	 * This API is used to get Currency INR value using currency code and date.
	 * @author Venkatnarayan
	 * @param request
	 * @return
	 * @throws 
	 */
	@GetMapping(value = "/{currencycode}, {date}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get currency inr value by code in the System using code and date ", response = List.class, tags = "fetchcurrencyinrvalue")
	public ResponseEntity<ResponseEntityPage> getCurrencyInrValueByIdAndDate(@PathVariable("currencycode") Long currencycode, @PathVariable("date") String date) throws ParseException {
		LocalDate date01 = LocalDate.parse(date);  
		Date date1 = java.sql.Date.valueOf(date01);
		log.info("Fetching currency inr value with currency code " + currencycode);
		ResponseEntityPage responseEntityPage = currencyService.findByIdAndDate(currencycode,date1);
		if (responseEntityPage.getStatusMessageResponseEntity().getCode() == "SUCCESS") {
            return new ResponseEntity<ResponseEntityPage>(responseEntityPage, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseEntityPage>(responseEntityPage, HttpStatus.NOT_FOUND);    
	}
}
