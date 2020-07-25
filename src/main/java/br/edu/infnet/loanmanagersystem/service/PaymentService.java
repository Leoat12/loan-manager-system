package br.edu.infnet.loanmanagersystem.service;

import br.edu.infnet.loanmanagersystem.model.Payment;
import br.edu.infnet.loanmanagersystem.model.PaymentType;
import br.edu.infnet.loanmanagersystem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	public Payment makePayment(Payment payment) {
		
		List<Payment> previousPayments = paymentRepository.findAllByLoanContract(payment.getLoanContract());
		
		Double amountPaid = 0.00;
		
		for(Payment pay : previousPayments) {
			amountPaid += pay.getAmount();
		}
		
		Double due =  payment.getLoanContract().getAmountGiven() - amountPaid;
				
		Double interestValue = due * (payment.getLoanContract().getInterestRate() / 100);
		System.out.println("due " + due);
		System.out.println("interestValue " + interestValue);
		System.out.println("amount " + payment.getAmount());
		if(payment.getAmount() < interestValue) {
			throw new IllegalArgumentException("The minumum value for payment is the interest value of the total due");
		}

		if(Double.compare(payment.getAmount() , interestValue) == 0) {
			System.out.println("interest");
			payment.setPaymentType(PaymentType.INTEREST);
		}
		
		if(payment.getAmount() > interestValue 
				&& payment.getAmount() < due ) {
			payment.setPaymentType(PaymentType.PARTIAL);
		}		
		
		if(Double.compare(payment.getAmount() , due) == 0) {
			payment.setPaymentType(PaymentType.TOTAL);
		}
			
		return paymentRepository.save(payment);
	}
	
}
