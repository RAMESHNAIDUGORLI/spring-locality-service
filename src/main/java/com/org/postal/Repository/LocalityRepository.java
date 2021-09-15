package com.org.postal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.postal.modal.Locality;

public interface LocalityRepository extends JpaRepository<Locality,Long> {


	List<Locality> findByPostalCodeBetween(int from, int to);

}
