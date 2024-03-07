import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {


                Scanner s = new Scanner(System.in);
                int EmpCode = 0;
                int accountNo = 0;
                boolean rebeat = true;
                while (rebeat == true) {
                    System.out.println("Enter code: ");
                    String UserName = s.next();
                    System.out.println("Enter pass: ");
                    String pass = s.next();

                    //login step
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123")) {
                        con.setAutoCommit(false);
                        PreparedStatement st = con.prepareStatement("select UserName, Password,EmpCode from employee where UserName=? and Password=?");
                        st.setString(1, UserName);
                        st.setString(2, pass);
                        ResultSet resultS = st.executeQuery();
                        while (resultS.next()) {
                            EmpCode = resultS.getInt("EmpCode");

                        }

                        try (ResultSet resultSet = st.executeQuery();) {
                            //read row by row
                            if (resultSet.next() == true) {
                                rebeat = false;
                                /////////////////Main program
                                while (true) {
                                    System.out.println("\n" + "-------------------------" + "\n" + "please select operation " + "\n");
                                    System.out.println("1 Journal");
                                    System.out.println("2 Balance sheet ");
                                    System.out.println("3 Accounts with highest balances");
                                    System.out.println("4 Create New Account");
                                    System.out.println("5 Accounts Holder Data Editing");
                                    System.out.println("6 transactions view");
                                    System.out.println("7 transactions count view (normal and failed) by date");
                                    System.out.println("8  Employee transactions view (normal and failed)");
                                    System.out.println("9 10% interest");
                                    System.out.println("10 Exit");
                                    String selectedTransaction = s.next();
                                    boolean check = false;
                                    if (selectedTransaction.equals("10") || selectedTransaction.equalsIgnoreCase("exit"))
                                        return;

                                    else if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                                        while (true) {
                                            System.out.println("New Transaction or Exit");
                                            String transNew = s.next();
                                            if (transNew.equalsIgnoreCase("exit")) {
                                                break;
                                            } else if (transNew.equalsIgnoreCase("new") || transNew.equalsIgnoreCase("n")) {
                                                try {
                                                    System.out.println("enter account number");
                                                    accountNo = s.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("This is the account number , enter digit numbers only ");
                                                    s.next(); // clear the buffer
                                                   continue; // prompt again
                                                }
                                                double accbalance = 0;
                                                try (PreparedStatement st1 = con.prepareStatement("select AccHolderFname,Balance,AccNum from account where AccNum=?");) {
                                                    st1.setInt(1, accountNo);
                                                    ResultSet resultSet1 = st1.executeQuery();

                                                    if (resultSet1.next()) {
                                                        System.out.println("transaction type ");
                                                        String transactionType = s.next();

                                                        if (!(transactionType.equalsIgnoreCase("credit") || transactionType.equalsIgnoreCase("cr") || transactionType.equalsIgnoreCase("dr") || transactionType.equalsIgnoreCase("debit"))) {
                                                            System.out.println("wrong option ");
                                                            break;
                                                        }
                                                        else{
                                                        accbalance = resultSet1.getDouble("Balance");
                                                        System.out.println(resultSet1.getString("AccHolderFname") + " " + "Balance : " + accbalance);
                                                        double amount;
                                                        try {
                                                            System.out.println("enter amount");
                                                            amount = s.nextDouble();
                                                        } catch (InputMismatchException e) {
                                                            System.out.println(" enter digit numbers only ");
                                                            s.next(); // clear the buffer
                                                             // prompt again
                                                            try {
                                                                con.rollback();
                                                            }catch(SQLException e1){

                                                            }
                                                            continue;
                                                        }

                                                        //credit transaction
                                                        if (transactionType.equalsIgnoreCase("credit") || transactionType.equalsIgnoreCase("cr")) {
                                                            String sql4 = "INSERT INTO transactions (TransType,TransAmount,AccNum,EmpCode,TransDate,TransStatus) " + "VALUES (?, ?, ?,?,?,?)";

                                                            try (PreparedStatement preparedStatement = con.prepareStatement(sql4)) {
                                                                preparedStatement.setString(1, "credit");

                                                                preparedStatement.setDouble(2, amount);

                                                                preparedStatement.setInt(3, accountNo);

                                                                preparedStatement.setInt(4, EmpCode);

                                                                preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

                                                                if (amount > 0) {
                                                                    preparedStatement.setBoolean(6, true);

                                                                    ////update account balance
                                                                    try (PreparedStatement st2 = con.prepareStatement("UPDATE account SET Balance= Balance + ? where AccNum=?")) {
                                                                        st2.setDouble(1, amount);
                                                                        st2.setInt(2, accountNo);
                                                                        st2.executeUpdate();
                                                                        System.out.println("Transaction successful!");
                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }


                                                                    try (PreparedStatement st2 = con.prepareStatement("UPDATE employee SET SuccededTrans= SuccededTrans + 1 where EmpCode=?")) {
                                                                        st2.setDouble(1, EmpCode);
                                                                        st2.executeUpdate();

                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }

                                                                    try (PreparedStatement st2 = con.prepareStatement("UPDATE account SET BalanceStatus = ? where AccNum=? ")) {
                                                                        st2.setString(1, "stable");
                                                                        st2.setDouble(2, accountNo);
                                                                        st2.executeUpdate();
                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }

                                                                } else {
                                                                    preparedStatement.setBoolean(6, false);
                                                                    System.out.println("Transaction Failed!");
                                                                    try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET FailedTrans= FailedTrans + 1 where EmpCode=?")) {
                                                                        st2.setDouble(1, EmpCode);
                                                                        st2.executeUpdate();
                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }
                                                                }

                                                                preparedStatement.executeUpdate();
                                                                con.commit();

                                                            } catch (SQLException e) {
                                                                System.out.println("Error performing transaction: failed");
                                                                con.rollback();
                                                            } finally {
                                                                // Restore auto-commit mode
                                                                con.setAutoCommit(true);
                                                            }

///debit transaction
                                                        } else if (transactionType.equalsIgnoreCase("debit") || transactionType.equalsIgnoreCase("dr")) {
                                                            String sql4 = "INSERT INTO transactions (TransType,TransAmount,AccNum,EmpCode,TransDate,TransStatus) " + "VALUES (?, ?, ?,?,?,?)";
                                                            try (PreparedStatement preparedStatement = con.prepareStatement(sql4)) {
                                                                preparedStatement.setString(1, "debit");

                                                                preparedStatement.setDouble(2, amount);

                                                                preparedStatement.setInt(3, accountNo);

                                                                preparedStatement.setInt(4, EmpCode);

                                                                preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

                                                                if (amount > 0 && amount <= accbalance) {
                                                                    preparedStatement.setBoolean(6, true);
                                                                    try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("UPDATE account SET Balance= Balance - ? where AccNum=?")) {
                                                                        st2.setDouble(1, amount);
                                                                        st2.setInt(2, accountNo);
                                                                        st2.executeUpdate();
                                                                        System.out.println("successful Transaction !");

                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }

                                                                    try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("UPDATE account SET BalanceStatus = ? where AccNum=? AND Balance <= ?*0.5 ")) {
                                                                        st2.setString(1, "instable");
                                                                        st2.setInt(2, accountNo);
                                                                        st2.setDouble(3, accbalance);
                                                                        st2.executeUpdate();

                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }

                                                                    try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET SuccededTrans= SuccededTrans + 1 where EmpCode=?")) {
                                                                        st2.setDouble(1, EmpCode);
                                                                        st2.executeUpdate();


                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }
                                                                } else {
                                                                    preparedStatement.setBoolean(6, false);
                                                                    System.out.println("Transaction Failed!");
                                                                    try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET FailedTrans= FailedTrans + 1 where EmpCode=?")) {
                                                                        st2.setDouble(1, EmpCode);
                                                                        st2.executeUpdate();
                                                                    } catch (SQLException e) {
                                                                        System.out.println("Error performing transaction: " + e.getMessage());
                                                                        con.rollback();
                                                                    }


                                                                }

                                                                preparedStatement.executeUpdate();

                                                            } catch (SQLException e) {
                                                                System.out.println("Error performing transaction: " + e.getMessage());
                                                                con.rollback();
                                                            }


                                                        }}
                                                    } else {
                                                        System.out.println("No such account number exists.");
                                                        System.out.println("Do you want to create a new account? (y/n)");
                                                        String choice = s.next();
                                                        if (choice.equalsIgnoreCase("y")) {
                                                            // Code to create new account
                                                            System.out.println("Enter the following data:");

                                                            try {
                                                                System.out.println("Account Number");
                                                                int account_code = s.nextInt();
                                                            System.out.println("Account Type");
                                                            String AccType = s.next();
                                                            System.out.println("AccHolderSSN");
                                                            int AccHolderSSN = s.nextInt();
                                                            System.out.println("BranchName");
                                                            String BranchName = s.next();
                                                            System.out.println("balance_of_creation");
                                                            double balance_of_creation = s.nextDouble();
                                                            System.out.println("AccHolderFname");
                                                            String AccHolderFname = s.next();
                                                            System.out.println("AccHolderLname");
                                                            String AccHolderLname = s.next();
                                                            System.out.println("AccEmail");
                                                            String AccEmail = s.next();
                                                            System.out.println("Street");
                                                            String Street = s.next();
                                                            System.out.println("city");
                                                            String city = s.next();
                                                            System.out.println("phone");
                                                            String phone = s.next();

                                                            // Insert new account into the database
                                                            try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("INSERT INTO account (AccNum, AccHolderSSN,BranchName, Balance, AccHolderFname, AccHolderLname, AccEmail, Street,City,EmpCode,AccType,InitialBalance,InterestDate) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)")) {
                                                                st2.setInt(1, account_code);
                                                                st2.setInt(2, AccHolderSSN);
                                                                st2.setString(3, BranchName);
                                                                st2.setDouble(4, balance_of_creation);
                                                                st2.setString(5, AccHolderFname);
                                                                st2.setString(6, AccHolderLname);
                                                                st2.setString(7, AccEmail);
                                                                st2.setString(8, Street);
                                                                st2.setString(9, city);
                                                                st2.setInt(10, EmpCode);
                                                                st2.setString(11, AccType);
                                                                st2.setDouble(12, balance_of_creation);
                                                                st2.setDate(13, Date.valueOf(LocalDate.now()));
                                                                st2.executeUpdate();
                                                                System.out.println("Account Created successfully");
                                                            } catch (InputMismatchException e) {
                                                                System.out.println(" enter digit numbers only ");
                                                                s.next(); // clear the buffer
                                                                // prompt again
                                                                continue;
                                                            }
                                                            } catch (SQLException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        } else if (choice.equalsIgnoreCase("n")) {
                                                            break; // Go back to previous menu
                                                        } else {
                                                            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                                                        }

                                                    }

                                                } catch (SQLException e) {

                                                    System.out.println("fail");

                                                }

                                            }

                                         }
                                    }


                                    //balance sheet
                                    else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                                        try (PreparedStatement st2 = con.prepareStatement("select concat(AccHolderFname,' ', AccHolderLname) as name ,Balance,AccNum from account");) {
                                            ResultSet res = st2.executeQuery();
                                            System.out.println("Account-Holder-Name  || \t   Balance \t \t || \t  Account-number");
                                            System.out.println("====================================================================");
                                            while (res.next()) {
                                                System.out.println(res.getString("name") +"\t \t || \t \t"+res.getDouble("Balance") + "\t \t || \t \t"+ res.getInt("AccNum"));
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }


                                    }

                                    // highest account according to user percentage
                                    else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("highest")) {
                                        System.out.println("Select sorting by balance[b] or name[n] : ");
                                        String choise = s.next();
                                        System.out.println("Enter percentage for  highest balances : ");
                                        int percentage = s.nextInt();
                                        int noRows = 0;
                                        try (PreparedStatement st3 = con.prepareStatement("select count(*) as num from account")) {
                                            ResultSet res = st3.executeQuery();
                                            if (res.next()) {
                                                noRows = res.getInt("num");
                                                System.out.println(" number of accounts " + noRows);
                                            }
                                        }
                                        int limit = (noRows * percentage) / 100;
                                        //select balance for sorting
                                        if (choise.equalsIgnoreCase("b") || choise.equalsIgnoreCase("balance")) {
                                            try (PreparedStatement st2 = con.prepareStatement("select max(Balance) as max, concat(AccHolderFname,' ', AccHolderLname) as name ,AccNum,Balance from account group by AccNum order by Balance DESC limit ?");) {
//
                                                st2.setInt(1, limit);
                                                ResultSet res = st2.executeQuery();
                                                System.out.println("the highest balances");
                                                while (res.next()) {
                                                    System.out.println(" Name : " + res.getString("name") + "   Balance : " + res.getDouble("max") + "   Account-Number : " + res.getInt("AccNum"));
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        } else if ((choise.equalsIgnoreCase("n") || choise.equalsIgnoreCase("name"))) {
                                            try (PreparedStatement st2 = con.prepareStatement("select max(Balance) as max, concat(AccHolderFname,' ', AccHolderLname) as name ,AccNum,AccHolderFname,Balance from account group by AccNum order by AccHolderFname DESC limit ?");) {
                                                st2.setInt(1, limit);
                                                ResultSet res = st2.executeQuery();
                                                System.out.println("the highest balances");
                                                while (res.next()) {
                                                    System.out.println(" Name : " + res.getString("name") + "   Balance : " + res.getDouble("max") + "   Account-Number : " + res.getInt("AccNum"));
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                    }


// creating new account
                                    else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("Create")) {
                                        System.out.println("Enter the following data:");
                                        System.out.println("Account Number");
                                        int account_code = s.nextInt();
                                        System.out.println("Account Type");
                                        String AccType = s.next();
                                        System.out.println("AccHolderSSN");
                                        int AccHolderSSN = s.nextInt();
                                        System.out.println("BranchName");
                                        String BranchName = s.next();
                                        System.out.println("balance_of_creation");
                                        double balance_of_creation = s.nextDouble();
                                        System.out.println("AccHolderFname");
                                        String AccHolderFname = s.next();
                                        System.out.println("AccHolderLname");
                                        String AccHolderLname = s.next();
                                        System.out.println("AccEmail");
                                        String AccEmail = s.next();
                                        System.out.println("Street");
                                        String Street = s.next();
                                        System.out.println("city");
                                        String city = s.next();
                                        System.out.println("phone");
                                        String phone = s.next();

                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("INSERT INTO account (AccNum, AccHolderSSN,BranchName, Balance, AccHolderFname, AccHolderLname, AccEmail, Street,City,EmpCode,AccType,InitialBalance,InterestDate) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)")) {
                                            st2.setInt(1, account_code);
                                            st2.setInt(2, AccHolderSSN);
                                            st2.setString(3, BranchName);
                                            st2.setDouble(4, balance_of_creation);
                                            st2.setString(5, AccHolderFname);
                                            st2.setString(6, AccHolderLname);
                                            st2.setString(7, AccEmail);
                                            st2.setString(8, Street);
                                            st2.setString(9, city);
                                            st2.setInt(10, EmpCode);
                                            st2.setString(11, AccType);
                                            st2.setDouble(12, balance_of_creation);
                                            st2.setDate(13, Date.valueOf(LocalDate.now()));
                                            st2.executeUpdate();
                                            System.out.println("Account Created successfully");

                                        } catch (SQLException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("INSERT INTO phone (AccNum,Phone) VALUES (?,?) ")) {
                                            st2.setInt(1, account_code);
                                            st2.setString(2, phone);
                                            st2.executeUpdate();

                                        } catch (SQLException e) {
                                            System.out.println(e.getMessage());
                                        }

                                    }

                                    // Accounts Holder Data Editing
                                    else if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("Edit")) {
                                        System.out.println("please enter your account number:");
                                        int no = s.nextInt();
                                        try (PreparedStatement st1 = con.prepareStatement("select AccNum from account where AccNum=?");) {
                                            st1.setInt(1, no);
                                            ResultSet resultSet1 = st1.executeQuery();
                                            String dataType = "";

                                            if (resultSet1.next()) {
                                                while (!(dataType.equalsIgnoreCase("exit"))) {
                                                    System.out.println("choose the type of data that you want to update (email or street or ciy or phone ) or exit :");
                                                    dataType = s.next();
                                                    if (dataType.equalsIgnoreCase("exit")) break;

                                                    System.out.println(" enter the new data :");
                                                    String newdata = s.next();
                                                    if (dataType.equalsIgnoreCase("email") || dataType.equalsIgnoreCase("e")) {
                                                        try (PreparedStatement st2 = con.prepareStatement("update account set AccEmail =? where AccNum=?;");) {
                                                            st2.setString(1, newdata);
                                                            st2.setInt(2, no);
                                                            st2.executeUpdate();
                                                            System.out.println("updated successfully");
                                                        } catch (Exception e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    } else if (dataType.equalsIgnoreCase("street") || dataType.equalsIgnoreCase("s")) {
                                                        try (PreparedStatement st2 = con.prepareStatement("update account set Street =? where AccNum=?");) {
                                                            st2.setString(1, newdata);
                                                            st2.setInt(2, no);
                                                            st2.executeUpdate();
                                                            System.out.println("updated successfully");
                                                        } catch (Exception e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    } else if (dataType.equalsIgnoreCase("city") || dataType.equalsIgnoreCase("c")) {
                                                        try (PreparedStatement st2 = con.prepareStatement("UPDATE account SET City=? WHERE AccNum=?");) {
                                                            st2.setString(1, newdata);
                                                            st2.setInt(2, no);
                                                            st2.executeUpdate();
                                                            System.out.println("updated successfully");
                                                        } catch (Exception e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    } else if (dataType.equalsIgnoreCase("phone") || dataType.equalsIgnoreCase("p")) {
                                                        try (PreparedStatement st2 = con.prepareStatement("UPDATE phone SET phone=? WHERE AccNum=?");) {
                                                            st2.setString(1, newdata);
                                                            st2.setInt(2, no);
                                                            st2.executeUpdate();
                                                            System.out.println("updated successfully");
                                                        } catch (Exception e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (selectedTransaction.equals("6") || selectedTransaction.equalsIgnoreCase("transactions view")) {
                                        double cr = 0;
                                        double acBalance1 = 0;
                                        double acBalance2 =0;
                                        double deb = 0;
                                        double cre = 0;
                                        double dr = 0;
                                        System.out.println("Enter account number:");
                                        int accountNumber = s.nextInt();

                                        System.out.println("Enter start date (yyyy-MM-dd):");
                                        String startDate = s.next();

                                        System.out.println("Enter end date (yyyy-MM-dd):");
                                        String endDate = s.next();

                                        try (PreparedStatement st4 = con.prepareStatement("SELECT * FROM transactions WHERE AccNum = ? AND TransDate BETWEEN ? AND ?")) {
                                            st4.setInt(1, accountNumber);
                                            st4.setString(2, startDate);
                                            st4.setString(3, endDate);

                                            ResultSet rs = st4.executeQuery();

                                            System.out.println("Transactions for Account " + accountNumber + " between " + startDate + " and " + endDate + ":");
                                            System.out.println(" ");
                                            System.out.println("Transaction type || \t    Amount\t \t \t || \t       Date");
                                            System.out.println("====================================================================");
                                            while (rs.next()) {
                                                System.out.println(rs.getString("TransType") +"\t \t \t || \t \t"+ rs.getDouble("TransAmount") + "\t \t \t || \t \t"+rs.getString("TransDate"));
                                            }
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                        try (Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                             PreparedStatement st4 = con3.prepareStatement("SELECT 'credit' AS TransType, SUM(TransAmount) as sum FROM transactions WHERE AccNum = ? AND TransDate BETWEEN ? AND ? AND TransType like 'c%' AND TransStatus = 1\n" +
                                                     "union\n" +
                                                     "SELECT 'debit' AS TransType, SUM(TransAmount) as sum FROM transactions WHERE AccNum = ? AND TransDate BETWEEN ? AND ? AND TransType like 'd%' AND TransStatus = 1;")) {

                                            st4.setInt(1, accountNumber);
                                            st4.setString(2, startDate);
                                            st4.setDate(3, Date.valueOf(LocalDate.now()));
                                            st4.setInt(4, accountNumber);
                                            st4.setString(5, startDate);
                                            st4.setDate(6, Date.valueOf(LocalDate.now()));
                                            System.out.println("/////////");
                                            System.out.println(startDate);
                                            System.out.println(Date.valueOf(LocalDate.now()));
                                            ResultSet rs = st4.executeQuery();

                                            while (rs.next()) {
                                                String transType = rs.getString("TransType");
                                                if (transType.equals("credit")) {
                                                    cre = rs.getDouble("sum");
                                                } else if (transType.equals("debit")) {
                                                    deb = rs.getDouble("sum");
                                                }
                                            }

                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }




                                        System.out.println("////////////////");
                                        System.out.println(acBalance1);

                                        try (PreparedStatement st2 = con.prepareStatement("select Balance from account where AccNum=?");) {

                                            st2.setInt(1, accountNumber);
                                            ResultSet res = st2.executeQuery();
                                            while (res.next()) {
                                                acBalance1 = res.getDouble("Balance");
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        //startbalance
                                        double startball = acBalance1 - (cre - deb);
                                        System.out.println(acBalance1);

                                        System.out.println(startball);

                                        try (PreparedStatement st2 = con.prepareStatement("select Balance from account where AccNum=?");) {

                                            st2.setInt(1, accountNumber);
                                            ResultSet res = st2.executeQuery();
                                            while (res.next()) {
                                                acBalance2 = res.getDouble("Balance");
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }

                                        try (Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                             PreparedStatement st4 = con3.prepareStatement("SELECT 'credit' AS TransType, SUM(TransAmount) as sum FROM transactions WHERE AccNum = ? AND TransDate > ? AND TransDate <= ? AND TransType like 'c%' AND TransStatus = 1 \n" +
                                                     "UNION \n" +
                                                     "SELECT 'debit' AS TransType, SUM(TransAmount) as sum FROM transactions WHERE AccNum = ? AND TransDate > ? AND TransDate <= ? AND TransType like 'd%' AND TransStatus = 1;")) {
                                            st4.setInt(1, accountNumber);
                                            st4.setString(2, endDate);
                                            st4.setDate(3, Date.valueOf(LocalDate.now()));
                                            st4.setInt(4, accountNumber);
                                            st4.setString(5, endDate);
                                            st4.setDate(6, Date.valueOf(LocalDate.now()));
                                            ResultSet rs = st4.executeQuery();

                                            while (rs.next()) {
                                                String transType = rs.getString("TransType");
                                                if (transType.equals("credit")) {
                                                    cr = rs.getDouble("sum");
                                                } else if (transType.equals("debit")) {
                                                    dr = rs.getDouble("sum");
                                                }
                                            }

                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }


                                        double lastbalance = acBalance2 - (cr - dr);
                                        System.out.println("Balance in " + startDate + " : " + startball + "  " + "Balance in " + endDate + " : " + Math.abs(lastbalance));

                                    }

                                    //transactions count view (normal and failed) by date
                                    else if (selectedTransaction.equals("7") || selectedTransaction.equalsIgnoreCase("tc")) {
                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st1 = con2.prepareStatement("select count(TransStatus) as suc,TransDate from transactions where TransStatus=1 group by TransDate"); PreparedStatement st2 = con.prepareStatement("select count(TransStatus) as fail ,TransDate from transactions where TransStatus=0 group by TransDate");) {
                                            ResultSet res1 = st1.executeQuery();
                                            ResultSet res2 = st2.executeQuery();
                                            while (res1.next()) {
                                                System.out.println(" date : " + res1.getDate("TransDate") +"\t || \t"+ " succeeded Transaction  : " + res1.getInt("suc"));
                                                System.out.println("========================================================");
                                            }
                                            while (res2.next()) {
                                                System.out.println(" date : " + res2.getDate("TransDate") +"\t || \t"+  " Failed Transaction     : " + res2.getInt("fail"));
                                                System.out.println("========================================================");
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }

                                    //each employee transaction
                                    else if (selectedTransaction.equals("8") || selectedTransaction.equalsIgnoreCase("emptran")) {
                                        System.out.println("Enter employee code");
                                        int employee_code = s.nextInt();

                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st2 = con2.prepareStatement("select SuccededTrans, FailedTrans from employee where EmpCode= ?")) {
                                            st2.setInt(1, employee_code);
                                            st2.executeQuery();
                                            ResultSet resultSet3 = st2.executeQuery();
                                            if (resultSet3.next()) {
                                                System.out.println("The Employee whose code is " + employee_code + " has made the following trials:");
                                                System.out.println("succeeded trials: " + resultSet3.getInt("SuccededTrans"));
                                                System.out.println("failed trails: " + resultSet3.getInt("FailedTrans"));
                                            }

                                        } catch (SQLException e) {
                                            System.out.println(e.getMessage());
                                        }


                                    }
                                    //add 10% for your account ballance mouncely
                                    else if (selectedTransaction.equals("9") || selectedTransaction.equalsIgnoreCase("10% interest")) {
                                        int DateTotalMonths = 0;
                                        int DateTotalYears = 0;
                                        System.out.println("Enter account number:");
                                        int accountNum = s.nextInt();
                                        //check if 10% for this mounth added or not
                                        try (Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st5 = con4.prepareStatement("SELECT InterestDate from account WHERE AccNum = ? ")) {
                                            st5.setInt(1, accountNum);
                                            ResultSet rs = st5.executeQuery();

                                            while (rs.next()) {
                                                DateTotalMonths = (LocalDate.now().getMonthValue()) - (rs.getDate("InterestDate").toLocalDate().getMonthValue());
                                                DateTotalYears = (LocalDate.now().getYear()) - (rs.getDate("InterestDate").toLocalDate().getYear());

                                            }
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                        if (DateTotalMonths != 0 || DateTotalYears != 0) {
                                            //add 10% for balance
                                            try (Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st4 = con3.prepareStatement("UPDATE account SET Balance =Balance+InitialBalance*0.1 where AccNum =? AND AccType='saving'")) {

                                                st4.setInt(1, accountNum);

                                                int r = st4.executeUpdate();
                                                //check if saving or not
                                                if (r == 1) {
                                                    try (Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st5 = con4.prepareStatement("SELECT Balance from account WHERE AccNum = ? ")) {

                                                        st5.setInt(1, accountNum);
                                                        ResultSet rs = st5.executeQuery();

                                                        while (rs.next()) {

                                                            System.out.println("Current Balance after adding 10% interest to the initial amount: " + rs.getDouble("Balance"));

                                                        }

                                                    } catch (SQLException e) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    //set interest date
                                                    try (Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123"); PreparedStatement st5 = con4.prepareStatement("UPDATE account SET InterestDate=? where AccNum = ? ")) {

                                                        st5.setDate(1, Date.valueOf(LocalDate.now()));
                                                        st5.setInt(2, accountNum);
                                                        st5.executeUpdate();

                                                    } catch (SQLException e) {
                                                        throw new RuntimeException(e);
                                                    }

                                                } else {
                                                    System.out.println(" Account type is current ");
                                                    break;
                                                }

                                            } catch (SQLException e) {
                                                throw new RuntimeException(e);
                                            }
                                        } else {
                                            System.out.println(" 10% added this mounth ");
                                        }

                                    }

                                }

                            } else {
                                System.out.println(" Enter correct code or password ");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        }

