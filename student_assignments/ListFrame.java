package student_assignments;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Random;

public class ListFrame extends JFrame {

    private JList numberJList; /*list to display numbers*/
    private int[] numbers = new int[100];
    private String[] numString = new String[numbers.length];

    /*constructor add JScrollPane containing JList to JFrame*/
    public ListFrame() {

        super("List of random numbers");
        setLayout( new FlowLayout() ); // set frame layout

        Random random = new Random();
        for (int n = 0; n < numbers.length; ++n) {
            numbers[n] = random.nextInt(100) + 1;
            // numString[n] = "" + numbers[n];
            numString[n] = "" + (n + 1);
        }

        numberJList = new JList( numString );
        numberJList.setVisibleRowCount( 10 ); /* display ten rows at once */
        numberJList.setFixedCellWidth(30);

        /*do not allow multiple selections*/
        numberJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        /*add a JScrollPane containing JList to frame*/
        add( new JScrollPane(numberJList) );

        numberJList.addListSelectionListener(new ListSelectionListener() { /*anonymous inner class*/
            @Override /* handle list selection */
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = numberJList.getSelectedIndex();
                ListFrame.this.setTitle("You have selected value: " + numString[selectedIndex]);
            } // end method valueChanged
        }); /*end anonymous inner class and call to addListSelectionListener*/

    } // end ListFrame constructor
} // end class ListFrame
