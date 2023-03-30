package flowlayout;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayoutFrame extends JFrame {
    
    private JButton leftJButton, centerJButton, rightJButton;
    private FlowLayout layout;
    private Container container;
    public FlowLayoutFrame() {
        super("Frame");
        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);
        
        leftJButton = new JButton("Left");
        add(leftJButton);
        leftJButton.addActionListener(event -> {
                layout.setAlignment(FlowLayout.LEFT);
                layout.layoutContainer(container);
            }
        );
        
        centerJButton = new JButton("Center");
        add(centerJButton);
        centerJButton.addActionListener(event -> {
                layout.setAlignment(FlowLayout.CENTER);
                layout.layoutContainer(container);
            }
        );
        
        rightJButton = new JButton("Right");
        add(rightJButton);
        rightJButton.addActionListener(event -> {
                layout.setAlignment(FlowLayout.RIGHT);
                layout.layoutContainer(container);
            }
        );
    }
    
}