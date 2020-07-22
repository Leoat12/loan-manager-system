package br.edu.infnet.loanmanagersystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan_contract")
public class LoanContract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_client")
    private Client client;

    @Column(name = "date_loan_given")
    private LocalDate dateLoanGiven;

    @Column(name = "amount_given")
    private Double amountGiven;

    @Column(name = "interest_rate")
    private Double interestRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_collector")
    private Collector collector;
}
