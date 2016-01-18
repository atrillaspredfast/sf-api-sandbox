package com.spredfast.api.sandbox.data;

import java.util.List;
import com.spredfast.api.sandbox.domain.SampleEntity;

public interface IServiceDao {
	List<SampleEntity> findAllEntities();
}
