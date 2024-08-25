import javax.swing.*;

class Task1{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Data");
        frame.setSize(500,500);
        frame.setLayout(null);

        JLabel nlbl = new JLabel("Name");
        nlbl.setBounds(150, 10, 200,25);
        frame.add(nlbl);

        JTextField ntf = new JTextField();
        ntf.setBounds(150, 35, 200,25);
        frame.add(ntf);

        JLabel albl = new JLabel("Address");
        albl.setBounds(150, 60, 200,25);
        frame.add(albl);

        JTextArea ata = new JTextArea();
        ata.setBounds(150, 85, 200,75);
        frame.add(ata);

        JLabel glbl = new JLabel("Gender");
        glbl.setBounds(150, 160, 200,25);
        frame.add(glbl);

        JRadioButton gmrb = new JRadioButton("Male");
        gmrb.setBounds(150,185, 200, 25);
        frame.add(gmrb);

        JRadioButton gfrb = new JRadioButton("Female");
        gfrb.setBounds(150,210, 200, 25);
        frame.add(gfrb);

        JRadioButton gorb = new JRadioButton("Other");
        gorb.setBounds(150,235, 200, 25);
        frame.add(gorb);

        ButtonGroup gbg = new ButtonGroup();
        gbg.add(gmrb); gbg.add(gfrb); gbg.add(gorb);

        JLabel hlbl = new JLabel("Hobbies");
        hlbl.setBounds(150, 260, 200,25);
        frame.add(hlbl);

        JCheckBox hrcb = new JCheckBox("Reading");
        hrcb.setBounds(150, 285, 200, 25);
        frame.add(hrcb);

        JCheckBox hwcb = new JCheckBox("Writing");
        hwcb.setBounds(150, 310, 200, 25);
        frame.add(hwcb);

        JCheckBox hpcb = new JCheckBox("Playing");
        hpcb.setBounds(150, 335, 200, 25);
        frame.add(hpcb);

        JCheckBox hscb = new JCheckBox("Sleeping");
        hscb.setBounds(150, 360, 200, 25);
        frame.add(hscb);

        JButton sbtn = new JButton("Submit");
        sbtn.setBounds(150, 385, 200, 25);
        frame.add(sbtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}