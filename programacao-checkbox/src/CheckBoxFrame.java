import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxFrame extends JFrame {

    private JTextField textField;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;
    public CheckBoxFrame() {
        super("Check Box Frame");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");
        add(boldCheckBox);
        add(italicCheckBox);

        CheckBoxHandler handler = new CheckBoxHandler();
        boldCheckBox.addItemListener(handler);
        italicCheckBox.addItemListener(handler);
    }

    private class CheckBoxHandler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            int fontType = Font.PLAIN;
            if (boldCheckBox.isSelected()) fontType += Font.BOLD;
            if (italicCheckBox.isSelected()) fontType += Font.ITALIC;
            textField.setFont(new Font("Serif", fontType, 14));
        }
    }

}