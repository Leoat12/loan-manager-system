package br.edu.infnet.loanmanagersystem.controller;

import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.model.Payment;
import br.edu.infnet.loanmanagersystem.service.LoanContractService;
import br.edu.infnet.loanmanagersystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final LoanContractService loanContractService;
    private final PaymentService paymentService;

    @GetMapping("/pay-contract/{id}")
    public String paymentForm(@PathVariable("id") Integer transactionId, Model model) {

        LoanContract contract = loanContractService.findById(transactionId);

        Payment payment = new Payment();
        payment.setClient(contract.getClient());
        payment.setLoanContract(contract);

        model.addAttribute("payment", payment);

        return "loan-pay";
    }

    @PostMapping("/pay-contract")
    public String payContract(Model model, Payment payment) {

        try {
            paymentService.makePayment(payment);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("payment", payment);
            model.addAttribute("belowMinimum", true);
            return "loan-pay";
        }
        return "redirect:/";
    }

}
