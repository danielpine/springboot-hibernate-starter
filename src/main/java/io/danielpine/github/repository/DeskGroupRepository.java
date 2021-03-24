package io.danielpine.github.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danielpine.github.entity.DeskGroup;

public interface DeskGroupRepository extends JpaRepository<DeskGroup, Long> {
	public Optional<DeskGroup> findById(Long id);
}
