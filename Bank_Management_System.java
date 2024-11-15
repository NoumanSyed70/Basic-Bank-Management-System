import java.util.ArrayList;
import java.util.Scanner;
class BankAccount {
    private Integer accountID;
    private String accountHolderName;
    private Double balance;
    private String accountType;
    private Double[] transactions;
    Scanner xyz = new Scanner(System.in);

    // Default Constructor //
    BankAccount() {
        accountID = 0;
        accountHolderName = "";
        balance = 0.0;
        accountType = "";
        // System.out.println("Default Constructor."); //
    }
    // Parametrized Constructor //
    BankAccount(int acc_id, String acc_holder_name, Double balnce, String acc_type, Double[] arr) {
        accountID = acc_id;
        accountHolderName = acc_holder_name;
        balance = balnce;
        accountType = acc_type;
        int size = arr.length;
        transactions = new Double[size];
        for (int i = 0; i < size; i++) {
            transactions[i] = arr[i];
        }
    }

    // Copy Constructor
    public BankAccount(BankAccount obj) {
        accountID = obj.accountID;
        accountHolderName = obj.accountHolderName;
        balance = obj.balance;
        accountType = obj.accountType;
        int size = obj.transactions.length;
        transactions = new Double[size];
        for (int i = 0; i < size; i++) {
            transactions[i] = obj.transactions[i];
        }
    }

    public void display() {
        System.out.println("Account ID: " + accountID);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        if(transactions != null) {
            System.out.println("Last 5 Transactions.");
            for (int i = 0; i < 5; i++) {
                System.out.println("Transaction " + (5 -  i) + ": " + transactions[i]);
            }
        }
        else{
            System.out.println("No transaction history");
        }
    }
    // ToString function If I need to print whole object by System.out.println(); //
    public String toString() {
        return "Account ID: " + accountID + "\nAccount Holder Name: " + accountHolderName + "\nAccount Balance: " + balance + "\nAccount Type: " + accountType;
    }
    //Setters
    public void setAccountID(int accountID){
        this.accountID = accountID;
    }
    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    //Getters
    public int getID(){
        return this.accountID;
    }
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    public Double getBalance(){
        return this.balance;
    }
    public String getAccountType(){
        return this.accountType;
    }
    public void setTransactions(Double [] transactions){
        int size = transactions.length;
        this.transactions = new Double[size];
        for(int i = 0; i < size;i++){
            this.transactions[i] = transactions[i];
        }
    }
    public Double[]  getTransactions(){
        return transactions;
    }
    // To find account with highest balance
    public BankAccount findHighestBalance(ArrayList<BankAccount> obj){
        if(obj == null || obj.isEmpty()){
            return null;
        }
            BankAccount abc = obj.get(0);
            for (BankAccount i : obj) {
                if (abc.getBalance() < i.getBalance()) {
                    abc = i;
                }
            }
            return abc;
    }
    public void withdrawal(Double withdrawal_amount){
        int size = transactions.length;
        if(withdrawal_amount > 0 && withdrawal_amount <= balance) {
            balance = balance - withdrawal_amount;
            System.out.println("Your current balance is: " + balance);
            for(int i = 0; i < size;i++) {
                if (i < size - 1) {
                    transactions[i] = transactions[i + 1];
                }
                else {
                    transactions[i] = withdrawal_amount;
                }
            }
            System.out.println("Your Last 5 Transactions now.");
            for (int i = 0; i < size; i++) {
                System.out.println("Transaction " + (size -  i) + ": " + transactions[i]);
            }
        }
        else {
            System.out.println("Invalid Input.");
        }
    }
    public void deposit(Double amount){
        int size = transactions.length;
        if(amount > 0) {
            System.out.println("Amount deposited successfully.");
            balance = balance + amount;
            System.out.println("Your current balance is " + balance);
            for(int i = 0; i < size;i++) {
                if (i < size - 1) {
                    transactions[i] = transactions[i + 1];
                }
                else {
                    transactions[i] = amount;
                }
            }
            System.out.println("Your Last 5 Transactions now.");
            for (int i = 0; i < size ; i++) {
                System.out.println("Transaction " + (size - i) + ": " + transactions[i]);
            }
        }
        else {
            System.out.println("Invalid input.");
        }
    }

}

public class Bank_Management_System {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("Bank Managememnt System");
        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        Scanner xyz = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        String choice;
        do {
            BankAccount newAccount = new BankAccount();
            System.out.println("Enter account ID.");
            int accid = xyz.nextInt();
            if(accid > 0) {
                newAccount.setAccountID(accid);
            }
            else{
                System.out.println("Invalid Input.");
                System.exit(0);
            }
            // Removes buffer
            xyz.nextLine();
            System.out.println("Enter Acount Holder Name.");
            String name = xyz.nextLine();
            newAccount.setAccountHolderName(name);
            System.out.println("Enter account Balance.");
            Double Balance = xyz.nextDouble();
            if(Balance >0) {
                newAccount.setBalance(Balance);
            }
            else{
                System.out.println("Invalid Input.");
                System.exit(0);
            }
            System.out.println("Enter account type. (Savings or Current)");
            String acc_type = xyz.next();
            newAccount.setAccountType(acc_type);
            if(acc_type.equals("Savings") || acc_type.equals("Current")) {
            }
            else {
                System.out.println("Invalid input.");
                break;
            }
            System.out.println("Enter transaction History of last 5 transactions.");
            Double [] arr = new Double[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Transaction " + (5 - i) + ": ");
                arr[i] = xyz.nextDouble();
                if(arr[i] > 0) {
                    continue;
                }
                else{
                    System.out.println("Invalid Input.");
                    System.exit(0);
                }
            }
            newAccount.setTransactions(arr);
            //BankAccount newAccount = new BankAccount(accid, name, Balance, acc_type, arr);
            accounts.add(newAccount);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("Do you want to add 1 more account details? if yes pres y/Y.");
            choice = xyz.next();
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------\n");
        } while (choice.equals("yes") || choice.equals("Yes") || choice.equals("YES") || choice.equals("y") || choice.equals("Y") );
        int ch;
        do {
            System.out.println("What do you want to see? Details of all accounts or the account with highest balance?.");
            System.out.println("Enter 1 to see all accounts and 2 for the account with highest balance, 3 to deposit money in a specific account and 4 to withdraw money from an account.");
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------\n");
            ch = xyz.nextInt();
            if (ch == 1) {
                for (BankAccount i : accounts) {
                    System.out.println(i);
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------------\n");
                }
            }
            else if (ch == 2) {
                BankAccount highest_balance = new BankAccount();
                highest_balance.findHighestBalance(accounts).display();

                System.out.println("\n----------------------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------------------\n");
            }
            else if (ch == 3) {
                System.out.println("Enter account ID in which you want to deposit money.");
                int id = xyz.nextInt();
                Boolean check = false;
                if (id > 0) {
                    for (BankAccount i : accounts) {
                        if (id == i.getID()) {
                            System.out.println("Enter the ammount you want to deposit.");
                            Double deposit_am = xyz.nextDouble();
                            if (deposit_am > 0) {
                                i.deposit(deposit_am);
                            } else {
                                System.out.println("Invalid Input.");
                                System.exit(0);
                            }
                            check = true;
                        }
                    }
                    if(!check){
                        System.out.println("Invalid Input.");
                    }
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------------\n");
                } else {
                    System.out.println("Invalid Input.");
                    System.exit(0);
                }
            }
            else if (ch == 4) {
                Boolean check = false;
                System.out.println("Enter the account ID from which you want to withdraw money.");
                int id = xyz.nextInt();
                if (id > 0) {
                    for (BankAccount i : accounts) {
                        if (i.getID() == id) {
                            check = true;
                            System.out.println("Enter the ammount you want to withdraw.");
                            Double withdraw_ammunt = xyz.nextDouble();
                            if (!(withdraw_ammunt > 0 && withdraw_ammunt <= i.getBalance())) {
                                System.out.println("Invalid Input.");
                                System.exit(0);
                            } else {
                                i.withdrawal(withdraw_ammunt);
                            }
                        }
                    }
                    if(!check){
                        System.out.println("Invalid Input.");
                    }
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------------\n");
                } else {
                    System.out.println("Invalid Input.");
                    System.exit(0);
                }
            }
            else if(ch == 5){
                do {
                    BankAccount newAccount = new BankAccount();
                    System.out.println("Enter account ID.");
                    int accid = xyz.nextInt();
                    if(accid > 0) {
                        newAccount.setAccountID(accid);
                    }
                    else{
                        System.out.println("Invalid Input.");
                        System.exit(0);
                    }
                    // Removes buffer
                    xyz.nextLine();
                    System.out.println("Enter Acount Holder Name.");
                    String name = xyz.nextLine();
                    newAccount.setAccountHolderName(name);
                    System.out.println("Enter account Balance.");
                    Double Balance = xyz.nextDouble();
                    if(Balance >0) {
                        newAccount.setBalance(Balance);
                    }
                    else{
                        System.out.println("Invalid Input.");
                        System.exit(0);
                    }
                    System.out.println("Enter account type. (Savings or Current)");
                    String acc_type = xyz.next();
                    newAccount.setAccountType(acc_type);
                    if(acc_type.equals("Savings") || acc_type.equals("Current")) {
                    }
                    else {
                        System.out.println("Invalid input.");
                        break;
                    }
                    System.out.println("Enter transaction History of last 5 transactions.");
                    Double [] arr = new Double[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Transaction " + (5 - i) + ": ");
                        arr[i] = xyz.nextDouble();
                        if(arr[i] > 0) {
                            continue;
                        }
                        else{
                            System.out.println("Invalid Input.");
                            System.exit(0);
                        }
                    }
                    newAccount.setTransactions(arr);
                    //BankAccount newAccount = new BankAccount(accid, name, Balance, acc_type, arr);
                    accounts.add(newAccount);
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------------\n");
                    System.out.println("Do you want to add 1 more account details? if yes pres y/Y.");
                    choice = xyz.next();
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------------\n");
                } while (choice.equals("yes") || choice.equals("Yes") || choice.equals("YES") || choice.equals("y") || choice.equals("Y") );
            }
        } while (ch == 1 || ch == 2 || ch == 3 || ch == 4 || ch == 5);
        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("Thank you for using.");
        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n");
    }
}