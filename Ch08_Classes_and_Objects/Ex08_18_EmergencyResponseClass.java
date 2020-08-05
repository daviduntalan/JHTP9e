package Ch08_Classes_and_Objects;

/**
 * Project: Emergency Response Class. The North American emergency response
 * service, 9-1-1, connects callers to a local Public Service Answering Point
 * (PSAP). Traditionally, the PSAP would ask the caller for identification
 * information--including the caller's address, phone number and the nature
 * of the emergency, then dispatch the appropriate emergency responders (such
 * as the police, an ambulance or the fire department). Enhanced 9-1-1 (or 
 * E9-1-1) uses computers and databases to determine the caller's physical
 * address, directs the call to the nearest PSAP, and displays the caller's
 * phone number and address to the call taker. Wireless Enhanced 9-1-1 provides
 * call takers with identification information for wireless calls. Rolled
 * out in two phases, the first phase required carriers to provide the 
 * wireless phone number and the location oft he cell site or base station
 * transmitting the call. The second phase required carriers to provide the
 * location of the caller (using technologies such as GPS). To learn more 
 * about 9-1-1, visit www.fcc.gov/pshs/services/911-services/Welcome.html
 * and people.howstuffworks.com/9-1-1.html.
 * An important part of creating a class is determining the class's attributes
 * (instance variables). For this class design exercise, research 9-1-1
 * services on the Internet. Then, design a class called Emergency that
 * might be used in an object-oriented 9-1-1 emergency response system. 
 * List the attributes that an object of this class might use to represent
 * the emergency (including their phone number), the location of the 
 * emergency, the time of the report, the nature of the emergency, 
 * the type of response and the status of the response. The class 
 * attributes should completely describe the nature of the problem
 * and what's happening to resolve that problem.
 * @author David
 */

enum Responders {
    POLICE, 
    AMBULANCE, 
    FIRE_DEPARTMENT
}

@lombok.Getter
@lombok.Setter
class Emergency {
    String phoneNumber;
    String location;
    String timeReported;
    String nature;
    Responders responseType;
    String responseStatus;

    public Emergency(String phoneNumber, String location, String timeReported, 
            String nature, Responders responseType, String responseStatus) {
        setPhoneNumber(phoneNumber);
        setLocation(location);
        setTimeReported(timeReported);
        setNature(nature);
        setResponseType(responseType);
        setResponseStatus(responseStatus);
    }        
    
    public void response() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Emergency {" + "\n"
                + "\tphone number: " + getPhoneNumber() + ", \n"
                + "\tlocation: " + getLocation() + ", \n"
                + "\ttime reported: " + getTimeReported() + ", \n"
                + "\tnature: " + getNature() + ", \n"
                + "\tresponse type: " + getResponseType() + ", \n"
                + "\tresponse status: " + getResponseStatus() + "\n"
                + "}";
    }
}

class Enhanced911 extends Emergency {
    
    public Enhanced911(String phoneNumber, String location, String timeReported, 
            String nature, Responders responseType, String responseStatus) {
        super(phoneNumber, location, timeReported, nature, responseType, responseStatus);                        
    }
    
    public void reponse() {
        String address = getCallersPhysicalAddress();
        directTheCallToNearestPSAP(getPhoneNumber(), address);
    }
    
    public String getCallersPhysicalAddress() {
        return getAddressFromDB();
    }
    
    private String getAddressFromDB() {
        return "Address fetched from DB.";
    }

    protected void directTheCallToNearestPSAP(String phoneNumber, String address) {
        System.out.println("PSAP: Attending call from caller.");
        System.out.printf("Caller's phone number: %s\n", phoneNumber);
        System.out.printf("Caller's address: %s\n", address);
    }    
}

@lombok.Getter
@lombok.Setter
final class WirelessEhanced911 extends Enhanced911 {

    String wirelessPhone;
    
    public WirelessEhanced911(String phoneNumber, String location, 
            String timeReported, String nature, Responders responseType, 
            String responseStatus, String wirelessPhone) {
        super(phoneNumber, location, timeReported, nature, responseType, responseStatus);
        setWirelessPhone(wirelessPhone);
    }

    public void reponse() {
        directTheCallToNearestPSAP(getPhoneNumber(), getLocation());
        String location = fetchCellSiteLocation(getWirelessPhone());
        System.out.printf("Cell phone: %s\n", getWirelessPhone());
        System.out.printf("Site location: %s\n", location);
    }

    private String fetchCellSiteLocation(String wirelessPhone) {
        if (getWirelessPhone().startsWith("0917")) {
            return "Globe at Quezon City";
        } else {
            return "Smart at Makati";
        }
    }
}

public class Ex08_18_EmergencyResponseClass {

    public static void main(String[] args) {
        
        String phoneNumber = "02-434-2765";
        String location = "Lacao St. Puerto Pricesa";
        String timeReported = "4:09 AM";
        String nature = "Fire";
        Responders responseType = Responders.FIRE_DEPARTMENT;
        String responseStatus = "Dispatching";
        
        new Emergency(phoneNumber, location, timeReported, nature, 
                responseType, responseStatus).response();        
        
        System.out.println();
        
        new Enhanced911(phoneNumber, location, timeReported, nature, 
                responseType, responseStatus).reponse();
        
        System.out.println();
        
        String wirelessPhone = "09173334444";
        new WirelessEhanced911(phoneNumber, location, timeReported, 
                nature, responseType, responseStatus, 
                wirelessPhone).reponse();                
    }
    
}
