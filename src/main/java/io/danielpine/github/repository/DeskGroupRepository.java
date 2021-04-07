package io.danielpine.github.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.danielpine.github.entity.DeskGroup;

public interface DeskGroupRepository extends JpaRepository<DeskGroup, Long> {
    public Optional<DeskGroup> findById(Long id);

    @EntityGraph(value = "desk.teller", type = EntityGraphType.FETCH)
    public DeskGroup findOneById(Long id);

    @EntityGraph(attributePaths = {"desk.teller"})
    @Query("from DeskGroup")
    public List<DeskGroup> findAllWithEG();

    @EntityGraph(attributePaths = {"desk"})
    @Query("from DeskGroup")
    public List<DeskGroup> findAllWithEG2();
}
