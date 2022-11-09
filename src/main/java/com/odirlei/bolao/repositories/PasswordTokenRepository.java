package com.odirlei.bolao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odirlei.bolao.entities.PasswordResetToken;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    //PasswordResetToken findByToken(String token);

	 //PasswordResetToken findByUser(User user);

	 //Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

	 // void deleteByExpiryDateLessThan(Date now);

	 // @Modifying
	 // @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
    //void deleteAllExpiredSince(Date now);
	
	@Query("SELECT t FROM PasswordResetToken t JOIN t.user u WHERE u.id = :usuarioId")
	PasswordResetToken findByUserId(Long usuarioId);
}