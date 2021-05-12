package io.danielpine.github.projection;

import io.danielpine.github.entity.Father;
import io.danielpine.github.entity.Son;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "inlineFather", types = {Father.class})
public
interface InlineFather {

    Long getId();

    String getName();

    Set<Son> getSon();
}
