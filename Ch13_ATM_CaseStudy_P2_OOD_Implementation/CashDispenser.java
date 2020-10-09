package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public class CashDispenser {

    // the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count; // number of $20 bills remaining

    public CashDispenser() {
        count = INITIAL_COUNT; // set count attribute to default
    }

    public void dispenseCash(int amount) {

        int billsRequired = amount / 20; // number of $20 bills required
        count -= billsRequired; // update the count of bills
    }
    
    public boolean isSufficientCashAvailable(int amount) {

        int billsRequired = amount / 20; // number of $20 bills required
        if (count >=  billsRequired) {
            return true; // enough bills available
        }
        return false; // not enough bills available
    }
}
