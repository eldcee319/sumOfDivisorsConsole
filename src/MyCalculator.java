import java.util.Scanner;

public class MyCalculator implements AdvancedArithmetic{

//This will sum all divisors in a number

/*
Pseudocode:
Step 1: Accept input of a number. Assign as integer variable.
        while true
        if input <= 1000, add all divisors in the number. while false
        else, ask input to try again or not. Assign as char variable.
            while input !=y && !=n print wrong input. then ask again to repeat until input is not either 'y' or 'n'
            if input == n, while false
 */
public static void main(String[] args) {
    MyCalculator cal = new MyCalculator();
    Scanner scanner = new Scanner(System.in);

    char tryagain='n';
    boolean again = true;

    try{
        do {
            System.out.println("Please input number up to 1000.");
            int n = scanner.nextInt();
            if (n <= 1000) {
                int divisor = cal.divisor_sum(n);
                System.out.println("Sum of divisors is: " + divisor);
                break;
            } else {
                System.out.println("Number is greater than 1000. Do you want to try again? [y|n]");
                tryagain = scanner.next().charAt(0);

                while((tryagain!='Y' && tryagain!='y') && (tryagain!='N' && tryagain!='n')) {
                    System.out.println("Invalid input. Do you want to try again? [y|n]");
                    tryagain = scanner.next().charAt(0);
                } // end of while loop

                if (tryagain == 'n' || tryagain == 'N') {
                    break;
                } // end of if

            } // end of if else
        } // end of do
        while (true);
    } catch (Exception e) {
        System.out.println("Wrong input");
    }
}

    @Override
    public int divisor_sum(int n) {

        if(n<=1000) {
            int sum = 0;
            for(int x = 1; x <= n; x++) {
                double div = (n % x) / 10d;
                int roundedDiv = (int) (Math.ceil(div));
                if(roundedDiv == 0) {
                    System.out.println("divisors: " + x);
                    sum += x;
                }
            } // end of for loop
            return sum;
        }

        return 0;
    }
}
