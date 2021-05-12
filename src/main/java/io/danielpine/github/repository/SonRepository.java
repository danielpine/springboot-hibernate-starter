package io.danielpine.github.repository;


import io.danielpine.github.entity.Father;
import io.danielpine.github.entity.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

public interface SonRepository extends CrudRepository<Son, Long> {
}
