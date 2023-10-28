import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


// Define the StaffMember class to represent individual staff members
class StaffMember {
    private String id;
    private String name;
    private String address;
    private String position;
//    private String department;
    private double salary;


// Constructor to initialize staff member properties
    public StaffMember(String id, String name, String address, String position, String department, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

// Getter method for retrieving the ID of the staff member.
    public String getId() {
        return id;
    }

// Getter method for retrieving the name of the staff member.
    public String getName() {
        return name;
    }

 // Getter method for retrieving the address of the staff member.
    public String getAddress() {
        return address;
    }



// Getter method for retrieving the position of the staff member.
    public String getPosition() {
        return position;
    }
// Setter method for updating the position of the staff member.
    public void setPosition(String position) {
        this.position = position;
    }



    // Getter method for retrieving the department of the staff member.
    public String getDepartment() {
        return department;
    }
// Setter method for updating the department of the staff member.
    public void setDepartment(String department) {
        this.department = department;
    }



// Getter method for retrieving the salary of the staff member.
    public double getSalary() {
        return salary;
    }
 // Setter method for updating the salary of the staff member.
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// Define the StaffRecordSystem class to manage a collection of staff members
class StaffRecordSystem {
    private List<StaffMember> staffMembers;


// Constructor to initialize the staff members list
    public StaffRecordSystem() {
        staffMembers = new ArrayList<>();
    }

// Method to add a staff member to the collection
    public void addStaffMember(StaffMember member) {
        staffMembers.add(member);
    }


// Method to retrieve a staff member by their name (case-insensitive)
    public StaffMember getStaffMemberByName(String name) {
        for (StaffMember member : staffMembers) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }


// Method to get a list of all staff members
    public List<StaffMember> getAllStaffMembers() {
        return staffMembers;
    }


 // Method to update a staff member's position, salary, and department
    public void updateStaffMember(String name, String newPosition, double newSalary, String newDepartment) {
        for (StaffMember member : staffMembers) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.setPosition(newPosition);
                member.setSalary(newSalary);
                member.setDepartment(newDepartment);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

// Initialize the StaffRecordSystem and a scanner for user input
        StaffRecordSystem recordSystem = new StaffRecordSystem();
        Scanner scanner = new Scanner(System.in);

// Add hardcoded employees to the staff record system
        StaffMember employee1 = new StaffMember(generateRandomID(),
                "John Doe", "123 Main St", "Manager", "HR", 40000);
        StaffMember employee2 = new StaffMember(generateRandomID(),
                "Steve Jackson", "456 Elm St", "Engineer", "IT", 50000);
        StaffMember employee3 = new StaffMember(generateRandomID(),
                "Sarah Smith", "789 Oak St", "Designer", "Design", 45000);

// Add the employee1 instance to the staff record system.
        recordSystem.addStaffMember(employee1);

// Add the employee2 instance to the staff record system.
        recordSystem.addStaffMember(employee2);

// Add the employee3 instance to the staff record system.
        recordSystem.addStaffMember(employee3);



 // Main program loop for user interaction
        while (true) {

            // Display a menu for user choices
            System.out.println("Staff Record System");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Add Staff Member");
            System.out.println("2. Retrieve Staff Member by Name (Case-Insensitive)");
            System.out.println("3. Update Staff Member by Name");
            System.out.println("4. List All Staff Members");
            System.out.println("5. Exit");
            System.out.println("- - - - - - - - - - - - -");
            System.out.print("Enter your choice: ");

// Read the user's choice and execute the corresponding action
            int choice = scanner.nextInt();

// Consume the newline character
            scanner.nextLine();

            switch (choice) {

// Add a new staff member by collecting user input
                case 1:
                    // Input and add a new staff member
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Salary (must be a Double Number): ");
                    double salary = scanner.nextDouble();
                    StaffMember staffMember = new StaffMember(generateRandomID(),
                            name,
                            address,
                            position,
                            department,
                            salary);
                    recordSystem.addStaffMember(staffMember);
                    break;

// Retrieve and display a staff member's information by name
                case 2:

                    System.out.print("Enter Name to retrieve: ");
                    String retrieveName = scanner.nextLine();
                    StaffMember retrievedStaff = recordSystem.getStaffMemberByName(retrieveName);

                    if (retrievedStaff != null) {
                        System.out.println("- - - - - - - - - - - - -");
                        System.out.println("Retrieved Staff Member Information:");
                        System.out.println("ID: " + retrievedStaff.getId());
                        System.out.println("Name: " + retrievedStaff.getName());
                        System.out.println("Address: " + retrievedStaff.getAddress());
                        System.out.println("Position: " + retrievedStaff.getPosition());
                        System.out.println("Department: " + retrievedStaff.getDepartment());
                        System.out.println("Salary: £" + String.format("%.2f", retrievedStaff.getSalary()));
                    } else {
                        System.out.println("Staff member not found.");
                    }
                    break;

// Update a staff member's details by name
                case 3:

                    System.out.print("Enter Name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Position: ");
                    String newPosition = scanner.nextLine();
                    System.out.print("Enter new Salary (must be a Double Number): ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter new Department: ");
                    String newDepartment = scanner.nextLine();
                    recordSystem.updateStaffMember(updateName, newPosition, newSalary, newDepartment);
                    System.out.println("Staff member updated.");
                    break;

// List all staff members and display their information
                case 4:

                    List<StaffMember> allStaffMembers = recordSystem.getAllStaffMembers();
                    if (allStaffMembers.isEmpty()) {
                        System.out.println("No staff members found.");
                    } else {
                        System.out.println("List of All Staff Members:");
                        for (StaffMember staff : allStaffMembers) {
                            System.out.println("- - - - - - - - - - - - -");
                            System.out.println("ID: " + staff.getId());
                            System.out.println("Name: " + staff.getName());
                            System.out.println("Address: " + staff.getAddress());
                            System.out.println("Position: " + staff.getPosition());
                            System.out.println("Department: " + staff.getDepartment());
                            System.out.println("Salary: £" + String.format("%.2f", staff.getSalary()));
                        }
                    }
                    break;

                case 5:
 // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


// Method to generate a random 5-digit ID with a random letter prefix ('A' or 'W')
    private static String generateRandomID() {
        Random random = new Random();

// generate random letter from A to W
        char prefix = (random.nextBoolean()) ? 'A' : 'W';

// 5-digit random number
        int id = random.nextInt(90000) + 10000;

        return prefix + Integer.toString(id);
    }
}
