import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ValidacaoDeProdutosService;

public class ValidacaoDeProdutosServiceTest {

    private ValidacaoDeProdutosService service;

    @BeforeEach
    public void setUp() {
        service = new ValidacaoDeProdutosService();
    }

    @Test
    public void testValidarProdutoPorNomeThrowsException() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            service.validarProdutoPorNome("");
        });

        String expectedMessage = "Campo em branco, você deve digitar um nome de produto.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}

