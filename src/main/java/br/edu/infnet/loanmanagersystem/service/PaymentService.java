package br.edu.infnet.loanmanagersystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.loanmanagersystem.model.Payment;
import br.edu.infnet.loanmanagersystem.model.PaymentType;
import br.edu.infnet.loanmanagersystem.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
		
	
	public Payment makePayment(Payment payment) {
		
		List<Payment> previousPayments = paymentRepository.findAllByLoanContract(payment.getLoanContract());
		
		Double amountPayd = 0.00; 
		
		for(Payment pay : previousPayments) {
			amountPayd += pay.getAmount();
		}
		
		Double due =  payment.getLoanContract().getAmountGiven() - amountPayd;
				
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
