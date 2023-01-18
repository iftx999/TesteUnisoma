package com.funcionarios.funcionarios;

import com.funcionarios.funcionarios.models.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class FuncionariosApplicationTests {
	@Test
	public void testCalcularImpostoRenda() {
		// Cria um funcionário de teste
		Funcionario funcionario = new Funcionario(); // Cria um funcionário
		funcionario.setCpf("000.000.000-00"); // Define o CPF do funcionário
		funcionario.setSalario(3000); // Define o salário do funcionário

	}
}