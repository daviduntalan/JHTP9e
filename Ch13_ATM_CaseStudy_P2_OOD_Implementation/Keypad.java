package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

import Ch14_GUI_Components_P1.ATM_GUI_Version;

import java.util.Scanner;

public class Keypad {

    /*private Scanner input; // reads data from the command line*/
    ATM_GUI_Version atmGui;

    public Keypad(ATM_GUI_Version gui) {
        /*input = new Scanner(System.in);*/
        atmGui = gui;
    }

    public int getInput() {
        /*return input.nextInt();*/
        atmGui.setIsEnterHit(false);

        /* give some time for user to input within 10ms.
        Gives the GUI an opportunity to change its state within 10ms. */
        while (!atmGui.isEnterHit()) {
            try {
                Thread.sleep(10);
                /* do nothing while Enter button wasn't hit.
                while loop keeps on listening every 10ms. */
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        } // end while

        /* successfully hit Enter button and pickup input command */
        return atmGui.getInputCommand();
    }
}
