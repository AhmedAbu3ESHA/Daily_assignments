import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int EmpCode = 0;
        int accountNo = 0;
        boolean rebeat = true;
        while (rebeat == true) {
            System.out.println("enter code");
            String UserName = s.next();
            System.out.println("enter pass");
            String pass = s.next();

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                 PreparedStatement st = con.prepareStatement("select UserName, Password,EmpCode from employee where UserName=? and Password=?");
            ) {
                st.setString(1, UserName);
                st.setString(2, pass);
                ResultSet resultS = st.executeQuery();
                while (resultS.next()) {
                    EmpCode = resultS.getInt("EmpCode");
                    System.out.println(EmpCode);
                }

                try (ResultSet resultSet = st.executeQuery();) {
                    //read row by row
                    if (resultSet.next() == true) {
                        rebeat = false;
                        /////////////////Main program
                        while (true) {
                            System.out.println("\n" + "-------------------------" + "\n" + "please select operation " + "\n");
                            System.out.println("1 journal");
                            System.out.println("2 balance sheet ");
                            System.out.println("3 transactions count for employee");
                            System.out.println("4 accounts names with highest balances");
                            System.out.println("5 Create Account");
                            System.out.println("6 update data");
                            System.out.println("7 Displaying the transactions");
                            System.out.println("8 exit");
                            String selectedTransaction = s.next();
                            boolean check = false;
                            if (selectedTransaction.equals("8") || selectedTransaction.equalsIgnoreCase("exit"))
                                return;

                            else if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                                while (true) {
                                    System.out.println("transaction type or Exit");
                                    String transactionType = s.next();
                                    if (transactionType.equalsIgnoreCase("exit")) {
                                        break;
                                    } else if (!(transactionType.equalsIgnoreCase("credit") || transactionType.equalsIgnoreCase("debit") || transactionType.equalsIgnoreCase("exit"))) {
                                        System.out.println("wrong option ");
                                        break;
                                    }
                                    System.out.println("enter account number");
                                    accountNo = s.nextInt();
                                    double accbalance = 0;
                                    try (Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                         PreparedStatement st1 = con1.prepareStatement("select AccHolderFname,Balance,AccNum from account where AccNum=?");) {
                                        st1.setInt(1, accountNo);
                                        ResultSet resultSet1 = st1.executeQuery();
                                        if (resultSet1.next()) {
                                            accbalance = resultSet1.getDouble("Balance");
                                            System.out.println(resultSet1.getString("AccHolderFname") + " " + "Balance : " + accbalance);
                                            System.out.println("enter amount");
                                            double amount = s.nextDouble();
                                            if (transactionType.equalsIgnoreCase("credit")) {
                                                String sql4 = "INSERT INTO transactions (TransType,TransAmount,AccNum,EmpCode,TransDate,TransStatus) " +
                                                        "VALUES (?, ?, ?,?,?,?)";
                                                try (PreparedStatement preparedStatement = con.prepareStatement(sql4)) {
                                                    preparedStatement.setString(1, transactionType);

                                                    preparedStatement.setDouble(2, amount);

                                                    preparedStatement.setInt(3, accountNo);

                                                    preparedStatement.setInt(4, EmpCode);

                                                    preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

                                                    if (amount > 0) {
                                                        preparedStatement.setBoolean(6, true);

                                                        ////update account balance
                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE account SET Balance= Balance + ? where AccNum=?")) {
                                                            st2.setDouble(1, amount);
                                                            st2.setInt(2, accountNo);
                                                            st2.executeUpdate();
                                                            System.out.println("Transaction successful!");
                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }


                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET SuccededTrans= SuccededTrans + 1 where EmpCode=?")) {
                                                            st2.setDouble(1, EmpCode);
                                                            st2.executeUpdate();
                                                            System.out.println("Transaction successful!");

                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }


                                                    } else {
                                                        preparedStatement.setBoolean(6, false);
                                                        System.out.println("Transaction Failed!");
                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET FailedTrans= FailedTrans + 1 where EmpCode=?")) {
                                                            st2.setDouble(1, EmpCode);
                                                            st2.executeUpdate();
                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }
                                                    }
                                                    preparedStatement.executeUpdate();


                                                } catch (SQLException e) {
                                                    System.out.println("Error performing transaction: " + e.getMessage());
                                                }


                                            } else if (transactionType.equalsIgnoreCase("debit")) {
                                                String sql4 = "INSERT INTO transactions (TransType,TransAmount,AccNum,EmpCode,TransDate,TransStatus) " +
                                                        "VALUES (?, ?, ?,?,?,?)";
                                                try (PreparedStatement preparedStatement = con.prepareStatement(sql4)) {
                                                    preparedStatement.setString(1, transactionType);

                                                    preparedStatement.setDouble(2, amount);

                                                    preparedStatement.setInt(3, accountNo);

                                                    preparedStatement.setInt(4, EmpCode);

                                                    preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

                                                    if (amount > 0 && amount <= accbalance) {
                                                        preparedStatement.setBoolean(6, true);
                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE account SET Balance= Balance - ? where AccNum=?")) {
                                                            st2.setDouble(1, amount);
                                                            st2.setInt(2, accountNo);
                                                            st2.executeUpdate();
                                                            System.out.println("Transaction successful!");

                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }

                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET SuccededTrans= SuccededTrans + 1 where EmpCode=?")) {
                                                            st2.setDouble(1, EmpCode);
                                                            st2.executeUpdate();
                                                            System.out.println("Transaction successful!");

                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }
                                                    } else {
                                                        preparedStatement.setBoolean(6, false);
                                                        System.out.println("Transaction Failed!");
                                                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                                             PreparedStatement st2 = con2.prepareStatement("UPDATE employee SET FailedTrans= FailedTrans + 1 where EmpCode=?")) {
                                                            st2.setDouble(1, EmpCode);
                                                            st2.executeUpdate();
                                                        } catch (SQLException e) {
                                                            System.out.println("Error performing transaction: " + e.getMessage());
                                                        }


                                                    }
                                                    preparedStatement.executeUpdate();
                                                } catch (SQLException e) {
                                                    System.out.println("Error performing transaction: " + e.getMessage());
                                                }


                                            }
                                        }

                                    } catch (SQLException e) {
                                        System.out.println(e.getMessage());
                                    }

                                }

                            } else if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("Create")) {
                                System.out.println("Enter the following data:");
                                System.out.println("Account Number");
                                int account_code = s.nextInt();
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
                                String  Street = s.next();
                                System.out.println("city");
                                String city = s.next();
                                System.out.println("phone");
                                String phone = s.next();

                                try (
                                        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                        PreparedStatement st2 = con2.prepareStatement("INSERT INTO account (AccNum, AccHolderSSN,BranchName, Balance, AccHolderFname, AccHolderLname, AccEmail, Street,City,EmpCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)")
                                ) {
                                    st2.setInt(1, account_code);
                                    st2.setInt(2, AccHolderSSN);
                                    st2.setString(3,BranchName );
                                    st2.setDouble(4, balance_of_creation);
                                    st2.setString(5,AccHolderFname );
                                    st2.setString(6, AccHolderLname);
                                    st2.setString(7,AccEmail );
                                    st2.setString(8,Street );
                                    st2.setString(9, city);
                                    st2.setInt(10,EmpCode );
                                    st2.executeUpdate();
                                    System.out.println("Account Created successfully");

                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                try (
                                        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                        PreparedStatement st2 = con2.prepareStatement("INSERT INTO phone (AccNum,Phone) VALUES (?,?) ")
                                ) {
                                    st2.setInt(1,account_code);
                                    st2.setString(2, phone);
                                    st2.executeUpdate();

                                }
                                catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }

                            }else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
                                System.out.println("Enter employee code");
                                int employee_code = s.nextInt();

                                try (
                                        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/banktps", "root", "root123");
                                        PreparedStatement st2 = con2.prepareStatement("select SuccededTrans, FailedTrans from employee where EmpCode= ?")
                                ) {
                                    st2.setInt(1,employee_code);
                                    st2.executeQuery();
                                    ResultSet resultSet3 = st2.executeQuery();
                                    if (resultSet3.next()) {
                                        System.out.println("succeeded trials: "+resultSet3.getInt("SuccededTrans") ) ;
                                        System.out.println("failed trails: "+resultSet3.getInt("FailedTrans") ) ;}

                                }
                                catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }



                            } //balance
                            else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                                try (
                                        PreparedStatement st2 = con.prepareStatement("select concat(AccHolderFname,' ', AccHolderLname) as name ,Balance,AccNum from account");
                                ) {
                                    ResultSet res = st2.executeQuery();
                                    while(res.next()) {
                                        System.out.println("account holder name "+ res.getString("name")
                                                +" balance "+ res.getDouble("Balance")+
                                                "account number "+res.getInt("AccNum") );
                                    }
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            ///count
//                            else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
//                                try (
//                                        PreparedStatement st2 = con.prepareStatement
//                                                ("select sum(SuccededTrans) as suc,  sum(FailedTrans) as fail ,EmpCode from employee group by EmpCode");
//                                ) {
//                                    ResultSet res = st2.executeQuery();
//                                    while(res.next()) {
//                                        System.out.println( " employee number "+ res.getInt("EmpCode")+" Right Transaction " + res.getInt("suc"));
//                                        System.out.println(" employee number "+ res.getInt("EmpCode")+" Failed Transaction " + res.getInt("fail"));
//                                    }
//                                }catch (Exception e) {
//                                    System.out.println(e.getMessage());
//                                }
//
//                            }
                            // max
                            else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("highest")) {
                                try (PreparedStatement st2 = con.prepareStatement
                                        ("select max(Balance) as max, concat(AccHolderFname,' ', AccHolderLname) as name ,Balance,AccNum  from account group by AccNum   limit 2");) {
                                    ResultSet res = st2.executeQuery();
                                    System.out.println("the highest balances");
                                    while(res.next()) {
                                        System.out.println( " name "+ res.getString("name")+
                                                " balance " + res.getDouble("Balance")+ " account number "+ res.getInt("AccNum"));
                                    }
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                            }// update
                            else if (selectedTransaction.equals("6") || selectedTransaction.equalsIgnoreCase("update")) {
                                System.out.println("please enter your account number:");
                                int no = s.nextInt();
                                try (PreparedStatement st1 = con.prepareStatement("select AccNum from account where AccNum=?");) {
                                    st1.setInt(1, no);
                                    ResultSet resultSet1 = st1.executeQuery();
                                    String dataType = "";

                                    if (resultSet1.next()) {
                                        while (!(dataType.equalsIgnoreCase("exit"))) {
                                            System.out.println("choose the type of data that you want to update (email or street or ciy) :");
                                            dataType = s.next();
                                            if (dataType.equalsIgnoreCase("exit")) break;

                                            System.out.println(" enter the new data :");
                                            String newdata = s.next();
                                            if (dataType.equalsIgnoreCase("email")) {
                                                try (PreparedStatement st2 = con.prepareStatement
                                                        ("update account set AccEmail =? where AccNum=?;");) {
                                                    st2.setString(1, newdata);
                                                    st2.setInt(2, no);
                                                    st2.executeUpdate();
                                                    System.out.println("updated successfully");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            } else if (dataType.equalsIgnoreCase("street")) {
                                                try (PreparedStatement st2 = con.prepareStatement
                                                        ("update account set Street =? where AccNum=?");) {
                                                    st2.setString(1, newdata);
                                                    st2.setInt(2, no);
                                                    st2.executeUpdate();
                                                    System.out.println("updated successfully");
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            } else if (dataType.equalsIgnoreCase("city")) {
                                                try (PreparedStatement st2 = con.prepareStatement
                                                        ("UPDATE account SET City=? WHERE AccNum=?") ;) {
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
                            } else if (selectedTransaction.equals("7") || selectedTransaction.equalsIgnoreCase("Displaying the transactions")) {

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

                                    while (rs.next()) {
                                        System.out.println("Type: " + rs.getString("TransType") +"  "+"Amount: " + rs.getDouble("TransAmount")+"  "+ "Date: " + rs.getString("TransDate"));
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }

                            }

                        }


                    } else {
                        System.out.println("invalid data");
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