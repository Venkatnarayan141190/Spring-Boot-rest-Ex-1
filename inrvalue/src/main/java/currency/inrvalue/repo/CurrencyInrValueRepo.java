package currency.inrvalue.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import currency.inrvalue.bean.CurrencyHistory;

@Repository
public interface CurrencyInrValueRepo extends CrudRepository<CurrencyHistory, Long>{

	
	@Query(value="select * from currency_history where currencycode_in_alpha=:currencycodeinalpha and createddate=:createddate",nativeQuery=true )
	public CurrencyHistory findByCurrencyAndDate(@Param("currencycodeinalpha")String currencycodeinalpha, @Param("createddate") Date createddate);
	//@Query(value="select * from currency_history where currencycode_in_alpha=:currencycodeinalpha",nativeQuery=true )
	//public CurrencyHistory findByCurrencyAndDate(@Param("currencycodeinalpha")String currencycodeinalpha);
	
	@Modifying(clearAutomatically = true)
	@Query(value="INSERT INTO CURRENCY_HISTORY(createddate,currencycode_in_alpha,inrvalue) VALUES(:date,:currencycodeinalpha,:inrvalue)",nativeQuery=true )
	public void addCurrencyHistory(@Param("date")Date date, @Param("currencycodeinalpha")String currencycodeinalpha, @Param("inrvalue")String inrvalue);

	
}
