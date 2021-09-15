package com.org.postal.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.postal.modal.Locality;
import com.org.postal.modal.ResponseLocalityDTO;
import com.org.postal.service.LocalityService;

@RestController
public class PostController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private LocalityService localityService;
	
	@PostMapping(value = "/australia/postal/save", produces = { "application/json" })
	public ResponseEntity<Locality> savePostalDetails(@RequestBody Locality locality) {
		LOG.info("Saving postal code and name details");	
		try {
			Locality local = localityService.save(locality);
			return new ResponseEntity<>(local,HttpStatus.CREATED);
		}catch(Exception e){
			LOG.error("saving postal Details =[{}] ",e.getMessage());	
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping(value = "/australia/locality/details",produces = {"application/json"})
	public ResponseEntity<List<ResponseLocalityDTO>>getLocalityDetails(@RequestParam Map<String,String> queryParameters){
		LOG.info("Getting locality Details within postal code range");	
		int fromLocality = Integer.parseInt(queryParameters.get("from"));
		int toLocality = Integer.parseInt(queryParameters.get("to"));
		LOG.info("From PostalCode=[{}] To Postal Code=[{}]",fromLocality,toLocality);
		try {
			List<ResponseLocalityDTO> local = localityService.getLocalityDetails(fromLocality, toLocality);
			return new ResponseEntity<>(local,HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
