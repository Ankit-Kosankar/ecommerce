package com.ecom.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecom.dto.BrandDTO;
import com.ecom.model.Brand;
import com.ecom.repository.BrandRepository;
import com.ecom.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;
	private final ModelMapper modelMapper;
	public BrandServiceImpl(ModelMapper modelMapper,BrandRepository brandRepository) {
		this.modelMapper = modelMapper;
		this.brandRepository = brandRepository;
	}


	@Override
	public void addBrand(BrandDTO brandDTO) 
	{
		String message = "?";
		Brand brand = mapToBrand(brandDTO);
		Optional<Brand> byBrandName = brandRepository.findByBrandName(brandDTO.getBrandName());
		if(byBrandName.isPresent())
		{
			message = "Brand Already Exists";
			return;
		}
		brandRepository.save(brand);
	}
	
	
	private Brand mapToBrand(BrandDTO brandDTO)
	{
		return modelMapper.map(brandDTO, Brand.class);
	}

}
