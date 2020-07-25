package br.edu.infnet.loanmanagersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.loanmanagersystem.model.Client;
import br.edu.infnet.loanmanagersystem.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}

}
