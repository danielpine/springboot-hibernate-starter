package io.danielpine.github.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danielpine.github.entity.Teller;

public interface TellerRepository extends JpaRepository<Teller, Long> {
	public Optional<Teller> findById(Long id);
}
