package com.converter.currencyconverter.repository;

import java.util.List;

import com.converter.currencyconverter.domain.CurrencyConverter;
import com.converter.currencyconverter.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverter, Long>{

    List<CurrencyConverter> findCurrencyConverterByUser(User user);
    

}
