package com.converter.currencyconverter.controller;

import java.util.List;

import com.converter.currencyconverter.domain.CurrencyConverter;
import com.converter.currencyconverter.dto.CurrencyConverterDTO;
import com.converter.currencyconverter.service.CurrencyConverterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/convert")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConverterController {

    private final CurrencyConverterService currencyConverterService;

    //@ApiOperation(value = "")
    @PostMapping(path = "/new")
    public ResponseEntity<CurrencyConverterDTO> save(@RequestBody CurrencyConverter currencyConverter) {
        return new ResponseEntity<>(new CurrencyConverterDTO()
                    .toDto(currencyConverterService.save(currencyConverter)), HttpStatus.CREATED);
    } 

    //@ApiOperation(value = "")
    @GetMapping(path = "/findby/{id}")
	public ResponseEntity<CurrencyConverter> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(currencyConverterService.findById(id));
	} 

    //@ApiOperation(value = "")
    @GetMapping(path = "/findbyuser/{id}")
	public ResponseEntity<List<CurrencyConverter>> findByUserId(@PathVariable Long id) {
        return ResponseEntity.ok().body(currencyConverterService.findByUserId(id));

	}
    
}
