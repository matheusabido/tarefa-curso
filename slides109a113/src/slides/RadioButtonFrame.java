package slides;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonFrame extends JFrame {

    private JTextField textField;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;
    private JRadioButton plainJRadioButton;
    private JRadioButton boldJRadioButton;
    private JRadioButton italicJRadioButton;
    private JRadioButton boldItalicJRadioButton;
    private ButtonGroup radioGroup;
    public RadioButtonFrame() {
        super("RadioButton Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 25);
        add(textField);

        add(plainJRadioButton = new JRadioButton("Plain", true));
        add(boldJRadioButton = new JRadioButton("Bold", false));
        add(italicJRadioButton = new JRadioButton("Italic", false));
        add(boldItalicJRadioButton = new JRadioButton("Bold/Italic", false));

        radioGroup = new ButtonGroup();
        radioGroup.add(plainJRadioButton);
        radioGroup.add(italicJRadioButton);
        radioGroup.add(boldJRadioButton);
        radioGroup.add(boldItalicJRadioButton);

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);

        plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
        boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
    }

    private class RadioButtonHandler implements ItemListener {

        private Font font;
        public RadioButtonHandler(Font font) {
            this.font = font;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            textField.setFont(font);
        }
    }

}