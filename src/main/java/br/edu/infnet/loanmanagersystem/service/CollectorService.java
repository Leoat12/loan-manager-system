package br.edu.infnet.loanmanagersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.loanmanagersystem.model.Collector;
import br.edu.infnet.loanmanagersystem.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollectorService {
	
	private final CollectorRepository collectorRepository;
	
	public List<Collector> findAll(){
		return collectorRepository.findAll();
	}

}
