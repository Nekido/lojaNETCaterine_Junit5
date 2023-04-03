package service;

public class ValidacaoDeProdutosService {

    public void validarProdutoPorNome (String nome) throws Exception {
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Campo em branco, você deve digitar um nome de produto.");
        }
    }

    public void validarProdutoPorPreco (Double preco) throws Exception {
        if (preco == null || preco <= 0) {
            throw new Exception("Preço Inválido.");
        }
    }
}
