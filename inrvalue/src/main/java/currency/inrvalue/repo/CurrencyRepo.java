package currency.inrvalue.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import currency.inrvalue.bean.CurrencyMasterEntity;

@Repository
public interface CurrencyRepo extends CrudRepository<CurrencyMasterEntity, Long>{

	@Query(value="SELECT * FROM CURRENCY_MASTER WHERE CURRENCYCODE=:currencycode",nativeQuery=true )
	public CurrencyMasterEntity findById(@Param("currencycode")Long name);

	@Modifying(clearAutomatically = true)
	@Query(value="INSERT INTO CURRENCY_MASTER(currencycode,country,currencycodeinalpha) VALUES(:currencycode,:country,:currencyinalpha)",nativeQuery=true )
	public void addCurrencyMaster(@Param("currencycode")Long name, @Param("country")String country, @Param("currencyinalpha")String currencyinalpha);

}
