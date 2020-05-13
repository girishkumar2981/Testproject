package com.cg.anurag.b2.imsdd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.anurag.b2.imsdd.dto.DisplayDistributor;

@Repository
public interface DisplayDistributorDAO extends JpaRepository<DisplayDistributor,String> {

}
