package com.spredfast.api.sandbox.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spredfast.api.sandbox.data.IServiceDao;
import com.spredfast.api.sandbox.domain.SampleEntity;

@Service("sampleService")
public class SampleService implements ISampleService {

	@Autowired
	private IServiceDao serviceDao;

	@Override public List<SampleEntity> findAllEntities() {
		return serviceDao.findAllEntities();
	}
}
