package com.funcionarios.funcionarios.service;

import com.funcionarios.funcionarios.models.Funcionario;
import com.funcionarios.funcionarios.models.FuncionarioDTO;
import com.funcionarios.funcionarios.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService { // Cria a classe de serviço

    @Autowired
    private FuncionarioRepository funcionarioRepository; // Cria a variável de repositório


    public Funcionario cadastrarFuncionario(Funcionario funcionario) { // Cria o método de cadastro
        return funcionarioRepository.save(funcionario); // Salva o funcionário no banco de dados
    }

    @Transactional // Define que o método é transacional
    public FuncionarioDTO calcularNovoSalario(String cpf) { // Cria o método de cálculo de salário
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf); // Busca o funcionário pelo CPF
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não encontrado"); // Lança uma exceção caso o funcionário não seja encontrado
        }

        double salarioAtual = funcionario.getSalario(); // Pega o salário atual do funcionário
        double novoSalario; // Cria a variável para o novo salário
        double percentualReajuste; // Cria a variável para o percentual de reajuste
        if (salarioAtual <= 400) { // Verifica se o salário é menor ou igual a 400
            novoSalario = salarioAtual * 1.15; // Calcula o novo salário com a taxa de 15%
            percentualReajuste = 15; // Define o percentual de reajuste
        } else if (salarioAtual <= 800) { // Verifica se o salário é menor ou igual a 800
            novoSalario = salarioAtual * 1.12; // Calcula o novo salário com a taxa de 12%
            percentualReajuste = 12; // Define o percentual de reajuste
        } else if (salarioAtual <= 1200) { // Verifica se o salário é menor ou igual a 1200
            novoSalario = salarioAtual * 1.10; // Calcula o novo salário com a taxa de 10%
            percentualReajuste = 10; // Define o percentual de reajuste
        } else if (salarioAtual <= 2000){ // Verifica se o salário é menor ou igual a 2000
            novoSalario = salarioAtual * 1.07; // Calcula o novo salário com a taxa de 7%
            percentualReajuste = 7; // Define o percentual de reajuste
        } else {
            novoSalario = salarioAtual * 1.04; // Calcula o novo salário com a taxa de 4%
            percentualReajuste = 4; // Define o percentual de reajuste
        }

        double valorReajuste = novoSalario - salarioAtual; // Calcula o valor do reajuste do salário do funcionário em relação ao salário atual

        funcionario.setSalario(novoSalario); // Define o novo salário do funcionário
        funcionarioRepository.save(funcionario); // Salva o funcionário no banco de dados

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(); // Cria um objeto de transferência de dados
        funcionarioDTO.setCpf(funcionario.getCpf()); // Define o CPF do funcionário no objeto de transferência de dados
        funcionarioDTO.setNovoSalario(novoSalario);
        funcionarioDTO.setValorReajuste(valorReajuste);
        funcionarioDTO.setPercentualReajuste(percentualReajuste);
        return funcionarioDTO; // Retorna o objeto de transferência de dados
    }

    @Transactional // Define que o método é transacional
    public String calcularImpostoRenda(String cpf) { // Cria o método de cálculo de imposto de renda
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf); // Busca o funcionário pelo CPF
        if (funcionario == null) { // Verifica se o funcionário foi encontrado
            throw new IllegalArgumentException("Funcionário não encontrado"); // Lança uma exceção caso o funcionário não seja encontrado
        }

        double salario = funcionario.getSalario(); // Pega o salário do funcionário
        if (salario <= 2000) { // Verifica se o salário é menor ou igual a 2000
            return "Isento"; // Retorna que o funcionário está isento de imposto de renda
        } else { // Caso o salário seja maior que 2000
            double impostoRenda; // Cria a variável do imposto de renda
            if(salario > 2000 && salario <= 3000){ // Verifica se o salário está entre 2000 e 3000
                impostoRenda = (salario - 2000) * 0.08; // Calcula o imposto de renda com base no salário e taxa de 8%
            }else if(salario > 3000 && salario <= 4500){ // Verifica se o salário está entre 3000 e 4500
                impostoRenda = (1000 * 0.08) + ((salario - 3000) * 0.18); // Calcula o imposto de renda com base no salário e taxa de 18%
            }else{
                impostoRenda = (1000 * 0.08) + (1500 * 0.18) + ((salario - 4500) * 0.28); // Calcula o imposto de renda com base no salário e taxa de 28%
            }

            return "Imposto: R$ " + String.format("%.2f", impostoRenda); // Retorna o imposto de renda do funcionário
        }
    }

}