import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = true;

        do {
            clearScreen();

            System.out.println(CYAN + "\t\t\t\tHello! Dear in program, Check strong password or not!" + RESET);
            System.out.println(YELLOW + "\t\t\t\t1- Password Checker" + RESET);
            System.out.println(YELLOW + "\t\t\t\t2- Generate Strong Password" + RESET);
            System.out.println(YELLOW + "\t\t\t\t3- Exit" + RESET);
            System.out.print(CYAN + "\t\t\t\tChoose option: " + RESET);

            int choice = readInt(in);

            switch(choice) {

                case 1:
                    System.out.print(CYAN + "\t\t\t\tEnter Password to check: " + RESET);
                    String password = in.next();
                    cheker(password);

                    if (!askAgain(in)) {
                        exit = false;
                    }
                    break;

                case 2:
                    System.out.print(CYAN + "\t\t\t\tEnter size of password (minimum 8): " + RESET);
                    int size = readInt(in);

                    while (size < 8) {
                        System.out.print(RED + "\t\t\t\tSize must be at least 8. Enter again: " + RESET);
                        size = readInt(in);
                    }

                    Generator(size);

                    if (!askAgain(in)) {
                        exit = false;
                    }
                    break;

                case 3:
                    System.out.println(GREEN + "\t\t\t\tGoodbye! See you later!" + RESET);
                    exit = false;
                    break;

                default:
                    System.out.println(RED + "\t\t\t\tInvalid option! Try again." + RESET);
            }

        } while (exit);
    }

   
    public static int readInt(Scanner in) {
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(RED + "\t\t\t\tInvalid input! Enter a number: " + RESET);
                in.nextLine();
            }
        }
    }

    public static boolean askAgain(Scanner in) {
        System.out.print(YELLOW + "\t\t\t\tDo another process? 1-Yes  2-No: " + RESET);

        while (true) {
            int yn = readInt(in);
            if (yn == 1) return true;
            else if (yn == 2) {
                System.out.print(YELLOW+"\t\t\t\tThank You for useing our System "+RESET);
                return false;
            }
            System.out.print(RED + "\t\t\t\tPlease choose 1 or 2 only: " + RESET);
        }
    }


    public static void Generator(int SizeOfPassword) {
        clearScreen();
        System.out.println(GREEN + "\t\t\t\tGenerating strong password..." + RESET);

        String[] passab = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s"};
        String[] passAB = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"};
        String[] pass12 = {"1","2","3","4","5","6","7","8","9","0"};
        String[] passSimbol = {"!","@","#","$","%","^","&","*","(",")","-","_","=","+","{","}","[","]",":",";","'","<",">",",",".","?","/"};

        String password = "";

        while (password.length() < SizeOfPassword) {
            password += passab[(int)(Math.random() * passab.length)];
            if (password.length() >= SizeOfPassword) break;

            password += passAB[(int)(Math.random() * passAB.length)];
            if (password.length() >= SizeOfPassword) break;

            password += pass12[(int)(Math.random() * pass12.length)];
            if (password.length() >= SizeOfPassword) break;

            password += passSimbol[(int)(Math.random() * passSimbol.length)];
        }

        System.out.println(CYAN + "\t\t\t\t Your strong password-:> " + GREEN + password + RESET);
    }

    public static void cheker(String password) {

        clearScreen();

        String[] passab = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] passAB = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] pass12 = {"1","2","3","4","5","6","7","8","9","0"};
        String[] passSimbol = {"!","@","#","$","%","^","&","*","(",")","-","_","=","+","{","}","[","]",":",";","'","<",">",",",".","?","/"};

        if(password.length() < 8) {
            System.out.println(RED + "\t\t\t\tPassword is weak! Must be >= 8 chars-:>" + RESET);
            return;
        }

        double up = 0, lo = 0, di = 0, sy = 0;

        for(char c : password.toCharArray()) {

            for(String s : passab) if(c == s.charAt(0) && lo < 2.5) lo += 1.25;
            for(String s : passAB) if(c == s.charAt(0) && up < 2.5) up += 1.25;
            for(String s : pass12) if(c == s.charAt(0) && di < 2.5) di += 1.25;
            for(String s : passSimbol) if(c == s.charAt(0) && sy < 2.5) sy += 1.25;
        }

        double score = up + lo + di + sy;

        System.out.println(CYAN + "\t\t\t\tScore of your password => " + GREEN + score + RESET);
    }
}
