package com.spredfast.api.sandbox.data;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.spredfast.api.sandbox.domain.SampleEntity;

@Repository("serviceDao")
public class SampleEntityDao implements IServiceDao {

	@Override
	public List<SampleEntity> findAllEntities() {
		return Arrays.asList(new SampleEntity("1", "FirstEntity"));
	}
}
