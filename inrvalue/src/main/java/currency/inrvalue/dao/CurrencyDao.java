package currency.inrvalue.dao;

import java.util.Date;

import currency.inrvalue.responseentity.ResponseEntityPage;

public interface CurrencyDao {

	ResponseEntityPage findById(Long currencycode);
	ResponseEntityPage findByIdAndDate(Long currencycode, Date date);
	void addCurrencyHistory();

}
