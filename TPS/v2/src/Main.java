import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int numberOfTransaction=0;
        int failedTransaction=0 ;
        File balanceSheet=new File("data.txt");
        try {
            FileReader fileReader= new FileReader("data.txt");
            BufferedReader bufferedReader= new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        AccountHolder acc= new AccountHolder();

        ArrayList<AccountHolder> accountHolder = new ArrayList<>(Arrays.asList(
                new AccountHolder("ali", "123",1000),
                new AccountHolder("mai", "234", 2000),
                new AccountHolder("maha", "345", 3000),
                new AccountHolder("maha", "456", 4000)));
        while (true) {

            System.out.println("please select transaction ");
            System.out.println("1 journal");
            System.out.println("2 balance sheet ");
            System.out.println("3 transactions count");
            System.out.println("4 accounts names with highest balances");
            System.out.println("5 exit");
            String selectedTransaction = s.next();
            boolean check= false;
            boolean flag= false;

            if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                System.out.println("transaction type");
                String transactionType = s.next();
                System.out.println("enter amount");
                double amount = s.nextDouble();
                System.out.println("enter account number");
                String accountNo = s.next();
                //credit function
                if (transactionType.equalsIgnoreCase("credit")||transactionType.equalsIgnoreCase("cr")) {
                    for (int i = 0; i < accountHolder.size(); i++) {
                        if (accountNo.equals(accountHolder.get(i).getAccountNumber())) {
                            accountHolder.get(i).creditOperation(amount);
                            System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                            numberOfTransaction++;
                            check= true;
                            break;
                        }
                    }
                    if (!check){
                        failedTransaction++;
                        System.out.println("account number is not valid");
                    }
                    // debit function
                } else if (transactionType.equalsIgnoreCase("debit")||transactionType.equalsIgnoreCase("dr")) {
                    for (int i = 0; i < accountHolder.size(); i++) {
                        if (accountNo.equals(accountHolder.get(i).getAccountNumber())) {
                            accountHolder.get(i).debitOperation(amount);
                            System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                            numberOfTransaction++;
                            check= true;
                            break;
                        }
                    }if (!check) {
                        System.out.println("account number is not valid");
                        failedTransaction++;
                    };
                }
            } else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                for (int i = 0; i < accountHolder.size(); i++) {
                    System.out.println("account holder name " + accountHolder.get(i).getCustomerName()+"account number " + accountHolder.get(i).getAccountNumber()+"account balance" + accountHolder.get(i).getAccountBalance());
                }
            }
            else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
                System.out.println("count " + numberOfTransaction);
                System.out.println("failed " + failedTransaction);
            } else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("highest")) {

//                } else if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("exit")) {
//                 flag =true;
            }
        }
    }
}
