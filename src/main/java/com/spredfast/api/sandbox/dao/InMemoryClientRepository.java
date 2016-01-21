package com.spredfast.api.sandbox.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import com.spredfast.api.sandbox.domain.Client;

public class InMemoryClientRepository implements ClientRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Client> clients = new ConcurrentHashMap<Long, Client>();

	@Override
	public Iterable<Client> findAll() {
		return this.clients.values();
	}

	@Override
	public Client save(Client client) {
		Long id = client.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			client.setId(id);
		}
		this.clients.put(id, client);
		return client;
	}

	@Override
	public Client findClient(Long id) {
		return this.clients.get(id);
	}

	@Override
	public void deleteClient(Long id) {
		this.clients.remove(id);
	}

}
