import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private int balance;
    private char password;

    public Account(int accountNumber, int balance, char password) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public char getPassword() {
        return password;
    }
}

class ATM {
    private Account[] accounts;
    private Scanner scanner;

    public ATM(Account[] accounts) {
        this.accounts = accounts;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter the account number: ");
        int accnum = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Account account = validateAccount(accnum);
        if (account != null) {
            System.out.print("Enter the password: ");
            char pass = scanner.nextLine().charAt(0);

            if (account.getPassword() == pass) {
                int choice;
                do {
                    System.out.println("Enter 1 for balance\n2 for withdrawal\n3 for deposit\n4 for transfer\n5 to exit");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            checkBalance(account);
                            break;
                        case 2:
                            withdraw(account);
                            break;
                        case 3:
                            deposit(account);
                            break;
                        case 4:
                            transfer(account);
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } while (choice != 5);

                saveAccounts();
            } else {
                System.out.println("Invalid password.");
            }
        } else {
            System.out.println("Invalid account number.");
        }

        scanner.close();
    }

    private Account validateAccount(int accnum) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                return account;
            }
        }
        return null;
    }

    private void checkBalance(Account account) {
        System.out.println("Your balance is: " + account.getBalance());
    }

    private void withdraw(Account account) {
        System.out.print("Enter the amount to be withdrawn: ");
        int withamm = scanner.nextInt();
        if (withamm <= account.getBalance()) {
            account.setBalance(account.getBalance() - withamm);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit(Account account) {
        System.out.print("Enter the amount to be deposited: ");
        int depamm = scanner.nextInt();
        account.setBalance(account.getBalance() + depamm);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    private void transfer(Account fromAccount) {
        System.out.print("Enter the account number to transfer to: ");
        int toAccNum = scanner.nextInt();
        Account toAccount = validateAccount(toAccNum);

        if (toAccount != null) {
            System.out.print("Enter the amount to be transferred: ");
            int transferamm = scanner.nextInt();
            if (transferamm <= fromAccount.getBalance()) {
                fromAccount.setBalance(fromAccount.getBalance() - transferamm);
                toAccount.setBalance(toAccount.getBalance() + transferamm);
                System.out.println("Transfer successful. New balance: " + fromAccount.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid target account number.");
        }
    }

    private void saveAccounts() {
        try (FileWriter file = new FileWriter("accounts.txt", true)) {
            for (Account account : accounts) {
                file.write(account.getAccountNumber() + "," + account.getBalance() + "," + account.getPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error opening the file.");
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Account[] accounts = {
            new Account(1, 20, 'a'),
            new Account(2, 30, 'b'),
            new Account(3, 40, 'c')
        };

        ATM atm = new ATM(accounts);
        atm.start();
    }
}
