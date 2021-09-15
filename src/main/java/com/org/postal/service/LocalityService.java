package com.org.postal.service;

import java.util.List;

import com.org.postal.modal.Locality;
import com.org.postal.modal.ResponseLocalityDTO;

public interface LocalityService {

		public Locality save(Locality locality) throws Exception;
		public List<ResponseLocalityDTO> getLocalityDetails(int from, int to) throws Exception;
}
