import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter marks obtained in English out of 100: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter marks obtained in Mathematics out of 100: ");
        int m2 = scanner.nextInt();
        System.out.print("Enter marks obtained in Science out of 100: ");
        int m3 = scanner.nextInt();
        System.out.print("Enter marks obtained in Social out of 100: ");
        int m4 = scanner.nextInt();
        System.out.print("Enter marks obtained in Tamil out of 100: ");
        int m5 = scanner.nextInt();
        
        int totalmarks = m1+m2+m3+m4+m5;
        double average = totalmarks/5;
        double avrgpercentage = (totalmarks/500)*100;
        
        System.out.println("The average is "+average);
        System.out.println("The average percentage is "+avrgpercentage);
        
        if (avrgpercentage>= 90) {
            System.out.println("Grade obtained is O");
        } else if (avrgpercentage >=80) {
            System.out.println("The grade obtained is A+");
        } else if (avrgpercentage >= 70) {
            System.out.println("The grade is A");
        } else if (avrgpercentage >=60) {
            System.out.println("The grade is B+");
        } else if (avrgpercentage >=50) {
            System.out.println("The grade is B");
        } else if (avrgpercentage >= 40) {
            System.out.println("The grade is P");
        } else {
            System.out.println("You have failed the exam");
        }
        
        
    }
}

