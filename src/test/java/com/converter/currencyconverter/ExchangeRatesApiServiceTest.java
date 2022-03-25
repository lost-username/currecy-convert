package com.converter.currencyconverter;

import com.converter.currencyconverter.domain.ExchangeRate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ExchangeRatesApiServiceTest {

    private final String ACCESS_KEY = "fbb1d115d0f5b2250bf1d483f2066cf4&s";
	

    @Test
	public void consumeAPI() {
		RestTemplate restTemplate = new RestTemplate();
		//http://api.exchangeratesapi.io/v1/latest?access_key=fbb1d115d0f5b2250bf1d483f2066cf4&symbols=USD,AUD,CAD,PLN,MXN&format=1
		

		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("http")
		.host("api.exchangeratesapi.io")
		.path("v1/latest")
		.queryParam("access_key", ACCESS_KEY)
		.queryParam("symbols", "USD,AUD,CAD,PLN,MXN")
		.queryParam("format", "1")		
		.build();

		ResponseEntity<ExchangeRate> forEntity = restTemplate.getForEntity(uri.toString(), ExchangeRate.class);

		log.info("getSuccess ----------> {}", forEntity.getBody().getSuccess());
		log.info("getRates ----------> {}",  forEntity.getBody().getRates());

		//assertTrue();
	}
    
}
