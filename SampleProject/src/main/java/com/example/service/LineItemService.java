package com.example.service;

import java.util.List;

import com.example.model.LineItem;

public interface LineItemService {
	List<LineItem> save(List<LineItem> lineItemList);
	
	LineItem save(LineItem lineItem);

	void delete(LineItem lineItem);
	
	LineItem findById(String id);

	List<LineItem> findByEngineIdOrderByNoAsc(String engineId);

	List<LineItem> findByEngineIdAndActivityTypeOrderByNoAsc(String engineId, String activityType);

	LineItem findByIdAndEngineId(String lineItemId, String engineId);

	List<LineItem> findAll();

	List<LineItem> findByEngineIdAndNoGreaterThan(String engineId, Integer no);
	
	List<LineItem> findBySectionIdOrderByNoAsc(String sectionId);

	void SetLineItemListNo(List<LineItem> lineItems, Integer startIndex, Integer distance);

	void SetLineItemListNo(List<LineItem> lineItems);
}
