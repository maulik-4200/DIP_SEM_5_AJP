import javax.swing.*;
import java.awt.*;

class P1{
    public static void main(String [] args){
        JFrame frame = new JFrame("Simple Java Swing Example");
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Hello Swing");
        JButton btn = new JButton("Click Here");

        frame.add(label);
        frame.add(btn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}