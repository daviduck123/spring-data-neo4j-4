package com.example.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Currency;

public interface CurrencyRepository extends GraphRepository<Currency> {
	Currency findByName(String name);
}
