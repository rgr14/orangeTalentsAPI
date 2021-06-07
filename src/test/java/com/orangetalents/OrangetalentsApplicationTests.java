package com.orangetalents;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.orangetalents.model.Car;

@SpringBootTest
class OrangetalentsApplicationTests {

	@Test
	void consumerAPI() {
		String marca = "Ford";
		
		String modelo = "Tal tal tal";
		
		int ano = 2015;
		
		RestTemplate template = new RestTemplate();
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("parallelum.com.br/fipe/api/v1")
				.path("/"+ marca + "/" +modelo+ "/" + ano)
				.build();
		
		ResponseEntity<Car> car = template.getForEntity(uri.toString(), Car.class);
		
		System.out.println(car.getBody().getAno());
	}

}
