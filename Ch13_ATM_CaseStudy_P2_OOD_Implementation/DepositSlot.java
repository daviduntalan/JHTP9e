package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

import Ch14_GUI_Components_P1.ATM_GUI_Version;

public class DepositSlot {

    private ATM_GUI_Version atmGui;

    public DepositSlot(ATM_GUI_Version gui) {
        atmGui = gui;
    }

    /**
     * @return indicates whether envelope was received (always returns true,
     * because this is only a software simulation of a real deposit slot).
     */
    public boolean isEnvelopeReceived() {

        atmGui.setIsEnvelopeInserted(false); /* initialized to false then
        waits for user to deposit/insert the envelope within 5s.
        Gives the GUI an opportunity to change its state within 5s. */
        while(!atmGui.isEnvelopeInserted()) {
            try {
                Thread.sleep(5000);
                /* envelope wasn't received */
                return atmGui.isEnvelopeInserted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // end of while

        /* inserted envelope was received */
        return atmGui.isEnvelopeInserted();
    }
}
