import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P3{
    public static void main(String[] args){
        JFrame frame = new JFrame("AJP Practical - 3");
        frame.setSize(500,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel signalLabel = new JLabel("STOP");
        signalLabel.setForeground(Color.RED);
        signalLabel.setBounds(200,20,100,75);
        signalLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(signalLabel);

        JRadioButton redRB = new JRadioButton("Red");
        redRB.setBounds(200,100,100,25);
        redRB.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                signalLabel.setText("STOP");
                signalLabel.setForeground(Color.RED);
            }
        });
        frame.add(redRB);
        
        JRadioButton yellowRB = new JRadioButton("Yellow");
        yellowRB.setBounds(200,125,100,25);
        yellowRB.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                signalLabel.setText("WAIT");
                signalLabel.setForeground(Color.YELLOW);
            }
        });
        frame.add(yellowRB);

        JRadioButton greenRB = new JRadioButton("Green");
        greenRB.setBounds(200,150,100,25);
        greenRB.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                signalLabel.setText("GO");
                signalLabel.setForeground(Color.GREEN);
            }
        });
        frame.add(greenRB);

        ButtonGroup signalBG = new ButtonGroup();
        signalBG.add(redRB);signalBG.add(yellowRB);signalBG.add(greenRB);

        frame.setVisible(true);
    }
}