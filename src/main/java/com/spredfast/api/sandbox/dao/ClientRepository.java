package com.spredfast.api.sandbox.dao;

import com.spredfast.api.sandbox.domain.Client;

public interface ClientRepository {

	Iterable<Client> findAll();

	Client save(Client client);

	Client findClient(Long id);

	void deleteClient(Long id);

}
