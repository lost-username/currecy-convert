package com.converter.currencyconverter.domain;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.converter.currencyconverter.domain.enums.Currency;

import lombok.Data;

@Entity
@Data
public class CurrencyConverter {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Currency fromCurrency; //moeda origem
    private Currency toCurrency; //moeda destino
    private Double amount; //ValorOrigem;
    private Double result;//ValorDestino;
    private Double rate; //receber da api http://api.exchangeratesapi.io/latest?base=EUR
    private ZonedDateTime hour; //setado no service



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
}
