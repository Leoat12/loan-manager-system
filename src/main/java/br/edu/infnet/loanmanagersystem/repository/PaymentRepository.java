package br.edu.infnet.loanmanagersystem.repository;

import br.edu.infnet.loanmanagersystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
