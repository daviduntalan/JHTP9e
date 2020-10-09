package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

import Ch14_GUI_Components_P1.ATM_GUI_Version;

public class Screen {

    private ATM_GUI_Version atmGui;

    public Screen(ATM_GUI_Version gui) {
        atmGui = gui;
    }

    public void displayMessage(String message) {
        /*System.out.print(message);*/
        displayMessageLine(message);
    }

    public void displayMessageLine(String message) {
        /*System.out.println(message);*/
        String oldMessage = atmGui.getTxtAreaScreen().getText();
        String newMessage = String.format("%s%s\n", oldMessage, message);
        atmGui.getTxtAreaScreen().setText(newMessage);
        atmGui.getTxtAreaScreen().setCaretPosition(newMessage.length());
    }

    public void displayDollarAmount(double amount) {
        /*System.out.printf("$%.2f", amount);*/
        String oldMessage = atmGui.getTxtAreaScreen().getText();
        String newAmount = String.format("%s $%.2f", /* remove the newline from old msg. */
                oldMessage.substring(0, oldMessage.length()-1), amount);
        atmGui.getTxtAreaScreen().setText(newAmount);
        atmGui.getTxtAreaScreen().setCaretPosition(newAmount.length());
    }

    /** waits for the user to take the cash */
    public boolean isCashRemoved() {

        atmGui.setIsCashRemoved(false);
        while(!atmGui.isCashRemoved()) {
            try {
                atmGui.setIsCashRemoved(false);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return atmGui.isCashRemoved();
    }

    /** delay for 3s before clearing the screen for next user */
    public void clearScreen() {
        try { Thread.sleep(3000); }
        catch (InterruptedException ex) { }
        atmGui.clearScreen();
    } // end of clearScreen()
}
