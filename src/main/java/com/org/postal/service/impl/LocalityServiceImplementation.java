package com.org.postal.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.postal.Repository.LocalityRepository;
import com.org.postal.modal.Locality;
import com.org.postal.modal.ResponseLocalityDTO;
import com.org.postal.service.LocalityService;


@Service
public class LocalityServiceImplementation implements LocalityService{
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalityServiceImplementation.class);
	
	@Autowired
	private LocalityRepository localityRepository;

	@Override
	public Locality save(Locality locality) throws Exception{
			LOG.info("locality details. postalCode=[{}] name=[{}]",locality.getPostalCode(),locality.getName());
			Locality local = localityRepository.save(new Locality(locality.getPostalCode(),locality.getName()));
			return local;
		
	}

	@Override
	public List<ResponseLocalityDTO> getLocalityDetails(int from, int to) throws Exception {
	
		List<Locality> pinCodeDetails = localityRepository.findByPostalCodeBetween(from,to);
		//pinCodeDetails.stream();
		List<ResponseLocalityDTO> result = pinCodeDetails.stream()
                .sorted(Comparator.comparing(Locality::getPostalCode))
                .collect(Collectors.groupingBy(Locality::getPostalCode))
                .entrySet().stream().map(e ->
                        new ResponseLocalityDTO(e.getKey(), e.getValue().stream().map(Locality::getName).sorted().collect(Collectors.toList())))
                .collect(Collectors.toList());
		return result;
	}

}
