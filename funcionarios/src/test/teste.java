import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository repository;

    @InjectMocks
    private FuncionarioService service;

    @Test
    public void testCalcularNovoSalario() {
        Funcionario funcionario = new Funcionario("John Doe", "123.456.789-10", LocalDate.of(2000, 1, 1), "555-5555", "Rua 1", 1000.0);

        when(repository.findByCpf("123.456.789-10")).thenReturn(funcionario);

        Funcionario result = service.calcularNovoSalario("123.456.789-10");

        assertEquals(1100.0, result.getSalario(), 0.1);
    }
}