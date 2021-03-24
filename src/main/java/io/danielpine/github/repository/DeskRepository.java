package io.danielpine.github.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danielpine.github.entity.Desk;

public interface DeskRepository extends JpaRepository<Desk, Long> {
	public Optional<Desk> findById(Long id);
}
