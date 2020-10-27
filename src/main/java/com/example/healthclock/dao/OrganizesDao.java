package com.example.healthclock.dao;

import com.example.healthclock.entity.OrganizesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizesDao extends JpaRepository<OrganizesEntity,Integer> {
}
