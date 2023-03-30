package flowlayout;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        FlowLayoutFrame frame = new FlowLayoutFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 90);
        frame.setVisible(true);
    }    
}