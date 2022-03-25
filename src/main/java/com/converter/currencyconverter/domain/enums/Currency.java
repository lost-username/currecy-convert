package com.converter.currencyconverter.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Currency {
    BRL(1, "Real"),
    USD(2, "Dollar"),
    EUR(3,"Euro"),
    JPY(4, "Iens");

    private int cod;
	private String description;

    public static Currency toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (Currency x : Currency.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("ID invalid " + id);

	}
}
