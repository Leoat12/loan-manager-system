package br.edu.infnet.loanmanagersystem.service;

import br.edu.infnet.loanmanagersystem.exception.LoanContractNotFoundException;
import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.model.Payment;
import br.edu.infnet.loanmanagersystem.model.PaymentType;
import br.edu.infnet.loanmanagersystem.repository.LoanContractRepository;
import br.edu.infnet.loanmanagersystem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	private final LoanContractRepository loanContractRepository;

	public Payment makePayment(Payment payment) {
		
		List<Payment> previousPayments = paymentRepository.findAllByLoanContract(payment.getLoanContract());
		LoanContract loanContract = loanContractRepository.findById(payment.getLoanContract().getTransactionId())
				.orElseThrow(LoanContractNotFoundException::new);
		
		Double amountPaid = 0.00;
		
		for(Payment pay : previousPayments) {
			amountPaid += pay.getAmount();
		}
		
		Double due =  loanContract.getAmountGiven() - amountPaid;
				
		Double interestValue = due * (loanContract.getInterestRate() / 100);
		if(payment.getAmount() < interestValue) {
			throw new IllegalArgumentException("The minimum value for payment is the interest value of the total due");
		}

		if(Double.compare(payment.getAmount() , interestValue) == 0) {
			payment.setPaymentType(PaymentType.INTEREST);
		}
		
		if(payment.getAmount() > interestValue 
				&& payment.getAmount() < due ) {
			payment.setPaymentType(PaymentType.PARTIAL);
		}		
		
		if(Double.compare(payment.getAmount() , due) == 0) {
			payment.setPaymentType(PaymentType.TOTAL);
		}

		payment.setPaymentDate(LocalDate.now());
		payment.setPaymentMonth(payment.getPaymentDate().getMonthValue());

		return paymentRepository.save(payment);
	}
	
}
