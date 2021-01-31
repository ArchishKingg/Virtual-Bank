package Java;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;
public class VirtualBankAssistant {
    static Scanner s = new Scanner(System.in);    
    static Random r = new Random();
    static String name,gender,greetm = "Sir!",greetf = "Mam!";
    static int age,pin,otp,eap;
    static long acno;
    static int interest;
    static DecimalFormat formatter = new DecimalFormat("####,####,####");
    public static void main(String[] args) {
        System.out.println("=============| XYZ Bank |=============\n"
                         + "Hello! Welcome to XYZ Bank\n" + 
                         "I am your Virtual Assistant Esteben");
        System.out.println("Enter your name please");
        name = s.nextLine();
        System.out.format("Hello %s! Please enter your gender " ,name);
        System.out.println("Press 'M' for Male and 'F' for Female");
        gender = s.nextLine();
        switch(gender) {
            case "M" :
                System.out.println("Hello Sir Please enter your age"); break;
            case "F" :
                System.out.println("Hello Mam Please enter your age"); break;
            default:
                System.out.println("Wrong Input"); break;
        }                   
        age = s.nextInt();
        while (true) {
            if (age > 18) {
                continue;
            }
            else if (age < 18){
                System.out.println("You are not elible to have a bank account");
                break;
            }
            System.out.println("Please enter your Account Number Make sure it is 12 characters long");
            while(true) {
                acno = s.nextLong();
                DecimalFormat formatter = new DecimalFormat("####,####,####");
                String str = formatter.format(acno);
                int strLen = str.length();
                int len = strLen - 2;
                if (len == 12) {
                    break;
                }
                else if (len < 12){
                    System.out.println("It is too short for a Account number");
                    System.out.print("Try again\nAcoount number : ");
                    continue;
                }
                else if (len > 12) {
                    System.out.println("It is too long for a Account number");
                    System.out.print("Try again\nAcoount number : ");
                    continue;
                }
            }
            System.out.println("==================|Account Details|==================\n" + 
                            "Name = " + name + 
                            "\nAge = " + age + 
                            "\nGender = " + gender + 
                            "\nAccount number = "+ acno);
            System.out.println("We have sent an OTP(4-digits) in your Registered Mobile Number");
            System.out.print("Enter your OTP: ");  //Enter any 4-digit number
            otp = s.nextInt();
            System.out.println("Congratulations! You have successfully completed your "+
                               "Account verification");
            choose();
        }
    }
    public static void choose() {           
        System.out.println("Choose the option you want to check\n" + 
                            "Press 1 to Check Account Balance\n" +
                            "Press 2 to Change ATM Pin\n" +
                            "Press 3 to Check Deposit Interest Rates\n" +
                            "Press 4 to Deposit Cash\n" + 
                            "Press 5 to Check Loan Interes Rates\n" + 
                            "Press 6 to apply for Loan");
        int op = s.nextInt(); 
        switch(op) {
            case 1:
                accbalancecheck(); break;
            case 2:
                atmpin(); break;
            case 3:
                intpol(); break;
            case 4:
                dc(); break;
            case 5:
                clp(); break;
            case 6:
                aplyfl(); break;
            default:
                System.out.println("Wrong Input"); break;
        }
    }
    public static void accbalancecheck() {
        System.out.print("Please Enter the Account number : ");
        double acno1 = s.nextDouble();
        System.out.println("Account number entered : " + acno1);
        long avc = r.nextInt(500000);
        System.out.println("Available Account balance = " + avc); 
        System.out.println("Do you wish to continue? Press Y to continue N to Cancle");
        String as = s.next(); 
        switch(as) {
            case "Y":
                choose(); break;
            case "N":
                System.out.println("Thank you for using our service! Have a great day"); break;
            default:
                System.out.println("Wrong Input"); break;
        }
    }
    public static void atmpin() {
        System.out.println("Enter existing ATM Pin");
        eap = s.nextInt();
        while(true) {
            System.out.println("Enter new ATM Pin");
            int nap = s.nextInt();
            System.out.println("Cnfirm new ATM Pin");
            int nap1 = s.nextInt();
            if (nap == nap1) {
                System.out.println("PIN successfully Changed");
                break;
            }
            else {
                System.out.println("Wrong PIN Entered! Try again");
                continue;
            }
        }  
        System.out.println("Do you wish to continue? Press Y to continue N to Cancle");
        String as1 = s.next(); 
        switch(as1) {
            case "Y":
                choose(); break;
            case "N":
                System.out.println("Thank you for using our service! Have a great day"); break;
            default:
                System.out.println("Wrong Input"); break;
            }
    }
    public static void intpol() {
        System.out.println("We Provide Handsome Interest rates on fixed deposits");
        System.out.println("Interest Plans\n" +
                           "10% p.a interest on 1 year no-withdrawl deposit\n" +
                           "20% p.a interest on 5 year no-withdrawl deposit\n" +
                           "5% p.a interest on normal podit deposit\n");
        System.out.println("Do you want to deposit some cash?" + 
                           "Press Y to continue N to Cancle");
        String ui = s.next();
        switch(ui) {
            case "Y":
                dc(); break;
            case "N":
                System.out.println("Thank you for using our service ! Have a great day"); break;
            default:
                System.out.println("Wrong Input"); break;
            }
    }
    public static void dc() {
        System.out.println("Do you want to check the interest rates before depositing cash");
        String dui = s.next();
        switch(dui) {
            case "Y":
                dc(); break;
            case "N":
                System.out.println("So, Lets continue  with the Cash Deposit"); break;
            default:
                System.out.println("Wrong Input");break;
        }
        System.out.println("Enter the amount you want to deposit");
        int amt  = s.nextInt();
        System.out.println("Which type of deposit you want?\n" + 
                            "Press 1 to do 1 year no-withdrawl deposit\n" + 
                            "Press 2 to do 5 year no-withdrawl deposit\n" + 
                            "Press 3 to normal deposit");
        int it = s.nextInt();
        switch(it) {
            case 1 :
                interest = (amt*1*10/100);
                System.out.println("Your ineterest on Amount : $" + amt + " is $" + interest);break;
            case 2 :
                interest = (amt*5*20/100);
                System.out.println("Your ineterest on Amount : $" + amt + " is $" + interest);break;
            case 3 :
                double interest = (amt*1*5/100);
                System.out.println("Your ineterest on Amount : $" + amt + " for 1 year is $" + interest);break;
            default :
                System.out.println("Wrong Input"); break;
        }
        System.out.println("Do you want to deposit some cash?" + 
                           "Press Y to continue N to Cancle");
        String ui = s.next();
        switch(ui) {
            case "Y":
                choose(); break;
            case "N":
                System.out.println("Thank you for using our service ! Have a great day"); break;
            default:
                System.out.println("Wrong Input"); break;
        }
    }
    public static void clp() {
        System.out.println("We Provide Different interest rates at different Loans");
        System.out.println("1 | 2% per month on home loan\n" + 
                           "2 | 5% per month on Personal Loan\n" + 
                           "3 | 10% per month on Car Loan");
        System.out.println("If you want to apply for loan press Y To Calcle press N");
        String ti = s.next();
        switch(ti) {
            case "Y" :
                aplyfl(); break;
            case "N" :
                System.out.println("Thank you for using our service ! Have a great day"); break;
            default :
                System.out.println("Wrong Input ! try Again"); break;
        }
    }
    public static void aplyfl() {
        System.out.println("Do you want to check loan policies before applying for loan? " +
                            "Press Y to continue N to Cancle");
        String si = s.next();
        switch(si) {
            case "Y":
                clp(); break;
            case "N":
                System.out.println("Enter Loan amount"); break;
            default :
                System.out.println("Wrong Input"); break;
            } 
            double la = s.nextDouble();
        System.out.println("Which type of loan you want to take?");
        System.out.println("Press 1 for home loan\n" + 
                            "Press 2 for Personal Loan\n" + 
                            "Press 3 for Car Loan");
        int tl = s.nextInt();
        System.out.println("Enter total payment time period ! Enter time period in months" +
                            "(Like for 3 months type 3)");
        double tp = s.nextDouble();
        int lr = 0;
        switch(tl) {
            case 1 :
                lr = 2; break;
            case 2 :
                lr = 5; break;
            case 3 :
                lr = 10; break;
            default:
                System.out.println("Wrong Input"); break;
        }
        double pmpr = la/tp;
        double pmp = ((pmpr*lr*1/12)/100)+pmpr;
        System.out.println("Your per month payable amount is Rs." + pmp);
        System.out.println("Do you wish to continue? Press Y to continue N to Cancle");
        String io = s.next(); 
        switch(io) {
            case "Y":
                choose(); break;
            case "N":
                System.out.println("Thank you for using our service! Have a great day"); break;
            default:
                System.out.println("Wrong Input"); break;
        }
    }
}