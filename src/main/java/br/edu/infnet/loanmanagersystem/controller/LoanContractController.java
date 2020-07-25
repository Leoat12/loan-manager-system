package br.edu.infnet.loanmanagersystem.controller;

import br.edu.infnet.loanmanagersystem.model.Client;
import br.edu.infnet.loanmanagersystem.model.Collector;
import br.edu.infnet.loanmanagersystem.model.LoanContract;
import br.edu.infnet.loanmanagersystem.service.ClientService;
import br.edu.infnet.loanmanagersystem.service.CollectorService;
import br.edu.infnet.loanmanagersystem.service.LoanContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanContractController {
	
	private final ClientService clientService;

    private final LoanContractService loanContractService;
    
    private final CollectorService collectorService;

    @GetMapping
    public String loanContractList(Model model) {

        List<LoanContract> loanContracts = loanContractService.findAll();

        model.addAttribute("contracts", loanContracts);

        return "loan-list";
    }
    
    @GetMapping("/cadastro")
    public String form(Model model) {
    	List<Client> clients = clientService.findAll();
    	model.addAttribute("clients", clients);
    	
    	List<Collector> collectors = collectorService.findAll();
    	model.addAttribute("collectors", collectors);
    	
    	return "loan-cad";
    }

}
