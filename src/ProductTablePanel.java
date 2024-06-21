import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductTablePanel extends JPanel {
    private JTable table;
    private ProductService productService;
    private ProductFrame productFrame;

    public ProductTablePanel(ProductService productService, ProductFrame productFrame) {
        this.productService = productService;
        this.productFrame = productFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton novoProdutoButton = new JButton("Novo Produto");
        novoProdutoButton.addActionListener(e -> productFrame.mostrarFormulario());
        add(novoProdutoButton, BorderLayout.SOUTH);

        atualizarTabela();
    }

    public void atualizarTabela() {
        List<Product> products = productService.getProdutosOrdenadosPorValor();
        String[] colunas = {"Nome", "Valor"};
        Object[][] dados = new Object[products.size()][2];
        for (int i = 0; i < products.size(); i++) {
            dados[i][0] = products.get(i).getNome();
            dados[i][1] = products.get(i).getValor();
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        table.setModel(model);
    }
}
