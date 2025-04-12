import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Singleton with Double-Checked Locking
class RadioNetworkManager {
    private static volatile RadioNetworkManager instance;
    private static final Lock lock = new ReentrantLock();

    private String frequency;
    private String status;

    private RadioNetworkManager() {
        this.frequency = "107.5 MHz";
        this.status = "Active";
    }

    public static RadioNetworkManager getInstance() {
        if (instance == null) {
            lock.lock(); 
            try {
                if (instance == null) { 
                    instance = new RadioNetworkManager();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void updateNetworkSettings(String frequency, String status) {
        this.frequency = frequency;
        this.status = status;
    }

    public String getNetworkSettings() {
        return "Frequency: " + frequency + ", Status: " + status;
    }
}

class Staff {
    private String name;
    private String staffId;
    private String contactNumber;

    public Staff(String name, String staffId, String contactNumber) {
        this.name = name;
        this.staffId = staffId;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRolePermissions() {
        return "No specific permissions";
    }
}

class Ranger extends Staff {
    public Ranger(String name, String staffId, String contactNumber) {
        super(name, staffId, contactNumber);
    }

    @Override
    public String getRolePermissions() {
        return "Control Access";
    }
}

class Vet extends Staff {
    public Vet(String name, String staffId, String contactNumber) {
        super(name, staffId, contactNumber);
    }

    @Override
    public String getRolePermissions() {
        return "Medical Access";
    }
}

class Volunteer extends Staff {
    public Volunteer(String name, String staffId, String contactNumber) {
        super(name, staffId, contactNumber);
    }

    @Override
    public String getRolePermissions() {
        return "Observation Only";
    }
}

public class WildlifeSanctuarySystem {
    public static void main(String[] args) {
        // Demonstrate Singleton Pattern
        RadioNetworkManager radioManager1 = RadioNetworkManager.getInstance();
        RadioNetworkManager radioManager2 = RadioNetworkManager.getInstance();

        // Show that both instances are the same
        System.out.println("Initial Network Settings:");
        System.out.println(radioManager1.getNetworkSettings());
        System.out.println(radioManager2.getNetworkSettings());
        
        // Update network settings and verify changes are reflected in both instances
        radioManager1.updateNetworkSettings("108.0 MHz", "Inactive");
        System.out.println("\nUpdated Network Settings:");
        System.out.println(radioManager2.getNetworkSettings());

        // Demonstrate Inheritance and Polymorphism
        System.out.println("\nStaff Roles and Permissions:");
        Staff ranger = new Ranger("John Doe", "R001", "123-456-7890");
        Staff vet = new Vet("Jane Smith", "V001", "987-654-3210");
        Staff volunteer = new Volunteer("Alice Brown", "VOL001", "555-555-5555");

        // Print role-specific permissions for each staff member
        System.out.println(ranger.getName() + " (" + ranger.getStaffId() + "): " + ranger.getRolePermissions()); 
        System.out.println(vet.getName() + " (" + vet.getStaffId() + "): " + vet.getRolePermissions()); 
        System.out.println(volunteer.getName() + " (" + volunteer.getStaffId() + "): " + volunteer.getRolePermissions());
    }
}


