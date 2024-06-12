package br.com.cristianoAbudu.teste.testeConsumingJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TesteConsumingJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteConsumingJsonApplication.class, args);
	}

}
