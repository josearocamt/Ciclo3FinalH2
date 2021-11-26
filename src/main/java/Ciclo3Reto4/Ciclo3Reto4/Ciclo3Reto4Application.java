//1. modelo o entidad Ok
//2. interface
//3. repositorio
//4. servicios
//5. controlador o web
//repetir por cada tabla osea debe haber 25
package Ciclo3Reto4.Ciclo3Reto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Ciclo3Reto4.Ciclo3Reto4.Modelo"})
public class Ciclo3Reto4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Reto4Application.class, args);
	}

}
