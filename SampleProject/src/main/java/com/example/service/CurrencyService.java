package com.example.service;

import com.example.model.Currency;

public interface CurrencyService {
	Currency save(Currency currency);

	void delete(Currency currency);

	Currency findByName(String name);
}
