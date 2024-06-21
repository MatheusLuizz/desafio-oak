import javax.swing.*;
import java.awt.*;

public class ProductFrame extends JFrame {
    private ProductService productService;
    private ProductFormPanel productFormPanel;
    private ProductTablePanel productTablePanel;

    public ProductFrame() {
        productService = new ProductService();
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        productFormPanel = new ProductFormPanel(productService, this);
        productTablePanel = new ProductTablePanel(productService, this);

        setLayout(new CardLayout());
        add(productFormPanel, "formulario");
        add(productTablePanel, "listagem");

        mostrarFormulario();
    }

    public void mostrarFormulario() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "formulario");
    }

    public void mostrarListagem() {
        productTablePanel.atualizarTabela();
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "listagem");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductFrame().setVisible(true));
    }
}
