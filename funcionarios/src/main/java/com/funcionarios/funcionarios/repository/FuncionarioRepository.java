package com.funcionarios.funcionarios.repository;
import com.funcionarios.funcionarios.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { // Cria a interface de repositório
    Funcionario findByCpf(String cpf); // Cria o método de busca por CPF

}