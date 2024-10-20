import java.util.Scanner;

class ATM {
    float Balance = 20000;
    final int PIN = 5674;
    
    public void checkPin() {
        System.out.print("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu(sc);
        } else {
            System.out.println("Please enter a valid pin");
        }
    }

    public void menu(Scanner sc) {
        System.out.println("\nHere are some list of choices:");
        System.out.println("1. Check account balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");

        System.out.print("\nEnter a choice: ");
        int option = sc.nextInt();

        if (option == 1) {
            checkBalance(sc);
        } else if (option == 2) {
            withdrawMoney(sc);
        } else if (option == 3) {
            depositMoney(sc);
        } else if (option == 4) {
            System.out.println("Thanks for visiting");
        } else {
            System.out.println("Enter a valid choice");
            menu(sc);
        }
    }

    public void checkBalance(Scanner sc) {
        System.out.println("Balance: " + Balance);
        menu(sc);
    }

    public void withdrawMoney(Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        float amount = sc.nextFloat();

        if (amount > Balance) {
            System.out.println("Insufficient balance");
        } else {
            Balance -= amount;
            System.out.println("Amount withdrawal successful");
        }
        menu(sc);
    }

    public void depositMoney(Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        float amount = sc.nextFloat();

        Balance += amount;
        System.out.println("Amount deposit successful");
        menu(sc);
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}
