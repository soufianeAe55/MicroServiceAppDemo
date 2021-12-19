package com.example.customerservice;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.services.CustomerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerServices cs,CustomerRepository cr, RepositoryRestConfiguration repositoryRestConfiguration){
		repositoryRestConfiguration.exposeIdsFor(Customer.class);

		return args -> {
			cs.save(new CustomerRequestDto(null,"Mohammed","med@gmail.com"));
			cs.save(new CustomerRequestDto(null,"Mohammed2","med2@gmail.com"));
			cs.save(new CustomerRequestDto(null,"Mohammed3","med3@gmail.com"));
			cr.findAll().forEach(c->{
				System.out.println(c);
			});
		};
	}

}
