package currency.inrvalue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "currency_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyMasterEntity {

	@Id
	@Column(name = "currencycode")
	private Long currencycode;
	
	@Column(name= "currencycodeinalpha")
	private String currencycodeinalpha;
	
	@Column(name = "country")
	private String country;
	
}
