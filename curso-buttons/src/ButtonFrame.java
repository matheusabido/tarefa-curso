import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {

    private JButton plainButton;
    private JButton fancyButton;
    public ButtonFrame() {
        super("Testing Buttons");
        setLayout(new FlowLayout());

        plainButton = new JButton("Plain Button");
        add(plainButton);

        Icon bug1 = new ImageIcon(getClass().getResource("bug.png"));
        fancyButton = new JButton("Fancy Button", bug1);
        add(fancyButton);
        ButtonHandler handler = new ButtonHandler();
        fancyButton.addActionListener(handler);
        plainButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", e.getActionCommand()));
        }
    }

}