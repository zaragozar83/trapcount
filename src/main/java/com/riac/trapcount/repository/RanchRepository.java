package com.riac.trapcount.repository;

import com.riac.trapcount.repository.model.RanchEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RanchRepository extends ReactiveCrudRepository<RanchEntity, String> {
}
