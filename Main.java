import java.util.Scanner;

public class Main 
  {    
public static void main(String[] args)
{
  
       Scanner in=new Scanner(System.in);
       boolean exit=true;
  
 do
 {
      System.out.print("\n\n\n\n");
      System.out.print("\t\t\t\t\t Hello! Dear in program, Chek strong password or not!\n");
      System.out.print("\t\t\t\t\t 1- Password Cheker\n"); 
      System.out.print("\t\t\t\t\t 2- Generate strong password\n");
      System.out.print("\t\t\t\t\t 3- Exit\n");
      System.out.print("\t\t\t\t\t Choose option: ");
         int choise=in.nextInt();
         if(choise==3)
            {
              System.out.print("\t\t\t\t\t Goodbye! See you later!\n");
                  exit=false;
         }



  switch(choise)
  {
      case 1:
            System.out.print("\t\t\t\t\t Enter Password to check:\n\t\t\t\t\t ");
            String password =in.next();
            cheker(password);
            break;
      case 2:
            System.out.print("\t\t\t\t\t Enter size of password (minimum 8 characters): ");
            int size=in.nextInt();
            if(size<8)
            {
              System.out.print("\t\t\t\t\t Size must be at least 8 characters. Generating password of size 8.\n");
              size=8;
            }

      Generator(size);
      break;
      default:
      System.out.print("\t\t\t\t\t Invalid option. Please try again.\n");

   }



   }while (exit);
      
      
}



public static void Generator(int SizeOfPassword)
{
System.out.println("\t\t\t\t\t Cheking password strength...");
String [] passab={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s"};
String [] passAB={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"};
String [] pass12={"1","2","3","4","5","6","7","8","9","0"};
String [] passSimbol={"!","@","#","$","%","^","&","*","(",")","-","_","=","+","{","}","[","]",":",";","'","<",">",",",".","?","/"};
String password="";
for(int i=0;i<SizeOfPassword;i++)
{
password+=passab[(int)(Math.random()*passab.length)];
password+=passAB[(int)(Math.random()*passAB.length)];
password+=pass12[(int)(Math.random()*pass12.length)];
password+=passSimbol[(int)(Math.random()*passSimbol.length)];
if(password.length()>=SizeOfPassword)
   
{
break;

}
}
 System.out.print("\t\t\t\t\t Your strong password: "+password+"\n");

 


}

public static void cheker(String password) 
{ 
    String[] passab={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s"}; 
    String[] passAB={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"}; 
    String[] pass12={"1","2","3","4","5","6","7","8","9","0"}; 
    String[] passSimbol={"!","@","#","$","%","^","&","*","(",")","-","_","=","+","{","}","[","]",":",";","'","<",">",",",".","?","/"}; 

    if(password.length() < 8) {
        System.out.println("Password is weak! It must be at least 8 characters long.");
        return;
    }

    float counter = 0.0f;

    for(int i = 0; i < password.length(); i++) {

        char c = password.charAt(i);

        
        for(int j = 0; j < passab.length; j++) {
            if(c == passab[j].charAt(0)) counter+=0.5;
        }

        
        for(int j = 0; j < passAB.length; j++) {
            if(c == passAB[j].charAt(0)) counter+=0.5;
        }

        
        for(int j = 0; j < pass12.length; j++) {
            if(c == pass12[j].charAt(0)) counter+=0.5;
        }

        
        for(int j = 0; j < passSimbol.length; j++) {
            if(c == passSimbol[j].charAt(0)) counter+=0.5;
        }
        if(counter >= 10) break;
    }

    System.out.println("\t\t\t\t\t Password is strong! score = " + counter);
}



}


