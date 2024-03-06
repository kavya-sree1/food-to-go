package com.foodtogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtogo.model.Owner;
import com.foodtogo.repository.OwnerRepository;

@Service
public class OwnerServiceImp implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	public Owner findByEmail(String email) {
		return ownerRepository.findByEmail(email);
	}
}
