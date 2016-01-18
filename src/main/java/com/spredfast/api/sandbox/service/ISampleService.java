package com.spredfast.api.sandbox.service;

import java.util.List;
import com.spredfast.api.sandbox.domain.SampleEntity;

public interface ISampleService {
	List<SampleEntity> findAllEntities();
}
