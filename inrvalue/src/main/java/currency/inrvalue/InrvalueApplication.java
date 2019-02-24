package currency.inrvalue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages ="currency.inrvalue")
@EnableScheduling
@EnableJpaRepositories("currency.inrvalue.repo")
public class InrvalueApplication {

	public static void main(String[] args) {
		SpringApplication.run(InrvalueApplication.class, args);
	}

}
