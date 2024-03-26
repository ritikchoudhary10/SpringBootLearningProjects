package com.ritik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ritik.entity.Customer;
import com.ritik.repository.CustRepository;

@Service
public class CustServiceImpl implements ICustService {

	@Autowired
	private CustRepository repo;

	
	
	
	
}
