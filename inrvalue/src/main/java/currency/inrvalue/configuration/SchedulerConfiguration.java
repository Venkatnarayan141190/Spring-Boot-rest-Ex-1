package currency.inrvalue.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import currency.inrvalue.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Primary
public class SchedulerConfiguration {
	
	@Autowired
	CurrencyService currencyservice;
	
	//One minute : 	0 0/1 * 1/1 * ?
	//daily 12:01 : 0 1 12 1/1 * ? 	
	@Scheduled(cron = " 0 1 12 1/1 * ? ")
		public void run() {
		// TODO Auto-generated method stub
		log.info("inside scheduler");
		currencyservice.addCurrencyHistory();
	}

}
