import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PatientBST patientRecords = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentHistory = new TreatmentStack();
        VisitHistoryList visitHistory = new VisitHistoryList();

        int choice = 0;

        while (choice != 7) {
            System.out.println("\n--- Hospital Emergency Management System ---");
            System.out.println("1. Add new patient");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Add patient to emergency queue");
            System.out.println("4. Treat next patient in queue");
            System.out.println("5. View treatment history entry");
            System.out.println("6. View all patients (sorted by ID)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter patient ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (patientRecords.search(id) != null) {
                    System.out.println("A patient with this ID already exists. Please use a different ID.");
                } else {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter condition: ");
                    String condition = scanner.nextLine();
                    System.out.print("Enter arrival time: ");
                    String arrivalTime = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, condition, arrivalTime);
                    patientRecords.insert(newPatient);
                    visitHistory.addVisit("Visit recorded for patient ID " + id);
                    System.out.println("Patient added successfully.");
                }

            } else if (choice == 2) {
                System.out.print("Enter patient ID to search: ");
                int id = scanner.nextInt();
                Patient found = patientRecords.search(id);
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("No patient found with that ID.");
                }

            } else if (choice == 3) {
                System.out.print("Enter patient ID to add to queue: ");
                int id = scanner.nextInt();
                Patient found = patientRecords.search(id);
                if (found != null) {
                    emergencyQueue.enqueue(found);
                    System.out.println("Patient added to emergency queue.");
                } else {
                    System.out.println("Patient not found. Add them first.");
                }

            } else if (choice == 4) {
                if (emergencyQueue.isEmpty()) {
                    System.out.println("The emergency queue is empty.");
                } else {
                    Patient next = emergencyQueue.dequeue();
                    System.out.println("Now treating: " + next);
                    treatmentHistory.push("Treated patient ID " + next.getPatientId());
                }

            } else if (choice == 5) {
                if (treatmentHistory.isEmpty()) {
                    System.out.println("No treatment history recorded yet.");
                } else {
                    System.out.println("Most recent treatment: " + treatmentHistory.pop());
                }

            } else if (choice == 6) {
                System.out.println("All patients (sorted by ID):");
                patientRecords.inOrderTraversal();

            } else if (choice == 7) {
                System.out.println("Exiting program. Goodbye!");

            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }


        scanner.close();
    }
}