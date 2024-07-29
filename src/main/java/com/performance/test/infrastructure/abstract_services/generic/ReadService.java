package com.performance.test.infrastructure.abstract_services.generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}
