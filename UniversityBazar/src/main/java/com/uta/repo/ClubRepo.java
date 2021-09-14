package com.uta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uta.dto.ClubDTO;

@Repository
public interface ClubRepo extends JpaRepository<ClubDTO, String> {

}
