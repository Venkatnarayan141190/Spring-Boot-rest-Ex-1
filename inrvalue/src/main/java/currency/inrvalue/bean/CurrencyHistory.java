package currency.inrvalue.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "currency_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name ="currencycode_in_alpha")
	private String currencycodeinalpha;
	
	@Column (name ="inrvalue")
	private String inrvalue;
	
	@Column (name = "createddate")
	private Date createddate;
	
}
