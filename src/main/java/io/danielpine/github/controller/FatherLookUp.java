package io.danielpine.github.controller;

import io.danielpine.github.repository.FatherRepository;
import org.springframework.data.rest.core.config.EntityLookupRegistrar;

public class FatherLookUp implements EntityLookupRegistrar.LookupRegistrar.Lookup<FatherRepository, Long> {
    @Override
    public Object lookup(FatherRepository repository, Long identifier) {
        return null;
    }
}
