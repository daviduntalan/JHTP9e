package student_assignments;

@lombok.Getter
@lombok.Setter
public class Customer {

    private String email; // Billing Email address is a required field.
    private String firstName; // Billing First name is a required field.
    private String lastName; // Billing Last name is a required field.
    private String address; // Billing Street address is a required field.
    private String cityTown; // Billing Town / City is a required field.
    private String suburb; // labas ng lungsod/bayan; An outlying district of a city, especially a residential one.
    private String province; // Billing Province / State is a required field
    private String postCode; // Billing Postcode / ZIP is a required field.
    private String phone; // Billing Phone is a required field.
}
