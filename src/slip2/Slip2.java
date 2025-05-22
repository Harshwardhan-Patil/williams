package slip2;
import java.util.Scanner;
class Emp {
    String empName;
    int empId;
    String category;
    double basicPay, HRA, DA, netPay, pf, grossPay, incomeTax, allowance;
     Emp(int id,String name,String category,double basicpay){
        empId=id;
        empName=name;
        this.category=category;
        basicPay=basicpay;
     }
    double calHra() {
        if (category.equals("manager")) {
            HRA = 30.0 / 100 * basicPay;
        } else if (category.equals("engineer")) {
            HRA = 20.0 / 100 * basicPay;

        } else if (category.equals("staff")) {
            HRA = 10.0 / 100 * basicPay;
        }
        return HRA;
    }

    double calDa() {
        if (category.equals("manager")) {
            DA = 80.0 / 100 * basicPay;
        } else if (category.equals("engineer")) {
            DA = 60.0 / 100 * basicPay;

        } else if (category.equals("staff")) {
            DA = 50.0 / 100 * basicPay;
        }
        return DA;
    }

    double calAllowance() {
        if (category.equals("manager")) {
            allowance = 4000;
        } else if (category.equals("engineer")) {
            allowance = 3000;

        } else if (category.equals("staff")) {
            allowance = 2000;
        }
        return allowance;
    }

    double calPf() {
        pf = 12.0 / 100 * basicPay;
        return pf;
    }

    double calGrossPay() {

        grossPay = basicPay+ calHra() + calDa() + calAllowance();
        return grossPay;
    }

    double calTax() {
        double income = calGrossPay();
        if (income < 500000) {
            incomeTax = 0;
        } else if (income >= 500000 && income < 1000000) { 
            incomeTax = 10.0 / 100 * income;
        } else if (income >= 1000000) {  
            incomeTax = 20.0 / 100 * income;
        }
        
        
        return incomeTax;
    }

    double calNetPay() {
        netPay = calGrossPay() - (calPf() + calTax());
        return netPay;
    }

    void display() {
        System.out.println("Basic Pay: " +(int) basicPay);
        System.out.println("HRA: " +(int) calHra());
        System.out.println("DA: " + (int)calDa());
        System.out.println("allowance: " + (int)calAllowance());
        System.out.println("gross Pay: " + (int)calGrossPay());
        System.out.println("provident fund: " + (int)calPf());
        System.out.println("income tax: " + (int)calTax());
        System.out.println("net Pay: " +(int) calNetPay());

    }
}


public class Slip2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int id;
        double basicpay;
        String name,category;
        System.out.println("Enter Emp Id");
        id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Emp name");
        name=sc.nextLine();
        System.out.println("Enter Employee category (manager/engineer/staff):");
        category=sc.nextLine();
        System.out.println("Enter Emp basic pay");
        basicpay=sc.nextDouble();

        Emp e1=new Emp(id, name, category, basicpay);
        e1.display();

        sc.close();
    }

}
