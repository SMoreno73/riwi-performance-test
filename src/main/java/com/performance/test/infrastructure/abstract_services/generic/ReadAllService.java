package com.performance.test.infrastructure.abstract_services.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable);
}
