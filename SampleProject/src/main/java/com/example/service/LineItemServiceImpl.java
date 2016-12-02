package com.example.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.LineItem;
import com.example.repository.LineItemRepository;

@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemRepository lineItemRepository;

	@Override
	@Transactional
	public LineItem save(LineItem lineItem) {
		if (lineItem.getId() == null) {
			lineItem.setId(UUID.randomUUID().toString());
		}
		lineItem = lineItemRepository.save(lineItem);
		return lineItem;
	}

	@Override
	@Transactional
	public List<LineItem> save(List<LineItem> lineItemList) {
		for (LineItem lineItem : lineItemList) {
			if (lineItem.getId() == null) {
				lineItem.setId(UUID.randomUUID().toString());
			}
		}
		lineItemList = (List<LineItem>) lineItemRepository.save(lineItemList);
		return lineItemList;
	}

	@Override
	@Transactional
	public void delete(LineItem lineItem) {
		lineItemRepository.delete(lineItem);
	}

	@Override
	public List<LineItem> findByEngineIdOrderByNoAsc(String engineId) {
		List<LineItem> lineItemList = lineItemRepository.findByEngineIdOrderByNoAsc(engineId);
		Collections.sort(lineItemList, LineItem.Comparators.NO);
		return lineItemList;
	}

	@Override
	public List<LineItem> findByEngineIdAndActivityTypeOrderByNoAsc(String engineId, String activityType) {
		List<LineItem> lineItemList = lineItemRepository.findByEngineIdAndActivityTypeOrderByNoAsc(engineId, activityType);
		Collections.sort(lineItemList, LineItem.Comparators.NO);
		return lineItemList;
	}

	@Override
	public LineItem findById(String id) {
		return lineItemRepository.findById(id);
	}

	@Override
	public LineItem findByIdAndEngineId(String lineItemId, String engineId) {
		return lineItemRepository.findByIdAndEngineId(lineItemId, engineId);
	}

	@Override
	public List<LineItem> findAll() {
		return lineItemRepository.findAll();
	}

	@Override
	public List<LineItem> findByEngineIdAndNoGreaterThan(String engineId, Integer no) {
		return lineItemRepository.findByEngineIdAndNoGreaterThan(engineId, no);
	}

	@Override
	public void SetLineItemListNo(List<LineItem> lineItems, Integer startIndex, Integer distance) {
		for (LineItem lineItem : lineItems) {
			if (lineItem.getNo() >= startIndex) {
				lineItem.setNo(lineItem.getNo() + distance);
			}
		}
	}

	@Override
	public void SetLineItemListNo(List<LineItem> lineItems) {
		for (int i = 0; i < lineItems.size(); i++) {
			LineItem lineItem = lineItems.get(i);
			Integer currentNo = i + 1;
			if (lineItem.getNo() != currentNo) {
				lineItem.setNo(currentNo);
			}
		}
	}

	@Override
	public List<LineItem> findBySectionIdOrderByNoAsc(String sectionId) {
		return lineItemRepository.findBySectionIdOrderByNoAsc(sectionId);
	}
}