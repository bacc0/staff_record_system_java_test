
// These import statements are necessary to access the functionality provided by these classes within the Java program.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

// Constructor to initialize staff member details
class StaffMember {
    private String id;
    private String name;
    private String address;
    private String position;
    private String department;
    private double salary;

    public StaffMember(String id, String name, String address, String position, String department, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    // Getter and setter methods for accessing and modifying staff member details
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Static method to ensure valid salary input from the user
    public static double getValidSalary(Scanner scanner) {
        double salary;
        while (true) {
            try {
                // Prompt the user to enter a salary and read the input as a String.
                System.out.print("Enter Salary (must be a Number): ");
                salary = Double.parseDouble(scanner.nextLine());

                // Attempt to parse the input String as a double (a floating-point number).
                // If successful, the parsed value is assigned to the 'salary' variable.

                // If the parsing succeeds, exit the loop and return the valid 'salary'.
                break;
            } catch (NumberFormatException e) {
                // If the input cannot be parsed as a valid double, it triggers a
                // NumberFormatException.

                // Display an error message to inform the user about the invalid input.
                System.out.println("Invalid input. Please enter a valid number for Salary.");
            }
        }

        // The loop continues until a valid numeric input is provided, ensuring data
        // integrity.

        // Return the valid 'salary' once it has been successfully entered.
        return salary;
    }
}

// Define the StaffRecordSystem class to manage a list of staff members
class StaffRecordSystem {
    private List<StaffMember> staffMembers;

    // Constructor to initialize the list of staff members
    public StaffRecordSystem() {
        staffMembers = new ArrayList<>();
    }

    // Method to add a staff member to the list
    public void addStaffMember(StaffMember member) {
        staffMembers.add(member);
    }

    // Method to retrieve a staff member by name (case-insensitive)
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

    // Method to update the details of a staff member
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

// Main class for the program
public class Main {
    public static void main(String[] args) {
        // Create a StaffRecordSystem instance to manage staff members
        StaffRecordSystem recordSystem = new StaffRecordSystem();
        Scanner scanner = new Scanner(System.in);

        // Main program loop to interact with the user
        while (true) {
            // Display menu options for the user
            System.out.println("Staff Record System");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Add Staff Member");
            System.out.println("2. Retrieve Staff Member by Name (Case-Insensitive)");
            System.out.println("3. Update Staff Member by Name");
            System.out.println("4. List All Staff Members");
            System.out.println("5. Exit");
            System.out.println("- - - - - - - - - - - - -");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Option to add a new staff member
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    double salary = StaffMember.getValidSalary(scanner);
                    StaffMember staffMember = new StaffMember(generateRandomID(), name, address, position, department,
                            salary);
                    recordSystem.addStaffMember(staffMember);
                    break;
                case 2:
                    // Option to retrieve a staff member by name
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

                case 3:
                    // Option to update a staff member's details
                    System.out.print("Enter Name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Position: ");
                    String newPosition = scanner.nextLine();
                    System.out.print("Enter new Salary (must be a Double Number): ");
                    double newSalary = StaffMember.getValidSalary(scanner);
                    System.out.print("Enter new Department: ");
                    String newDepartment = scanner.nextLine();
                    recordSystem.updateStaffMember(updateName, newPosition, newSalary, newDepartment);
                    System.out.println("Staff member updated.");
                    break;

                case 4:
                    // Option to list all staff members
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
                    // Option to exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    // Handle invalid user choices
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Generate a random staff member ID
    private static String generateRandomID() {
        Random random = new Random();
        char prefix = (random.nextBoolean()) ? 'A' : 'W';
        int id = random.nextInt(90000) + 10000;
        return prefix + Integer.toString(id);
    }
}
