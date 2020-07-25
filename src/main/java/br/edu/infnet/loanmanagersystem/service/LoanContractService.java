package br.edu.infnet.loanmanagersystem.service;

import br.edu.infnet.loanmanagersystem.exception.ClientNotFoundException;
import br.edu.infnet.loanmanagersystem.exception.CollectorNotFoundException;
import br.edu.infnet.loanmanagersystem.exception.LoanContractNotFoundException;
import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.repository.ClientRepository;
import br.edu.infnet.loanmanagersystem.repository.CollectorRepository;
import br.edu.infnet.loanmanagersystem.repository.LoanContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanContractService {

    private final LoanContractRepository loanContractRepository;
    private final ClientRepository clientRepository;
    private final CollectorRepository collectorRepository;

    public LoanContract findById(Integer transactionId) {
        return loanContractRepository.findById(transactionId)
                .orElseThrow(LoanContractNotFoundException::new);
    }

    public List<LoanContract> findAll() {
        return loanContractRepository.findAll();
    }

    public LoanContract registerLoanContract(Integer clientId, Integer collectorId,
                                             Double amountGiven, Double interestRate) {

        LoanContract contract = LoanContract.builder()
                .client(clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new))
                .collector(collectorRepository.findById(collectorId).orElseThrow(CollectorNotFoundException::new))
                .amountGiven(amountGiven)
                .interestRate(interestRate)
                .dateLoanGiven(LocalDate.now())
                .build();

        return loanContractRepository.save(contract);
    }
}
