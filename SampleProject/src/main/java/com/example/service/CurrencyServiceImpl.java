package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Currency;
import com.example.repository.CurrencyRepository;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	@Transactional
	public Currency save(Currency currency) {
		if (currency.getId() == null) {
			currency.setId(UUID.randomUUID().toString());
		}
		currency = currencyRepository.save(currency);
		return currency;
	}

	@Override
	@Transactional
	public void delete(Currency currency) {
		currencyRepository.delete(currency);
	}

	@Override
	public Currency findByName(String name) {
		return currencyRepository.findByName(name);
	}
}