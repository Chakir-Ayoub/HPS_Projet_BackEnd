package com.example.hps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hps.Exceptions.RestException;
import com.example.hps.dto.DetailDto;
import com.example.hps.entity.Detail;
import com.example.hps.repository.DetailRepository;
import com.example.hps.service.DetailsService;

@Service
public class DetailImpl implements DetailsService {
	
	@Autowired
	DetailRepository detailRepository;
	
	@Override
	public DetailDto AjouterDetail(DetailDto detailDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Detail detail=modelMapper.map(detailDto, Detail.class);
		LocalDate currentdate=LocalDate.now();
		detail.setDateCommentaire(currentdate);
		Detail detail2=detailRepository.save(detail);
		
		DetailDto detailDto2=modelMapper.map(detail2, DetailDto.class);
		return detailDto2;
	}

	@Override
	public DetailDto ModifierDetail(DetailDto detailDto,Long id) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		Detail detailcheck=detailRepository.findByiddetail(id);
		
		if(detailcheck==null) throw new RestException("Ce Detail n'existe pas ");
		
		Detail detailConvert=modelMapper.map(detailDto, Detail.class);
		
		detailcheck.setCommentaire(detailConvert.getCommentaire());
		detailcheck.setDoing(detailConvert.getDoing());
		detailcheck.setDone(detailConvert.getDone());
		detailcheck.setTodo(detailConvert.getTodo());
		detailcheck.setProjet(detailConvert.getProjet());
		detailcheck.setSession(detailConvert.getSession());
		
		Detail detailModifier=detailRepository.save(detailcheck);
		
		DetailDto detailDto_Converte_A_DTO=modelMapper.map(detailModifier, DetailDto.class);
		return detailDto_Converte_A_DTO;
	}

	@Override
	public void SupperimerDetail(Long id) {
		// TODO Auto-generated method stub
		Detail detailcheck=detailRepository.findByiddetail(id);
		
		if(detailcheck==null) throw new RestException("Ce Details n'existe pas");
		
		detailRepository.delete(detailcheck);

	}

	@Override
	public List<DetailDto> GetAllDetail() {
		// TODO Auto-generated method stub
		List<Detail> details;
		details=detailRepository.findAll();
		
		List<DetailDto> detailDtos=new ArrayList<>();
		for(Detail detail:details) {
			ModelMapper modelMapper=new ModelMapper();
			DetailDto detailDto=modelMapper.map(detail, DetailDto.class);
			
			detailDtos.add(detailDto);
		}
		return detailDtos;
	}

}
