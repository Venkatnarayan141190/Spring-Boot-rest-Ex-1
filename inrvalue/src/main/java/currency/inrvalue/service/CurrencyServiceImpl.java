package currency.inrvalue.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import currency.inrvalue.dao.CurrencyDao;
import currency.inrvalue.responseentity.ResponseEntityPage;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyDao currencyDao;
	
	@Override
	public ResponseEntityPage findById(Long currencycode) {
		log.info("in get find currency inr value using currency code");
		ResponseEntityPage responseEntityPage = currencyDao.findById(currencycode);
		return responseEntityPage;
	}

	@Override
	public ResponseEntityPage findByIdAndDate(Long currencycode, Date date) {
		System.out.println("in get find currency inr value using currency code and date");
		return currencyDao.findByIdAndDate(currencycode,date);
	}

	@Override
	public void addCurrencyHistory() {
		// TODO Auto-generated method stub
		currencyDao.addCurrencyHistory();
	}
	
	

}
