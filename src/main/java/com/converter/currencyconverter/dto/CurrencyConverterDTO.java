package com.converter.currencyconverter.dto;

import java.time.ZonedDateTime;

import com.converter.currencyconverter.domain.CurrencyConverter;
import com.converter.currencyconverter.domain.enums.Currency;

import lombok.Data;


@Data
public class CurrencyConverterDTO {

    private Long id;
    private Currency fromCurrency;
    private Currency toCurrency; 
    private Double amount;
    private Double result;
    private Double rate;
    private ZonedDateTime hour;
    private Long idUser;

    public CurrencyConverterDTO toDto(CurrencyConverter currencyConverter) {

       this.id =  currencyConverter.getId();
       this.fromCurrency = currencyConverter.getFromCurrency();
       this.toCurrency = currencyConverter.getToCurrency();
       this.amount = currencyConverter.getAmount();
       this.result = currencyConverter.getResult();
       this.rate = currencyConverter.getRate();
       this.hour = currencyConverter.getHour();
       this.idUser = currencyConverter.getUser().getId();

       return this;
    
    }
    
    
}

