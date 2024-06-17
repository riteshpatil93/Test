package bank;

import java.io.*;
import java.util.Scanner;

class Customer {
    private String username;
    private String password;
    private String name;
    private String contact;
    private double balance;
    private boolean isBlocked;

    public Customer(String username, String password, String name, String contact, double balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.balance = balance;
        this.isBlocked = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void updateContact(String newContact) {
        contact = newContact;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (!isBlocked && amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void block() {
        isBlocked = true;
    }

    public String toFileString() {
        return username + "," + password + "," + name + "," + contact + "," + balance + "," + isBlocked;
    }
}

class CustomerManager {
    private static final int MAX_CUSTOMERS = 100;
    private Customer[] customers;
    private int customerCount;
    private static final String CUSTOMER_FILE = "customers.txt";

    public CustomerManager() {
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
        loadCustomersFromFile();
    }

    private void loadCustomersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Customer customer = new Customer(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
                    customer.block();
                    customers[customerCount++] = customer;
                } else if (data.length == 5) {
                    Customer customer = new Customer(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
                    customers[customerCount++] = customer;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(String username, String password, String name, String contact, double balance) {
        if (customerCount < MAX_CUSTOMERS) {
            Customer newCustomer = new Customer(username, password, name, contact, balance);
            customers[customerCount++] = newCustomer;
            saveCustomersToFile();
        } else {
            System.out.println("Cannot create a new customer. Maximum limit reached.");
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] allCustomers = new Customer[customerCount];
        System.arraycopy(customers, 0, allCustomers, 0, customerCount);
        return allCustomers;
    }

    private void saveCustomersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE))) {
            for (int i = 0; i < customerCount; i++) {
                writer.write(customers[i].toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerByUsername(String usernameToFind) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(usernameToFind)) {
                return customers[i];
            }
        }
        return null;
    }

    public void blockCustomer(String username) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(username)) {
                customers[i].block();
                saveCustomersToFile();
                return;
            }
        }
    }
}

class Admin {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public void viewAllCustomerAccounts(CustomerManager customerManager) {
        Customer[] customers = customerManager.getAllCustomers();
        System.out.println("All Customer Accounts:");
        for (Customer customer : customers) {
            System.out.println("Username: " + customer.getUsername() + ", Name: " + customer.getName());
        }
    }

    public Customer viewCustomerAccount(CustomerManager customerManager, String username) {
        return customerManager.getCustomerByUsername(username);
    }

    public void blockCustomerAccount(CustomerManager customerManager, String username) {
        customerManager.blockCustomer(username);
        System.out.println("Customer account blocked successfully!");
    }

    public void createNewAccount(CustomerManager customerManager, String username, String password, String name, String contact, double balance) {
        customerManager.createCustomer(username, password, name, contact, balance);
        System.out.println("New customer account created successfully!");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        CustomerManager customerManager = new CustomerManager();

        System.out.println("Welcome to the Banking Application!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    if (admin.login(adminUsername, adminPassword)) {
                        adminMenu(admin, customerManager, scanner);
                    } else {
                        System.out.println("Admin login failed. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter customer username: ");
                    String customerUsername = scanner.nextLine();
                    System.out.print("Enter customer password: ");
                    String customerPassword = scanner.nextLine();

                    Customer customer = customerManager.getCustomerByUsername(customerUsername);
                    if (customer != null && customer.getPassword().equals(customerPassword)) {
                        customerMenu(customerManager, customer, scanner);
                    } else {
                        System.out.println("Customer login failed. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Banking Application!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void adminMenu(Admin admin, CustomerManager customerManager, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Customer Accounts");
            System.out.println("2. View Customer Account Information");
            System.out.println("3. Block Customer Account");
            System.out.println("4. Create New Customer Account");
            System.out.println("5. Exit Admin Menu");

            int adminChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (adminChoice) {
                case 1:
                    admin.viewAllCustomerAccounts(customerManager);
                    break;

                case 2:
                    System.out.print("Enter the username of the account to view: ");
                    String usernameToView = scanner.nextLine();
                    Customer accountToView = admin.viewCustomerAccount(customerManager, usernameToView);
                    if (accountToView != null) {
                        System.out.println("Account Information:");
                        System.out.println("Username: " + accountToView.getUsername());
                        System.out.println("Name: " + accountToView.getName());
                        System.out.println("Contact: " + accountToView.getContact());
                        System.out.println("Balance: $" + accountToView.getBalance());
                        if (accountToView.isBlocked()) {
                            System.out.println("Account is blocked.");
                        } else {
                            System.out.println("Account is not blocked.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the username of the account to block: ");
                    String usernameToBlock = scanner.nextLine();
                    admin.blockCustomerAccount(customerManager, usernameToBlock);
                    break;

                case 4:
                    System.out.print("Enter new customer's username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter new customer's password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter new customer's name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new customer's contact: ");
                    String newContact = scanner.nextLine();
                    System.out.print("Enter initial balance for the new customer: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    admin.createNewAccount(customerManager, newUsername, newPassword, newName, newContact, initialBalance);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void customerMenu(CustomerManager customerManager, Customer customer, Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Update Contact Information");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Balance");
            System.out.println("5. Exit Customer Menu");

            int customerChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (customerChoice) {
                case 1:
                    System.out.print("Enter new contact information: ");
                    String newContact = scanner.nextLine();
                    customer.updateContact(newContact);
                    System.out.println("Contact information updated successfully!");
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    customer.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    if (customer.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or account is blocked.");
                    }
                    break;

                case 4:
                    System.out.println("Your balance: $" + customer.getBalance());
                    if (customer.isBlocked()) {
                        System.out.println("Your account is blocked.");
                    } else {
                        System.out.println("Your account is not blocked.");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
