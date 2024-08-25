import javax.swing.*;
import java.awt.event.*;

public class P2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AJP Practical-2");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] cources = {"Information Technology", "Civil Engineering", "Computer Engineering", "Mechanical Engineering", "Printing Engineering"};
        JCheckBox[] checkboxes = new JCheckBox[cources.length];
        
        JLabel label = new JLabel("Courses"); 
        label.setBounds(150,20,200,25);
        frame.add(label);

        for(int i = 0; i < cources.length; i++){
            JCheckBox chk = new JCheckBox(cources[i]);
            chk.setBounds(150, (50 + (i * 25)),200,25);
            frame.add(chk);
            checkboxes[i] = chk;
        }

        JLabel scjl = new JLabel("Seleceted Courses");
        scjl.setBounds(150, (50 + (cources.length * 25) + 25), 200, 25);
        frame.add(scjl);

        JTextArea sc = new JTextArea();
        sc.setBounds(150,(50 + (cources.length * 25) + 50), 200, (18 * cources.length));
        sc.setEditable(false);
        frame.add(sc);

        ItemListener itemListener = new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                String sctxt = ""; 
                for(int i = 0; i < checkboxes.length; i++){
                    if(checkboxes[i].isSelected()){
                        sctxt += checkboxes[i].getText();
                        sctxt += "\n";
                    }
                }
                sc.setText(sctxt);
            }
        };

        for(int i = 0; i < checkboxes.length; i++){
            checkboxes[i].addItemListener(itemListener);
        }

        frame.setVisible(true);
    }
}