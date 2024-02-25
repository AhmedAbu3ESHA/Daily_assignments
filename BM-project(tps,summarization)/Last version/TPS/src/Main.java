import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int numberOfTransaction=0;
        int failedTransaction=0 ;
        Scanner input = new Scanner(System.in);
        List<AccountHolder> clientData;
        ArrayList<AccountHolder> accountHolder=new ArrayList<>();
        String line= null;
        String lastWord;
        List<String> Lastwords = new ArrayList<>();
        File balanceSheet = new File("data.txt");
        try (FileReader fileReader = new FileReader("data.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                lastWord = line.substring(line.lastIndexOf(" ") + 1);
                if (!lastWord.equals("----")){
                    Lastwords.add(lastWord);
                    continue;
                }
                clientData=(new ArrayList<AccountHolder>(Arrays.asList(new AccountHolder(Lastwords.get(0),Lastwords.get(1), Double.parseDouble(Lastwords.get(2))))));
                accountHolder.add(clientData.get(0));
                Lastwords.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AccountHolder acc = new AccountHolder();

        while (true) {
            System.out.println("\n"+"-------------------------"+"\n"+"please select operation "+"\n");
            System.out.println("1 journal");
            System.out.println("2 balance sheet ");
            System.out.println("3 transactions count");
            System.out.println("4 accounts names with highest balances");
            System.out.println("5 Create Account");
            System.out.println("6 exit");
            String selectedTransaction = input.next();
            boolean check= false;
            if (selectedTransaction.equals("6") || selectedTransaction.equalsIgnoreCase("exit")) {
                saveDataInfile(accountHolder);
                return;}

            else if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                while (true) {
                    System.out.println("transaction type or Exit");
                    String transactionType = input.next();
                    if (transactionType.equalsIgnoreCase("exit")) break;
                    System.out.println("enter account number");
                    String accountNo = input.next();
                    System.out.println("enter amount");
                   double amount = input.nextDouble();
                        //credit function
                        String creatAccountCr;
                        String creatAccountDr;
                        if (transactionType.equalsIgnoreCase("credit") || transactionType.equalsIgnoreCase("cr")) {
                            for (int i = 0; i < accountHolder.size(); i++) {
                                if (accountNo.equals(accountHolder.get(i).getAccountNumber()) && amount > 0) {
                                    accountHolder.get(i).creditOperation(amount);
                                    System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                                    numberOfTransaction++;
                                    saveDataInfile(accountHolder);
                                    check = true;
                                    break;
                                }
                            }

                            if (!check) {
                                failedTransaction++;
                                System.out.println("wrong operation");
                                if ((amount > 0)) {
                                    System.out.println("Do you want to creat account? [y,n]");
                                    creatAccountCr = input.next();
                                    if (creatAccountCr.equalsIgnoreCase("y")) {
                                        System.out.println("create Account \n");
                                        createAccount(input, accountHolder);
                                        saveDataInfile(accountHolder);
                                    } else if (creatAccountCr.equalsIgnoreCase("n")) {
                                        System.out.println("Account not exist ");
                                    }
                                } else {
                                    System.out.println("wrong Amount");
                                }

                            }

                            System.out.println("Do you want to continue??(y,n,main)");
                            String choose = input.next();
                            if (choose.equalsIgnoreCase("n")) {
                                saveDataInfile(accountHolder);
                                return;
                            } else if (choose.equalsIgnoreCase("main")) {
                                break;
                            } else {saveDataInfile(accountHolder); }

                            // debit function
                        } else if (transactionType.equalsIgnoreCase("debit") || transactionType.equalsIgnoreCase("dr")) {
                            for (int i = 0; i < accountHolder.size(); i++) {
                                if (accountNo.equals(accountHolder.get(i).getAccountNumber()) && amount < accountHolder.get(i).getAccountBalance()) {
                                    accountHolder.get(i).debitOperation(amount);
                                    System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                                    numberOfTransaction++;
                                    saveDataInfile(accountHolder);
                                    check = true;
                                    break;
                                }}
                            if (!check) {
                                for (int j = 0; j < accountHolder.size(); j++) {
                                    if (!accountNo.equals(accountHolder.get(j).getAccountNumber()) && (amount < accountHolder.get(j).getAccountBalance())) {
                                        failedTransaction++;
                                        System.out.println("Do you want to create account? [y,n]");
                                        creatAccountDr = input.next();
                                        if (creatAccountDr.equalsIgnoreCase("y")) {
                                            System.out.println("create Account \n");
                                            createAccount(input, accountHolder);
                                            saveDataInfile(accountHolder);
                                            break;
                                        } else if (creatAccountDr.equalsIgnoreCase("n")) {
                                            System.out.println("Account not exist ");
                                            break;
                                        }
                                    }
                                    else {
                                        failedTransaction++;
                                        System.out.println("wrong amount");
                                        System.out.println("Do you want to continue??(y,n,main)");
                                        String choose = input.next();
                                        if (choose.equalsIgnoreCase("n")) {
                                            saveDataInfile(accountHolder);
                                            return;
                                        } else if (choose.equalsIgnoreCase("main")) {
                                            break;
                                        } else {
                                            saveDataInfile(accountHolder);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                check=false;
                }}

                else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                for (int i = 0; i < accountHolder.size(); i++) {
                    System.out.println("Account holder name " + accountHolder.get(i).getCustomerName()+" , Number " + accountHolder.get(i).getAccountNumber()+" , Balance " + accountHolder.get(i).getAccountBalance());

                }
                check= true;
            }
            else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
                System.out.println("Right Transaction " + numberOfTransaction);
                System.out.println("Failed Transaction " + failedTransaction);
                check= true;
            } else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("highest")) {
           accountHolder.stream()
                   .sorted(Comparator.<AccountHolder>comparingDouble(accountHolder1-> accountHolder1.getAccountBalance()).reversed())
                   .limit(2)
                   .forEach(accountHolder1 -> System.out.println(accountHolder1.getCustomerName()+ "\t" +accountHolder1.getAccountNumber()+"\t"+accountHolder1.getAccountBalance()));
                check= true;

            }else if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("Create")) {
                System.out.println("Pleas enter new account data ");
                System.out.println("Format Hint: Name:firstname-lastname   Account number must be 8 digit ");
                createAccount(input, accountHolder);

            }
        }}
    private static void saveDataInfile(ArrayList<AccountHolder> accountHolder) {
        try (FileWriter writer=new FileWriter("data.txt");
             BufferedWriter pr=new BufferedWriter(writer);) {
             for (int i = 0; i < accountHolder.size(); i++ ){
                 pr.write(String.valueOf("name: "+ accountHolder.get(i).getCustomerName()+"\n"+"accountNumber: "+ accountHolder.get(i).getAccountNumber()+ "\n" +"balance: "+(accountHolder.get(i).getAccountBalance())+"\n"+"----"+"\n"));
             }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createAccount(Scanner s, ArrayList<AccountHolder> accountHolder) {
        List<AccountHolder> clientData;
        System.out.println("Name : ");
        String name = s.next();
        System.out.println("account number must be 8 digits");
        System.out.println("account number : ");
        String accNum = s.next();
        while (accNum.length() != 8){
            System.out.println("account number must be 8 digits");
            System.out.println("account number : ");
            accNum = s.next();
            if(accNum.length() == 8){
                System.out.println("Balance: ");
                double bal= s.nextDouble();
                clientData=(new ArrayList<AccountHolder>(Arrays.asList(new AccountHolder(name,accNum,bal))));
                accountHolder.add(clientData.get(0));
                System.out.println("account created");
                break;
            }
        }
    }
}