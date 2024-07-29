package com.performance.test.infrastructure.abstract_services.generic;

public interface DeleteService<Id> {
    void delete(Id id);
}
