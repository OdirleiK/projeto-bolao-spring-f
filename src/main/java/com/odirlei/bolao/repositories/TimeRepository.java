package com.odirlei.bolao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.odirlei.bolao.entities.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{

	@Query("SELECT t FROM Time t WHERE t.grupo = ?1")
	List<Time> findGrupo(String grupo);

}
