package com.converter.currencyconverter.service;

import com.converter.currencyconverter.domain.CurrencyConverter;
import com.converter.currencyconverter.domain.ExchangeRate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class ExchangeRatesApiService {

	private final String ACCESS_KEY = "fbb1d115d0f5b2250bf1d483f2066cf4&s";

		public void getExchangeRate(CurrencyConverter currencyConverter){

			final String TO_CURRENCY = currencyConverter.getToCurrency().toString();			
			
			RestTemplate restTemplate = new RestTemplate();

			UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("api.exchangeratesapi.io")
				.path("v1/latest")
				.queryParam("access_key", ACCESS_KEY)
				.queryParam("symbols", TO_CURRENCY)
				.queryParam("format", "1")		
				.build();				
			
			currencyConverter.setRate(restTemplate.getForEntity(uri.toString(), ExchangeRate.class)
												  .getBody()
												  .getRates()
												  .get(TO_CURRENCY));

		}    
}
