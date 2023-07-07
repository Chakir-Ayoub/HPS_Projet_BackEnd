package com.example.hps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hps.dto.DetailDto;
import com.example.hps.repository.DetailRepository;
import com.example.hps.service.DetailsService;

public class DetailImpl implements DetailsService {
	
	@Autowired
	DetailRepository detailRepository;
	
	@Override
	public DetailDto AjouterDetail(DetailDto detailDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetailDto ModifierDetail(DetailDto detailDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupperimerDetail(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DetailDto> GetAllDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
