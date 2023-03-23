

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame {
    
    private JComboBox imagesJComboBox;
    private JLabel label;
    
    private static final String[] images = {"a.png", "b.png", "c.png", "d.png"};
    private Icon[] icons = {
        new ImageIcon(getClass().getResource(images[0])),
        new ImageIcon(getClass().getResource(images[1])),
        new ImageIcon(getClass().getResource(images[2])),
        new ImageIcon(getClass().getResource(images[3]))
    };
    public ComboBoxFrame() {
        super("Combo Box Frame");
        setLayout(new FlowLayout());
        
        imagesJComboBox = new JComboBox(images);
        imagesJComboBox.setMaximumRowCount(3);
        
        imagesJComboBox.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
            }
        });
        
        add(imagesJComboBox);
        label = new JLabel(icons[0]);
        add(label);
    }
    
}