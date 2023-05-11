package borderlayout;

import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame extends JFrame {
    private JButton[] buttons;
    private static final String[] names = {"Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"};
    private static final String[] positions = {BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST, BorderLayout.CENTER};
    private BorderLayout layout;
    public BorderLayoutFrame() {
        super("BorderLayoutFrame");
        layout = new BorderLayout(5, 5);
        setLayout(layout);
        buttons = new JButton[names.length];
        
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(e -> {
                ((JButton) e.getSource()).setVisible(false);
                Arrays.stream(buttons).filter(b -> b != e.getSource())
                        .forEach(b -> b.setVisible(true));
                layout.layoutContainer(getContentPane());
            });
            add(buttons[i], positions[i]);
        }
    }
}