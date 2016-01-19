package com.spredfast.api.sandbox.dao;

import java.util.List;
import com.spredfast.api.sandbox.domain.SampleEntity;

public interface IServiceDao {
	List<SampleEntity> findAllEntities();
}
