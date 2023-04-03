package service;
import model.Produtos;
import java.util.List;
import java.util.stream.Collectors;


public class ProdutosService {
    private List<Produtos> produtos;

    public ProdutosService(List<Produtos> produtos) {

    }


    public Produtos getProdutosPorId(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addProdutos(Produtos produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId().equals(produto.getId())) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    public  List<Produtos> getProdutosPorNome(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public List<Produtos> getProdutosPorPreco(double preco) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() == preco)
                .collect(Collectors.toList());
    }

    public void deleteProdutos(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }
}

