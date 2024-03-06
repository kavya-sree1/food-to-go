package com.foodtogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodtogo.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer>{
	Owner findByEmail(String email);

}
