package com.funcionarios.funcionarios.controller;

import com.funcionarios.funcionarios.models.Funcionario;
import com.funcionarios.funcionarios.models.FuncionarioDTO;
import com.funcionarios.funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Define que a classe é um controlador
@RequestMapping("/api/funcionarios") // Define a rota do controlador
public class FuncionarioController { // Cria a classe controladora

    @Autowired // Injeta a classe de serviço
    private FuncionarioService funcionarioService; // Cria a variável de serviço

    @PostMapping
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) { // Cria o método de cadastro
        return funcionarioService.cadastrarFuncionario(funcionario); // Retorna o funcionário cadastrado
    }

    @PutMapping("/{cpf}/salario")
    public FuncionarioDTO calcularNovoSalario(@PathVariable String cpf) { // Cria o método de cálculo de salário
        return funcionarioService.calcularNovoSalario(cpf); // Retorna o funcionário com o novo salário
    }

    @GetMapping("/{cpf}/imposto-renda") //
    public ResponseEntity<String> calcularImpostoRenda(@PathVariable String cpf) { // Cria o método de cálculo de imposto de renda
            String impostoRenda = funcionarioService.calcularImpostoRenda(cpf); // Retorna o valor do imposto de renda
            if (impostoRenda.equals("Isento")) {// Verifica se o funcionário é isento
                return ResponseEntity.ok(impostoRenda); // Retorna o valor do imposto de renda
            } else {
                return ResponseEntity.ok("Imposto: R$ " + impostoRenda); // Retorna o valor do imposto de renda
            }
        }
    }
