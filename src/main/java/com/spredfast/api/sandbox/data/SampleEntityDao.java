package com.spredfast.api.sandbox.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.spredfast.api.sandbox.domain.SampleEntity;

@Repository("serviceDao")
public class SampleEntityDao implements IServiceDao {

	@Override
	public List<SampleEntity> findAllEntities() {
		return new ArrayList<>();
	}
}
