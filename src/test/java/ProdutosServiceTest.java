import model.Produtos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.ProdutosService;
import service.ValidacaoDeProdutosService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProdutosServiceTest {

    private ProdutosService service;

    @Mock
    private ValidacaoDeProdutosService validacaoService;

    @BeforeEach
    public void setUp() {
        List<Produtos> produtos = new ArrayList<>();
        produtos.add(new Produtos(1L, "Alexa", 790.0));
        produtos.add(new Produtos(2L, "Iphone", 14.000));
        produtos.add(new Produtos(3L, "Jaqueta", 100.0));
        service = new ProdutosService(produtos);
    }

    @Test
    public void testGetProdutosPorId() {
        Produtos produto = service.getProdutosPorId(2L);
        assertEquals("Produto 2", produto.getNome());
        assertEquals(20.0, produto.getPreco());
    }

    @Test
    public boolean testGetProdutosPorNome() {

        ValidacaoDeProdutosService validacaoMock = mock(ValidacaoDeProdutosService.class);
        when(validacaoMock.validarProdutoPorNome("Alexa")).thenReturn(true);
        service.getProdutosPorNome("Alexa");
        List<Produtos> resultado = service.getProdutosPorNome("Alexa");


        assertEquals(1, resultado.size());
        assertEquals("Alexa", resultado.get(0).getNome());
    }

}
                     //AQUI DE FATO NÃO CONSEGUI AVANÇAR NEM COM PESQUISAS.


