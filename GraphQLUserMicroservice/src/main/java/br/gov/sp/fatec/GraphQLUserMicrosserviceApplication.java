package br.gov.sp.fatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class GraphQLUserMicrosserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQLUserMicrosserviceApplication.class, args);
	}

}
