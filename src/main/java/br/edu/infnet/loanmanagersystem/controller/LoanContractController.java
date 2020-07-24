package br.edu.infnet.loanmanagersystem.controller;

import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.service.LoanContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanContractController {

    private final LoanContractService loanContractService;

    @GetMapping
    public String loanContractList(Model model) {

        List<LoanContract> loanContracts = loanContractService.findAll();

        model.addAttribute("contracts", loanContracts);

        return "loan-list";
    }

}
