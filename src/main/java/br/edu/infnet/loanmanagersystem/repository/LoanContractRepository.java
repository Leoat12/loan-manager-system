package br.edu.infnet.loanmanagersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.loanmanagersystem.model.LoanContract;

@Repository
public interface LoanContractRepository extends JpaRepository<LoanContract, Integer> {
}
