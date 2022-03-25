package com.converter.currencyconverter.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.converter.currencyconverter.domain.CurrencyConverter;
import com.converter.currencyconverter.domain.User;
import com.converter.currencyconverter.exception.ResourceNotFoundException;
import com.converter.currencyconverter.repository.CurrencyConverterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyConverterService {
   
    private final CurrencyConverterRepository currencyConverterRepository;    
    private final ExchangeRatesApiService exchangeratesApiService;   
    private final UserService userService;

     public CurrencyConverter findById(Long id) {
        return currencyConverterRepository.findById(id)
                                          .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    public List<CurrencyConverter> findByUserId(Long id) {
        User user = userService.findById(id);
        return currencyConverterRepository.findCurrencyConverterByUser(user);
    }


    @Transactional
    public CurrencyConverter save(CurrencyConverter currencyConverter){        

        User user = currencyConverter.getUser();
        User emailUser = userService.findByEmail(user.getEmail());

        if(emailUser != null){
            currencyConverter.getUser().setId(emailUser.getId());
        }

        userService.save(user);

        exchangeratesApiService.getExchangeRate(currencyConverter);
        
        Double result = currencyConverter.getAmount() * currencyConverter.getRate();     
        currencyConverter.setResult(result); 
        currencyConverter.setHour(ZonedDateTime.now());        

        return currencyConverterRepository.save(currencyConverter);
    }
}
