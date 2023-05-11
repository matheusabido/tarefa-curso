package layout;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
    private JButton leftJButton;
    private JButton centerJButton;
    private JButton rightJButton;
    private FlowLayout layout;
    private Container container;
    public FlowLayoutFrame() {
        super("Flow Layout Demo");
        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);
        
        leftJButton = new JButton("Left");
        add(leftJButton);
        leftJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.LEFT);
            layout.layoutContainer(container);
        });
        
        centerJButton = new JButton("Center");
        add(centerJButton);
        centerJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.CENTER);
            layout.layoutContainer(container);
        });
        
        rightJButton = new JButton("Right");
        add(rightJButton);
        rightJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.RIGHT);
            layout.layoutContainer(container);
        });
    }
}