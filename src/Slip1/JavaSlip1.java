package Slip1;
import java.util.Scanner;
class Employee {
   int id;
   String name;
   int day, month, year;

   Employee(int id, String name, int dd, int mm, int yy) {
       this.id = id;
       this.name = name;
       this.day = dd;
       this.month = mm;
       this.year = yy;
   }

   int getId() {
       return id;
   }

   String getName() {
       return this.name;
   }

   String getDate() {
       return day + "/" + month + "/" + year;
   }

   void displayEmpInfo() {
       System.out.println("-------Employee Information----");
       System.out.println("Emp Id:" + getId());
       System.out.println("Emp Name:" + getName());
       System.out.println("Date of joining:" + getDate());
   }
}

class Manager extends Employee {
   double salary;
    Manager(int id, String name, int day, int month, int year, double sal) {
       super(id, name, day, month, year);
       this.salary = sal;
   }
 double getSalary() {
       return salary;
   }

   void displayEmpInfo() {
       super.displayEmpInfo();
       System.out.println("Employee Salary:" + getSalary());
   }
}

class SaleManager extends Manager{
   int commision;
   SaleManager(int id,String name,int day,int month,int year,double salray,int commision){
       super(id, name, day, month, year, salray);
       this.commision=commision;
   }
   int getCommision(){
       return commision;
   }
   void  displayEmpInfo(){
       super.displayEmpInfo();
       System.out.println("Employee Commision:"+getCommision());
   }
}




public class JavaSlip1 {
	   public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.println("hwllo world");
	       int id, day, month, year;
	       String name;
	       System.out.println("Enter Employee Id:");
	       id = sc.nextInt();
	       sc.nextLine();
	       System.out.println("Enter Employee Name:");
	       name = sc.nextLine();

	       System.out.println("Enter Employee birth Day:");
	       day = sc.nextInt();

	       System.out.println("Enter Employee birth  Month:");
	       month = sc.nextInt();
	       System.out.println("Enter Employee birth year:");
	       year = sc.nextInt();
	       System.out.println("Enter Employee Salary:");
	       double sal = sc.nextInt();
	       System.out.println("Enter Employee commision:");
	       int com = sc.nextInt();
	       
	       
	       SaleManager e1 = new SaleManager(id, name, day, month, year, sal,com);
	       e1.displayEmpInfo();
	   }

}
