package currency.inrvalue.service;

import java.util.Date;

import currency.inrvalue.responseentity.ResponseEntityPage;


public interface CurrencyService {

	public ResponseEntityPage findById(Long id);
	public ResponseEntityPage findByIdAndDate(Long id, Date date);
	public void addCurrencyHistory();
}
