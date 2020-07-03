package student_assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabExer8 extends JFrame implements ActionListener {

    JMenu menu1, menu2, submenu2, submenu3;
    JMenuItem i1, i2, i3, i4, i5, i6, i7;

    LabExer8() {

        JFrame f = new JFrame("Party Planner");

        JMenuBar mainBar = new JMenuBar();
        menu1 = new JMenu("File");
        menu2 = new JMenu("Event Type");
        submenu2 = new JMenu("Adult");
        submenu3 = new JMenu("Child");

        i1 = new JMenuItem("Birthday");
        i2 = new JMenuItem("Anniversary");
        i3 = new JMenuItem("Retirement");
        i4 = new JMenuItem("Other");
        i5 = new JMenuItem("Birthday");
        i6 = new JMenuItem("Other");
        i7 = new JMenuItem("Exit");
        
        i1.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, 
                    "Congrats for antoher year.");
        });
        
        i7.addActionListener(this);

        menu1.add(i7);
        menu2.add(i1);
        menu2.add(i2);

        submenu2.add(i1);
        submenu2.add(i2);
        submenu2.add(i3);
        submenu2.add(i4);
        submenu3.add(i5);
        submenu3.add(i6);

        menu2.add(submenu2);
        menu2.add(submenu2);
        menu2.add(submenu2);
        menu2.add(submenu3);
        menu2.add(submenu3);

        mainBar.add(menu1);
        mainBar.add(menu2);

        f.setJMenuBar(mainBar);
        f.setSize(400, 200);

        f.setLayout(new FlowLayout());
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel currentPanel = new JPanel();
        JPanel otherPanel = new JPanel();
        JLabel currentLabel, otherLabel;
        currentLabel = new JLabel("");
        currentLabel.setBounds(50, 50, 100, 100);

        f.add(currentLabel);
        otherLabel = new JLabel("We have lots of ideas for memorable events");
        otherLabel.setBounds(50, 50, 100, 100);
        f.add(otherLabel);
        f.setLayout(new FlowLayout(FlowLayout.CENTER));

        
    }

    public static void main(String[] args) {

        new LabExer8();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.exit(0);

    }

}
