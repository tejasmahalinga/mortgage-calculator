import com.sun.source.util.SourcePositions;

import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //getting input data from users
        System.out.print("Principal : ");
        Scanner scanner=new Scanner(System.in);
        long principal=scanner.nextLong();
        System.out.print("Annual Interest rate : ");
        float annualInterestRate=scanner.nextFloat();
        System.out.print("Period (Years) : ");
        int period=scanner.nextInt();

        //mortgage calculated output
        float finalMortgage = mortgageCalculator(principal,annualInterestRate,period);

        NumberFormat formatter= NumberFormat.getCurrencyInstance();
        System.out.print("Mortgage : " + formatter.format(finalMortgage));
    }

    public static float mortgageCalculator(long principal, float annualInterestRate, int period){
        final int NUMBER_OF_MONTHS=12;
        final int PERCENTAGE=100;
        //sub calculations
        int numberOfPayments=period * NUMBER_OF_MONTHS;
        float monthlyInterestRate = (annualInterestRate/PERCENTAGE)/NUMBER_OF_MONTHS;
        float rate= (float) Math.pow((1 + monthlyInterestRate),numberOfPayments);

        //final formula
        float totalMortgage = (float) principal * ((monthlyInterestRate * rate)/(rate - 1));
        return totalMortgage;
    }

}