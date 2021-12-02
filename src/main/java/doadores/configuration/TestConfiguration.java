package doadores.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import doadores.entities.Doadores;
import doadores.repositories.DoadoresRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{

	@Autowired
	private DoadoresRepository doadoresRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Doadores d1 = new Doadores(null, "Maria", "37000077733", 35, 1.60, 60.5, "F", "A+", "São Paulo", null);
		Doadores d2 = new Doadores(null, "João", "37000088855", 40, 1.80, 80.5, "M", "B+", "São Paulo", null);
		doadoresRepository.saveAll(Arrays.asList(d1, d2));
	}
	
}
