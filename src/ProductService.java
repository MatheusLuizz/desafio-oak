import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void addProduto(Product product) {
        products.add(product);
    }

    public List<Product> getProdutosOrdenadosPorValor() {
        products.sort((p1, p2) -> Double.compare(p1.getValor(), p2.getValor()));
        return Collections.unmodifiableList(products);
    }
}

