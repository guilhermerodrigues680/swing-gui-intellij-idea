import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MinhaGUI extends JFrame {
    private JPanel meuJPanel;
    private JTextField xTextFild;
    private JTextField x2TextFild;
    private JButton calcButton;

    public MinhaGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(meuJPanel);
        this.pack();

        // Clique no botao calcular
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão clicado");
                final int x = Integer.parseInt(xTextFild.getText());
                final int x2 = x * x;
                x2TextFild.setText(Integer.toString(x2));
            }
        });

        // Tecla presionada no xTextFild
        xTextFild.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if(!Util.charIsNumber(e.getKeyChar())) {
                    System.out.println("O character " + e.getKeyChar() + " não é um número.");
                    e.consume();
                    return;
                }

                System.out.println("Character válido: " + e.getKeyChar());
            }
        });
    }

}
