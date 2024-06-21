import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductFormPanel extends JPanel {
    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField valorField;
    private JRadioButton disponivelSim;
    private JRadioButton disponivelNao;
    private ProductService productService;
    private ProductFrame productFrame;

    public ProductFormPanel(ProductService productService, ProductFrame productFrame) {
        this.productService = productService;
        this.productFrame = productFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome do Produto:");
        nomeField = new JTextField();
        add(nomeLabel);
        add(nomeField);

        JLabel descricaoLabel = new JLabel("Descrição do Produto:");
        descricaoField = new JTextField();
        add(descricaoLabel);
        add(descricaoField);

        JLabel valorLabel = new JLabel("Valor do Produto:");
        valorField = new JTextField();
        add(valorLabel);
        add(valorField);

        JLabel disponivelLabel = new JLabel("Disponível para Venda:");
        disponivelSim = new JRadioButton("Sim");
        disponivelNao = new JRadioButton("Não");
        ButtonGroup disponivelGroup = new ButtonGroup();
        disponivelGroup.add(disponivelSim);
        disponivelGroup.add(disponivelNao);
        JPanel disponivelPanel = new JPanel();
        disponivelPanel.add(disponivelSim);
        disponivelPanel.add(disponivelNao);
        add(disponivelLabel);
        add(disponivelPanel);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });
        add(new JLabel());
        add(cadastrarButton);
    }

    private void cadastrarProduto() {
        String nome = nomeField.getText();
        String descricao = descricaoField.getText();
        double valor = Double.parseDouble(valorField.getText());
        boolean disponivel = disponivelSim.isSelected();

        Product product = new Product(nome, descricao, valor, disponivel);
        productService.addProduto(product);
        productFrame.mostrarListagem();
    }
}
