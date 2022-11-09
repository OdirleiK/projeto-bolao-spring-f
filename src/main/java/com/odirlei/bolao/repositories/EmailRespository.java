package com.odirlei.bolao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odirlei.bolao.entities.Email;

public interface EmailRespository extends JpaRepository<Email, UUID>{

}
