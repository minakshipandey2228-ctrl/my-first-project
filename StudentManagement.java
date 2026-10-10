import java.io.*;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Roll Number: ");
                String roll = scanner.nextLine();
                System.out.print("Enter Course (e.g., B.Tech): ");
                String course = scanner.nextLine();
                
                try {
                    FileWriter writer = new FileWriter("students.txt", true);
                    writer.write("Roll No: " + roll + " | Name: " + name + " | Course: " + course + "\n");
                    writer.close();
                    System.out.println("✅ Student added successfully!");
                } catch (IOException e) {
                    System.out.println("❌ Error writing to file.");
                }
                
            } else if (choice == 2) {
                try {
                    File file = new File("students.txt");
                    Scanner reader = new Scanner(file);
                    System.out.println("\n--- Student Records ---");
                    while (reader.hasNextLine()) {
                        System.out.println(reader.nextLine());
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("❌ No records found!");
                }
                
            } else if (choice == 3) {
                System.out.println("Thank you for using Student Management System!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}