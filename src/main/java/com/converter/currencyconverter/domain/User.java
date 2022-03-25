package com.converter.currencyconverter.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String name;
    private String email;

    @JsonIgnore 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<CurrencyConverter> currencyConverter = new ArrayList<>();
    
}
