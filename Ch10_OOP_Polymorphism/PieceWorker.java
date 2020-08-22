package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 *
 * @author David
 */
@lombok.Getter
@lombok.Setter
public class PieceWorker extends Employee2 {

    private int pieces; // number of pieces produced
    private double wage; // employee's wage per piece
    
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, int piecesProduced, double wage) {
        super(firstName, lastName, socialSecurityNumber);
        setPieces(piecesProduced);
        setWage(wage);
    }
    
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date birthDate, int piecesProduced, double wage) { 
        super(firstName, lastName, socialSecurityNumber, birthDate);
        setPieces(piecesProduced);
        setWage(wage);
    }

    @Override
    public double earnings() {
        return getPieces() * getWage();
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %d; %s: $%,.2f",
                "piece worker", super.toString(),
                "number of pieces", getPieces(),
                "wage per piece", getWage()
        );
    }

    @Override
    public double getPaymentAmount() {
        return earnings();
    }
}
