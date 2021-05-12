package io.danielpine.github.repository;


import io.danielpine.github.entity.Father;
import io.danielpine.github.projection.InlineFather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = InlineFather.class)
public interface FatherRepository extends CrudRepository<Father, Long> {
}
