package com.in28minutes.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.web.model.SongsDetails;

import antlr.collections.List;

public interface SongsRepository extends JpaRepository<SongsDetails, Integer>{



	

	
}