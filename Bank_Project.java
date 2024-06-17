import java.util.*;
import java.io.*;

//Admin class
class Admin {
    int pin;
    String name;
    String gender;
    long mobile;
    Date joiningDate = new Date();

}

// Customer class
class Customer {
    String name;
    String gender;
    long mobile;
    long accountNo;
    String address;
    int pin;
    int age;
    double amt;
    String ifscCode;
    String dob;
    Date deposit = new Date();
    Date withdraw = new Date();
}

public class Bank_Project {
    public static void main(String a[]) throws Exception {
        // clear();
        Scanner sc = new Scanner(System.in);
        int ch;
        String color, reset = "\u001B[0m";

        color = "\u001B[31m";

        System.out.println("\t\t\t\t====================================================================\n");
        System.out.println(color + "\t\t\t\t\t\t\tState Bank Of India\n" + reset);
        System.out.println("\t\t\t\t====================================================================\n");
        System.out.println("\t\t\t\t\t\tPlease Choose An Option: ");

        color = "\u001B[34m";
        System.out.println(color + "\n\n\t\t\t\t\t\t1. Bank Admin: " + reset);
        System.out.println(color + "\t\t\t\t\t\t2. Bank Customer: " + reset);

        System.out.println(color + "\t\t\t\t\t\t3. Exit" + reset);

        System.out.print("\n\n\t\t\t\t\t\tPlease Choose An Option: ");

        ch = sc.nextInt();

        switch (ch) {
            case 1:
                Admin();
                break;
            case 2:
                custmer();
                break;
            case 3:
                System.exit(0);
        }
    }

    public static void Admin() throws Exception {
        // local variable
        int ch;
        Scanner s = new Scanner(System.in);
        String color = "\u001B[34m", reset = "\u001B[0m";
        String t;

        while (true) {
            // clear();
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println(color + "\t\t\t\t\t\t1. Admine Registration: " + reset);
            System.out.println(color + "\t\t\t\t\t\t2. Admine Login: " + reset);
            System.out.println(color + "\t\t\t\t\t\t3. Exit" + reset);
            System.out.print("\n\n\t\t\t\t\t\tPlease Choose An Option: ");

            ch = s.nextInt();

            switch (ch) {
                case 1:
                    signup();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.exit(0);
            }

            System.out.print("\t\t\t\t\t\t\tDo You Want To Continue [Y/N]: ");
            s.nextLine();
            t = s.nextLine();

            if (t.equals("n"))
                break;
        }
    }

    // Signup Function
    public static void signup() throws Exception {
        // clear();

        // Basic Requirment object
        Admin em = new Admin();
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        String pin;

        System.out.print("\t\t\t\t\tPlease Enter The Password  Activate Your Admine Profile: ");
        Console con = System.console();
        char[] chars = con.readPassword();
        pin = new String(chars);

        if (pin.equals("Bank@123")) {
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t\t\t\t\t\tYour Login Pin Has Been Generated Successfully!");
            em.pin = random.nextInt(10000);

            System.out.print("\t\t\t\t\t\t\t\t\tPlease Enter Your Name: ");
            em.name = s.nextLine();

            System.out.print("\t\t\t\t\t\t\t\t\tGender[M/F]: ");
            em.gender = s.nextLine();

            System.out.print("\t\t\t\t\t\t\t\t\tPlease Enter Your 10 Digits Mobile Number: ");
            em.mobile = s.nextLong();

            System.out.print("\t\t\t\t\t\t\t\t\tJoining Date: " + em.joiningDate);

            // write data in file
            // FileWriter character Stream
            FileWriter fw = new FileWriter("Admin.txt", true);
            PrintWriter pw = new PrintWriter(fw);// All type of data can be stored

            pw.print(em.pin);
            pw.print(" ");
            pw.print(em.name);
            pw.print(" ");

            pw.print(em.gender);
            pw.print(" ");
            pw.print(em.mobile);
            pw.print("\n");

            pw.flush();
            pw.close();

            System.out.print("\n\n\n\t\t\t\t\t\t\t\t\tCongratulations! You Are Registered Successfully.");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\tInvalid Password Or You Are Not A Selected Candidate.");
            return;
        }
    }

    // Login Function
    public static void login() throws Exception {
        // clear();

        Scanner s = new Scanner(System.in);
        String localpin = null, pin;
        String line = null;
        boolean f = true;

        System.out.print("\t\t\t\t\t\t\t\t\tPlease Enter Your Pin: ");
        Console con = System.console();
        char[] chars = con.readPassword();
        pin = new String(chars);

        FileReader fr = new FileReader("Admin.txt");
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split(" ");
            localpin = temp[0];
            String color = "\u001B[34m", reset = "\u001B[0m";

            if (pin.equals(localpin)) {
                // clear();
                f = false;

                // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t\t\t\t\t\tAdmin DASHBOARD\n\n");
                System.out.println("\t\t\t\t\t\t\t\t\tWelcome : " + temp[1] + " " + temp[2]);

                System.out.println(color + "\t\t\t\t\t\t\t\t\t1. List Of All Customers: " + reset);
                System.out.println(color + "\t\t\t\t\t\t\t\t\t2. List Of All Home Loan Customers: " + reset);
                System.out.println(color + "\t\t\t\t\t\t\t\t\t3. List Of All Education Loan Customers: " + reset);
                // System.out.println(color + "\t\t\t\t\t\t\t\t\t4. Add Offer: " + reset);
                // System.out.println(color + "\t\t\t\t\t\t\t\t\t5. Remove Offer: " + reset);
                System.out.println(color + "\t\t\t\t\t\t\t\t\t6. Exit: " + reset);
                System.out.print("\n\n\t\t\t\t\t\t\t\t\tPlease Choose An Option: ");
                int ch;
                ch = s.nextInt();
                switch (ch) {
                    case 1:
                        listOfAllUsers();
                        break;
                    // case 2:
                    // listOfAllHomeLoanUsers();
                    // break;
                    case 3:
                        listOfAllEducationLoanUsers();
                        break;
                    case 4:
                        System.exit(0);
                }

            }
        }
        if (f)
            System.out.println("\t\t\t\t\t\t\t\t\t\tYou Have Entered Invalid Pin! Please Try Again.");

        fr.close();
        br.close();
    }

    // List Of All Education Loan Users
    public static void listOfAllEducationLoanUsers() throws Exception {
        String line = null;
        FileReader fr = new FileReader("educationloan.txt");
        BufferedReader br = new BufferedReader(fr);

        String name, gender, fatherName, course, collegeName;
        int age, c = 1;
        long mobile;
        double fatherSalary;

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            name = temp[0];
            age = Integer.parseInt(temp[1]);
            fatherName = temp[2];
            collegeName = temp[3];
            mobile = Long.parseLong(temp[4]);
            fatherSalary = Double.parseDouble(temp[5]);
            gender = temp[6];
            course = temp[7];

            System.out.print("User: " + c);
            System.out.println("\n\n");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Father's Name: " + fatherName);
            System.out.println("College Name: " + collegeName);
            System.out.println("Mobile Number: " + mobile);
            System.out.println("Father's Salary: " + fatherSalary);
            System.out.println("Gender: " + gender);
            System.out.println("Course: " + course);

            c++;
            System.out.println("\n\n");
        }

        fr.close();
        br.close();
    }

    // List Of All Users
    public static void listOfAllUsers() throws Exception {
        int c = 1;
        String line = null;
        File f = new File("customer.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Customer s = new Customer();

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            s.pin = Integer.parseInt(temp[0]);
            s.accountNo = Long.parseLong(temp[1]);
            s.ifscCode = temp[2];
            s.name = temp[3];
            s.gender = temp[4];
            s.address = temp[5];
            s.age = Integer.parseInt(temp[6]);
            s.mobile = Long.parseLong(temp[7]);
            s.dob = temp[8];
            s.amt = Double.parseDouble(temp[9]);

            System.out.print("User: " + c);
            System.out.println("\n\n");
            System.out.println("Pin: " + s.pin);
            System.out.println("Account Number: " + s.accountNo);
            System.out.println("IFSC Code: " + s.ifscCode);
            System.out.println("Name: " + s.name);
            System.out.println("Gender: " + s.gender);
            System.out.println("Address: " + s.address);
            System.out.println("Age: " + s.age);
            System.out.println("Mobile Number: " + s.mobile);
            System.out.println("DOB: " + s.dob);
            System.out.println("Amount: " + s.amt);

            c++;
            System.out.println("\n\n");
        }

        fr.close();
        br.close();
    }

    // Custmer method
    public static void custmer() throws Exception {
        Scanner s = new Scanner(System.in);
        int ch;
        String line, t;
        String color = "\u001B[31m";
        String reset = "\u001B[0m";
        while (true) {
            // clear();
            System.out.println("\n\n");
            // System.out.println(color + "\t\t\t\t\t\t\t\t\t\tExciting Offers For You!" +
            // reset);
            System.out.println("\n");
            color = "\u001B[33m";
            FileReader fr = new FileReader("bankoffer.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                System.out.println(color + "\t\t\t\t\t\t\t" + line + reset);
                System.out.print("\n");
            }

            fr.close();
            br.close();

            color = "\u001B[36m";

            System.out.println("\n\n\n");
            System.out.println(color + "\t\t\t\t\t\t\t1. Create New Account" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t2. Check Your Balance" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t3. Withdraw Money" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t4. Deposit" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t5. Transfer Money" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t6. Check Your All Last Transaction" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t7. Net Banking" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t8. Delete Account" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t9. Apply For Loan" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t10. Update Your Account" + reset);
            System.out.println(color + "\t\t\t\t\t\t\t11. Exit" + reset);
            System.out.print("\n\n\t\t\t\t\t\t\tPlease Choose An Option: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    newAccount();
                    break;
                case 2:
                    CheckBalance();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    checkAllLastTransaction();
                    break;

                case 8:
                    deleteAccount();
                    break;
                case 9:
                    applyLoan();
                    break;
                case 10:
                    // updateAccount();
                    break;
                case 11:
                    System.exit(0);
            }

            System.out.print("\t\t\t\t\t\t\t\t\t\tDo You Want To Continue[Y/N]: ");
            s.nextLine();
            t = s.nextLine();

            if (t.equals("n"))
                break;
        }
    }

    // Create new Account
    public static void newAccount() throws Exception {
        // clear();

        // basic requirment object
        Customer cu = new Customer();
        Scanner s = new Scanner(System.in);
        Random random = new Random();

        // write data in file
        FileWriter fw = new FileWriter("customer.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        cu.pin = random.nextInt(10000);
        System.out.println("\t\t\t\t\t\t\tYour Login Pin Has Been Generated Successfully!");
        cu.accountNo = random.nextInt(100000000);
        System.out.println("\t\t\t\t\t\t\tYour Account Number Successfully Generated");

        cu.ifscCode = "SBIN00" + random.nextInt(10000);
        System.out.println("\t\t\t\t\t\t\tYour Ifsc code Successfully Generated");

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your Name : ");
        cu.name = s.nextLine();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your Gender[M/F] : ");
        cu.gender = s.nextLine();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your Address : ");
        cu.address = s.nextLine();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your Date Of Birth[dd/MM/YYY] : ");
        cu.dob = s.nextLine();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your age : ");
        cu.age = s.nextInt();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Your MOblie : ");
        cu.mobile = s.nextLong();

        System.out.print("\t\t\t\t\t\t\tPlease Enter Initial Amout 2000 : ");
        cu.amt = s.nextDouble();

        while (cu.amt < 500) {
            System.out.print("\t\t\t\t\t\t\tPlease Deposit Amount Greater Than 500: ");
            cu.amt = s.nextDouble();
        }

        // clear();
        pw.print(cu.pin);
        pw.print("\t");
        pw.print(cu.accountNo);
        pw.print("\t");
        pw.print(cu.ifscCode);
        pw.print("\t");
        pw.print(cu.name);
        pw.print("\t");
        pw.print(cu.gender);
        pw.print("\t");
        pw.print(cu.address);
        pw.print("\t");
        pw.print(cu.age);
        pw.print("\t");
        pw.print(cu.mobile);
        pw.print("\t");
        pw.print(cu.dob);
        pw.print("\t");
        pw.print(cu.amt);
        pw.print("\n");

        pw.flush();
        pw.close();

        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\tCongratulation Your Account Created");
    }

    // Check balance
    public static void CheckBalance() throws Exception {
        Scanner s1 = new Scanner(System.in);
        // clear();
        String line = null;
        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);
        Customer s = new Customer();

        System.out.println("Please Enter A Pin");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        int pin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            s.pin = Integer.parseInt(temp[0]);

            if (s.pin == pin) {
                s.name = temp[3];
                s.gender = temp[4];
                s.mobile = Long.parseLong(temp[7]);
                s.amt = Double.parseDouble(temp[9]);
                s.accountNo = Long.parseLong(temp[1]);

                System.out.println("\n\n");
                System.out.println("Name : " + s.name);
                System.out.println("Gender : " + s.gender);
                System.out.println("Mobile Number : " + s.mobile);
                System.out.println("Account Number : " + s.accountNo);
                System.out.println("Amount : " + s.amt);

                break;
            }
        }
    }

    // Withdraw
    public static void withdraw() throws Exception {
        // clear();

        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);
        double amt;
        String line;

        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("customer1.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Plese Enter Your Pin Number");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        int pin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            cu.pin = Integer.parseInt(temp[0]);
            cu.accountNo = Long.parseLong(temp[1]);
            cu.ifscCode = temp[2];
            cu.name = temp[3];
            cu.gender = temp[4];
            cu.address = temp[5];
            cu.age = Integer.parseInt(temp[6]);
            cu.mobile = Long.parseLong(temp[7]);
            cu.dob = temp[8];
            cu.amt = Double.parseDouble(temp[9]);

            if (pin == cu.pin) {
                System.out.println("Please Enter A Amount");
                amt = s.nextDouble();

                if (cu.amt > amt) {
                    cu.amt = cu.amt - amt;

                    // new file to save all transaction
                    FileWriter fw1 = new FileWriter("transaction.txt", true);
                    PrintWriter pw1 = new PrintWriter(fw1);
                    FileWriter fw2 = new FileWriter("customer.txt");
                    PrintWriter pw2 = new PrintWriter(fw2);

                    String withdraw = "Withdraw : " + amt;
                    String updated = "Balance : " + cu.amt;
                    pw1.print(cu.pin);
                    pw1.print("\t");
                    pw1.print(cu.deposit);
                    pw1.print("\t");
                    pw1.print(withdraw);
                    pw1.print("\t");
                    pw1.print(updated);
                    pw1.print("\n");
                    fw1.close();
                    pw1.close();

                    // pw2.print(cu.pin);
                    // pw2.print("\t");
                    // pw2.print(cu.deposit);
                    // pw2.print("\t");
                    // pw2.print(withdraw);
                    // pw2.print("\t");
                    // pw2.print(updated);
                    // pw2.print("\n");
                    // fw2.close();
                    // pw2.close();

                    pw2.print(cu.pin);
                    pw2.print("\t");
                    pw2.print(cu.accountNo);
                    pw2.print("\t");
                    pw2.print(cu.ifscCode);
                    pw2.print("\t");
                    pw2.print(cu.name);
                    pw2.print("\t");
                    pw2.print(cu.gender);
                    pw2.print("\t");
                    pw2.print(cu.address);
                    pw2.print("\t");
                    pw2.print(cu.age);
                    pw2.print("\t");
                    pw2.print(cu.mobile);
                    pw2.print("\t");
                    pw2.print(cu.dob);
                    pw2.print("\t");
                    pw2.print(cu.amt);
                    pw2.print("\n");
                    fw2.close();
                    pw2.close();

                    pw.print(cu.pin);
                    pw.print("\t");
                    pw.print(cu.accountNo);
                    pw.print("\t");
                    pw.print(cu.ifscCode);
                    pw.print("\t");
                    pw.print(cu.name);
                    pw.print("\t");
                    pw.print(cu.gender);
                    pw.print("\t");
                    pw.print(cu.address);
                    pw.print("\t");
                    pw.print(cu.age);
                    pw.print("\t");
                    pw.print(cu.mobile);
                    pw.print("\t");
                    pw.print(cu.dob);
                    pw.print("\t");
                    pw.print(cu.amt);
                    pw.print("\n");
                } else {
                    System.out.println("Insufficient Balnace.......");
                }
            } else {
                pw.print(cu.pin);
                pw.print("\t");
                pw.print(cu.accountNo);
                pw.print("\t");
                pw.print(cu.ifscCode);
                pw.print("\t");
                pw.print(cu.name);
                pw.print("\t");
                pw.print(cu.gender);
                pw.print("\t");
                pw.print(cu.address);
                pw.print("\t");
                pw.print(cu.age);
                pw.print("\t");
                pw.print(cu.mobile);
                pw.print("\t");
                pw.print(cu.dob);
                pw.print("\t");
                pw.print(cu.amt);
                pw.print("\n");
            }
        }
        fw.close();
        pw.close();

        fr.close();
        br.close();

        File oldFile = new File("customer.txt");

        oldFile.delete();

        File on = new File("customer1.txt");
        File nn = new File("customer.txt");

        on.renameTo(nn);
    }

    // Deposit
    public static void deposit() throws Exception {
        // clear();

        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);
        double amt;
        String line;

        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("customer1.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Plese Enter Your Pin Number");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        int pin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            cu.pin = Integer.parseInt(temp[0]);
            cu.accountNo = Long.parseLong(temp[1]);
            cu.ifscCode = temp[2];
            cu.name = temp[3];
            cu.gender = temp[4];
            cu.address = temp[5];
            cu.age = Integer.parseInt(temp[6]);
            cu.mobile = Long.parseLong(temp[7]);
            cu.dob = temp[8];
            cu.amt = Double.parseDouble(temp[9]);

            if (pin == cu.pin) {
                System.out.println("Plese Enter A Amount");
                amt = s.nextDouble();
                cu.amt = cu.amt + amt;

                // new file to save all transaction
                FileWriter fw1 = new FileWriter("transaction.txt", true);
                PrintWriter pw1 = new PrintWriter(fw1);

                // FileWriter fw2 = new FileWriter("customer.txt");
                // PrintWriter pw2 = new PrintWriter(fw2);

                String deposit = "deposit : " + amt;
                String updated = "Balance : " + cu.amt;
                pw1.print(cu.pin);
                pw1.print("\t");
                pw1.print(cu.deposit);
                pw1.print("\t");
                pw1.print(deposit);
                pw1.print("\t");
                pw1.print(updated);
                pw1.print("\n");
                fw1.close();
                pw1.close();

                // pw2.print(cu.pin);
                // pw2.print("\t");
                // pw2.print(cu.accountNo);
                // pw2.print("\t");
                // pw2.print(cu.ifscCode);
                // pw2.print("\t");
                // pw2.print(cu.name);
                // pw2.print("\t");
                // pw2.print(cu.gender);
                // pw2.print("\t");
                // pw2.print(cu.address);
                // pw2.print("\t");
                // pw2.print(cu.age);
                // pw2.print("\t");
                // pw2.print(cu.mobile);
                // pw2.print("\t");
                // pw2.print(cu.dob);
                // pw2.print("\t");
                // pw2.print(cu.amt);
                // pw2.print("\n");
                // fw2.close();
                // pw2.close();

                pw.print(cu.pin);
                pw.print("\t");
                pw.print(cu.accountNo);
                pw.print("\t");
                pw.print(cu.ifscCode);
                pw.print("\t");
                pw.print(cu.name);
                pw.print("\t");
                pw.print(cu.gender);
                pw.print("\t");
                pw.print(cu.address);
                pw.print("\t");
                pw.print(cu.age);
                pw.print("\t");
                pw.print(cu.mobile);
                pw.print("\t");
                pw.print(cu.dob);
                pw.print("\t");
                pw.print(cu.amt);
                pw.print("\n");
            } else {
                pw.print(cu.pin);
                pw.print("\t");
                pw.print(cu.accountNo);
                pw.print("\t");
                pw.print(cu.ifscCode);
                pw.print("\t");
                pw.print(cu.name);
                pw.print("\t");
                pw.print(cu.gender);
                pw.print("\t");
                pw.print(cu.address);
                pw.print("\t");
                pw.print(cu.age);
                pw.print("\t");
                pw.print(cu.mobile);
                pw.print("\t");
                pw.print(cu.dob);
                pw.print("\t");
                pw.print(cu.amt);
                pw.print("\n");
            }
        }
        fw.close();
        pw.close();

        fr.close();
        br.close();

        File oldFile = new File("customer.txt");

        oldFile.delete();

        File on = new File("customer1.txt");
        File nn = new File("customer.txt");

        on.renameTo(nn);
    }

    // Transfer money
    public static void transferMoney() throws Exception {
        // clear();

        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);
        double amt = 0.0;
        String line;
        long account;
        double amount;
        boolean f = false;

        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("customer1.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Plese Enter Your Pin Number");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        int localpin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            int pin = Integer.parseInt(temp[0]);
            double firstAmount = Double.parseDouble(temp[9]);

            if (localpin == pin) {
                f = true;
                System.out.println("Please Enter A Acoount Number : ");
                account = s.nextLong();

                System.out.println("Please Enter A Amount How Much You Want To Transfer : ");
                amount = s.nextDouble();

                String line1;

                FileReader fr1 = new FileReader("customer.txt");
                BufferedReader br1 = new BufferedReader(fr1);

                while ((line1 = br1.readLine()) != null) {
                    String temp1[] = line1.split("\t");

                    cu.pin = Integer.parseInt(temp1[0]);
                    cu.accountNo = Long.parseLong(temp1[1]);
                    cu.ifscCode = temp1[2];
                    cu.name = temp1[3];
                    cu.gender = temp1[4];
                    cu.address = temp1[5];
                    cu.age = Integer.parseInt(temp1[6]);
                    cu.mobile = Long.parseLong(temp1[7]);
                    cu.dob = temp1[8];
                    cu.amt = Double.parseDouble(temp1[9]);

                    if (account == cu.accountNo) {
                        if (cu.amt > amount) {
                            cu.amt = cu.amt - amount;

                            pw.print(cu.pin);
                            pw.print("\t");
                            pw.print(cu.accountNo);
                            pw.print("\t");
                            pw.print(cu.ifscCode);
                            pw.print("\t");
                            pw.print(cu.name);
                            pw.print("\t");
                            pw.print(cu.gender);
                            pw.print("\t");
                            pw.print(cu.address);
                            pw.print("\t");
                            pw.print(cu.age);
                            pw.print("\t");
                            pw.print(cu.mobile);
                            pw.print("\t");
                            pw.print(cu.dob);
                            pw.print("\t");
                            pw.print(cu.amt);
                            pw.print("\n");

                        }
                    } else if (cu.pin == localpin) {
                        cu.amt = cu.amt - amount;
                        pw.print(cu.pin);
                        pw.print("\t");
                        pw.print(cu.accountNo);
                        pw.print("\t");
                        pw.print(cu.ifscCode);
                        pw.print("\t");
                        pw.print(cu.name);
                        pw.print("\t");
                        pw.print(cu.gender);
                        pw.print("\t");
                        pw.print(cu.address);
                        pw.print("\t");
                        pw.print(cu.age);
                        pw.print("\t");
                        pw.print(cu.mobile);
                        pw.print("\t");
                        pw.print(cu.dob);
                        pw.print("\t");
                        pw.print(cu.amt);
                        pw.print("\n");
                    } else {
                        pw.print(cu.pin);
                        pw.print("\t");
                        pw.print(cu.accountNo);
                        pw.print("\t");
                        pw.print(cu.ifscCode);
                        pw.print("\t");
                        pw.print(cu.name);
                        pw.print("\t");
                        pw.print(cu.gender);
                        pw.print("\t");
                        pw.print(cu.address);
                        pw.print("\t");
                        pw.print(cu.age);
                        pw.print("\t");
                        pw.print(cu.mobile);
                        pw.print("\t");
                        pw.print(cu.dob);
                        pw.print("\t");
                        pw.print(cu.amt);
                        pw.print("\n");
                    }
                    line1 = null;
                }
                fr1.close();
                br1.close();
            }
            if (f)
                break;
        }

        fw.close();
        pw.close();

        fr.close();
        br.close();

        File oldFile = new File("customer.txt");

        oldFile.delete();

        File on = new File("customer1.txt");
        File nn = new File("customer.txt");

        on.renameTo(nn);
        if (f)
            System.out.println("Your Money Successfull Transfer...");
        if (!f)
            System.out.println("You Are Not A Valid Customer Of Our Bank Please First Open Your Bank Account");
    }

    // check All Transaction
    public static void checkAllLastTransaction() throws Exception {

        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);
        int localpin;
        String line;

        FileReader fr = new FileReader("transaction.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println("Plese Enter Your Pin Number");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        localpin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");

            cu.pin = Integer.parseInt(temp[0]);

            if (localpin == cu.pin) {
                String deposit = temp[1];
                String withdraw = temp[2];
                String balance = temp[3];

                System.out.println();
                System.out.println(deposit + "\t" + withdraw + "\t" + balance);
                System.out.println();
            }
        }
    }

    // delete account
    public static void deleteAccount() throws Exception {

        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);
        int localpin;
        String line;

        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("customer1.txt");
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Plese Enter Your Pin Number");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        localpin = Integer.parseInt(j);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");
            cu.pin = Integer.parseInt(temp[0]);
            cu.accountNo = Long.parseLong(temp[1]);
            cu.ifscCode = temp[2];
            cu.name = temp[3];
            cu.gender = temp[4];
            cu.address = temp[5];
            cu.age = Integer.parseInt(temp[6]);
            cu.mobile = Long.parseLong(temp[7]);
            cu.dob = temp[8];
            cu.amt = Double.parseDouble(temp[9]);

            if (localpin == cu.pin) {
                continue;
            } else {
                pw.print(cu.pin);
                pw.print("\t");
                pw.print(cu.accountNo);
                pw.print("\t");
                pw.print(cu.ifscCode);
                pw.print("\t");
                pw.print(cu.name);
                pw.print("\t");
                pw.print(cu.gender);
                pw.print("\t");
                pw.print(cu.address);
                pw.print("\t");
                pw.print(cu.age);
                pw.print("\t");
                pw.print(cu.mobile);
                pw.print("\t");
                pw.print(cu.dob);
                pw.print("\t");
                pw.print(cu.amt);
                pw.print("\n");
            }
        }
        fw.close();
        pw.close();

        fr.close();
        br.close();

        File oldFile = new File("customer.txt");

        oldFile.delete();

        File on = new File("customer1.txt");
        File nn = new File("customer.txt");

        on.renameTo(nn);

        System.out.println("You Are No Longer Customer Of Our Bank...");
    }

    // Apply Loan
    public static void applyLoan() throws Exception {
        // clear();
        Scanner s = new Scanner(System.in);
        int ch;
        System.out.println("\t\t\t\t\t\tPlease Choose An Options");
        System.out.println("\t\t\t\t\t\t1. Home Loan");
        System.out.println("\t\t\t\t\t\t2. Education");
        System.out.println("\t\t\t\t\t\t3. Exit");

        System.out.print("\t\t\t\t\t\tPlease Choose An Option To Check Sanctioned Loan Amount: ");
        ch = s.nextInt();

        switch (ch) {
            case 1:
                // homeLoan();
                break;
            case 2:
                educationLoan();
                break;
            case 3:
                System.exit(0);
        }
    }

    // Education Loan
    public static void educationLoan() throws Exception {
        // clear();
        Scanner s = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\tWelcome To State Bank Of India!");
        System.out.println("\t\t\t\t\t\t\t\t\t\tPlease Fill The Loan Form To Apply: ");
        String course, collegeName, fatherName;
        double fatherSalary;

        System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter Your Pin Number: ");
        Console con = System.console();
        char[] chars = con.readPassword();
        String j = new String(chars);
        int pin = Integer.parseInt(j);

        String line = null;
        FileReader fr1 = new FileReader("customer.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        Customer s1 = new Customer();
        boolean f = true;

        while ((line = br1.readLine()) != null) {
            String temp[] = line.split("\t");
            s1.pin = Integer.parseInt(temp[0]);
            s1.name = temp[3];
            s1.gender = temp[4];
            s1.address = temp[5];
            s1.age = Integer.parseInt(temp[6]);
            s1.mobile = Long.parseLong(temp[7]);

            if (pin == s1.pin) {
                f = false;
                System.out.println("\t\t\t\t\t\t\t\t\t\tName: " + s1.name);
                System.out.println("\t\t\t\t\t\t\t\t\t\tGender: " + s1.gender);
                System.out.println("\t\t\t\t\t\t\t\t\t\tAddress: " + s1.address);
                System.out.println("\t\t\t\t\t\t\t\t\t\tAge: " + s1.age);
                System.out.println("\t\t\t\t\t\t\t\t\t\tMobile: " + s1.mobile);
                break;
            }
        }
        fr1.close();
        br1.close();

        if (f) {
            System.out
                    .println("\t\t\t\t\t\t\t\t\t\tSorry! You Are Not An Existing Customer. Please Open Account First.");
            return;
        }

        System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter Your Father Name: ");
        s.nextLine();
        fatherName = s.nextLine();

        System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter Your College Name: ");
        collegeName = s.nextLine();

        System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter Your Course Name: ");
        course = s.nextLine();

        if (s1.age < 18) {
            System.out.println(
                    "\t\t\t\t\t\t\t\t\t\tSorry! You Are Not Eligible For The Education Loan As Your Age Must Be Above 18");
            return;
        }

        System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter Your Father's Monthly Income: ");
        fatherSalary = s.nextDouble();

        if (fatherSalary < 15000) {
            System.out.println(
                    "\t\t\t\t\t\t\t\t\t\tSorry! You Are Not Eligible For The Education Loan As Your Father's Income Must Be Above 15000");
            return;
        }

        FileWriter fw = new FileWriter("educationloan.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(s1.name);
        pw.print("\t");
        pw.print(s1.age);
        pw.print("\t");
        pw.print(fatherName);
        pw.print("\t");
        pw.print(collegeName);
        pw.print("\t");
        pw.print(s1.mobile);
        pw.print("\t");
        pw.print(fatherSalary);
        pw.print("\t");
        pw.print(s1.gender);
        pw.print("\t");
        pw.print(course);
        pw.print("\t");
        pw.print(s1.mobile);
        pw.print("\n");

        fw.close();
        pw.close();

        // clear();
        System.out.println("\t\t\t\t\t\t\t\t\tHurray! Your Loan Application Has Been Approved.");
        line = null;
        f = true;
        Customer cu = new Customer();
        double amount = 0;

        System.out.print("\t\t\t\t\t\t\t\t\tPlease Enter Your Pin To Verify Your Bank A/C: ");
        con = System.console();
        chars = con.readPassword();
        j = new String(chars);
        pin = Integer.parseInt(j);

        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw1 = new FileWriter("customer1.txt");
        PrintWriter pw1 = new PrintWriter(fw1);

        while ((line = br.readLine()) != null) {
            String temp[] = line.split("\t");

            cu.pin = Integer.parseInt(temp[0]);
            cu.accountNo = Long.parseLong(temp[1]);
            cu.ifscCode = temp[2];
            cu.name = temp[3];
            cu.gender = temp[4];
            cu.address = temp[5];
            cu.age = Integer.parseInt(temp[6]);
            cu.mobile = Long.parseLong(temp[7]);
            cu.dob = temp[8];
            cu.amt = Double.parseDouble(temp[9]);

            if (pin == cu.pin) {
                System.out.print("\t\t\t\t\t\t\t\t\t\tPlease Enter The Loan Amount You Want To Get Sanctioned: ");
                amount = s.nextDouble();

                cu.amt = cu.amt + amount;

                pw1.print(cu.pin);
                pw1.print("\t");
                pw1.print(cu.accountNo);
                pw1.print("\t");
                pw1.print(cu.ifscCode);
                pw1.print("\t");
                pw1.print(cu.name);
                pw1.print("\t");
                pw1.print(cu.gender);
                pw1.print("\t");
                pw1.print(cu.address);
                pw1.print("\t");
                pw1.print(cu.age);
                pw1.print("\t");
                pw1.print(cu.mobile);
                pw1.print("\t");
                pw1.print(cu.dob);
                pw1.print("\t");
                pw1.print(cu.amt);
                pw1.print("\n");
            } else {
                pw1.print(cu.pin);
                pw1.print("\t");
                pw1.print(cu.accountNo);
                pw1.print("\t");
                pw1.print(cu.ifscCode);
                pw1.print("\t");
                pw1.print(cu.name);
                pw1.print("\t");
                pw1.print(cu.gender);
                pw1.print("\t");
                pw1.print(cu.address);
                pw1.print("\t");
                pw1.print(cu.age);
                pw1.print("\t");
                pw1.print(cu.mobile);
                pw1.print("\t");
                pw1.print(cu.dob);
                pw1.print("\t");
                pw1.print(cu.amt);
                pw1.print("\n");
            }
        }

        fr.close();
        br.close();

        fw1.close();
        pw1.close();
        File oldFile = new File("customer.txt");

        oldFile.delete();

        File on = new File("customer1.txt");
        File nn = new File("customer.txt");

        on.renameTo(nn);
        System.out.println(
                "\t\t\t\t\t\t\t\t\t\tCongratulations! Your Loan Amount Has Been Deposited Successfully To Your Bank A/C");

        System.out.println("Now You Can Withdraw Rs. " + amount + " And Make Your Bright Future!");
        System.in.read();
        withdraw();
    }
}