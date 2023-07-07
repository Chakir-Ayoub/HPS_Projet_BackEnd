package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.DetailDto;

public interface DetailsService {
	DetailDto AjouterDetail(DetailDto detailDto);
	DetailDto ModifierDetail(DetailDto detailDto);
	void SupperimerDetail(Long id);
	List<DetailDto> GetAllDetail();
}
