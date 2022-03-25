package com.converter.currencyconverter.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ExchangeRate {

    private String success;
    private String timestamp;
    private String base;
    private String date;   
    private Map<String, Double> rates = new HashMap<String, Double>();
    
}