package slip3;

class MarksOutOfBound extends Exception{
    MarksOutOfBound(String msg){
     super(msg);
    }
    
 }
 public class Slip3  {
 
     int rollNo;
     int marks;
 
     void setRollNo(int no){
         rollNo=no;
     }
     int getRollNo(){
         return rollNo;
     }
     void setMarks(int mark)throws MarksOutOfBound {
         
             if(mark<0 || mark>100)  {
                 throw new MarksOutOfBound("marks out of bound mark should be between 0 to 100");
             }else{
                 marks=mark;
             }
 
     }
     int getMarks(){
     return marks;
     }
     public static void main(String[] args) {
        Slip3 obj=new Slip3();
         obj.setRollNo(5);
 
         try {
             obj.setMarks(104);
             System.out.println(" Roll No is :"+obj.getRollNo());
             System.out.println("the marks are :"+obj.getMarks());

         } catch (MarksOutOfBound e) {
             System.out.println(e.getMessage());
         }
         
         try {
             obj.setMarks(50);
             System.out.println(" Roll No is :"+obj.getRollNo());
             System.out.println("the marks are :"+obj.getMarks());

         } catch (MarksOutOfBound e) {
             System.out.println(e.getMessage());
         }

 
     }
 }
 

