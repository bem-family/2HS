package com.bem.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bem.domain.LocalAuth;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<LocalAuth, Long> {
	 LocalAuth findByUsername(String username);
}
