package com.company.control;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getUserChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter choice: ");
            }
        }
    }

    public String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public boolean getPrintOption() {
        System.out.println("Select an option:");
        System.out.println("1. Display full catalog information");
        System.out.println("2. Display brief catalog information");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice == 1;
    }
}
