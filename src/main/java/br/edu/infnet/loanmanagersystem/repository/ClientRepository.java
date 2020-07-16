package br.edu.infnet.loanmanagersystem.repository;

import br.edu.infnet.loanmanagersystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
