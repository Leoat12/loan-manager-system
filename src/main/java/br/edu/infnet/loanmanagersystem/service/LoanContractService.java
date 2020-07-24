package br.edu.infnet.loanmanagersystem.service;

import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.repository.LoanContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanContractService {

    private final LoanContractRepository loanContractRepository;

    public List<LoanContract> findAll() {
        return loanContractRepository.findAll();
    }

}
