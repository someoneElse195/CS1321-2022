import java.text.DecimalFormat;
import java.util.Scanner;

public class Project_2 {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            DecimalFormat df = new DecimalFormat("#.##");

            //string miles = input.next();
            
            //Beginning of output and gathering of input.
            System.out.println("Welcome to Imperial to Metric Conversion Calculator");
            System.out.println("Please enter the temperature in degree Fahrenheit: ");

            double fTemp = input.nextDouble();
            //Convert F to C
            double tempC = (fTemp - 32)*5/9;
            //Print result along with truncating.
            System.out.println("The temperature in degree Celsius is " + df.format(tempC) + " C");

            //Liquid Volume:
            System.out.println("Please enter the volume of liquid in fluid ounces:");

            double ounces = input.nextDouble();
            //Convert to L
            double litres = ((ounces)*29.5735)/1000;
            //Print result along with truncating.
            System.out.println("The volume of the liquid in Liters is " + df.format(litres) + " L");
   
            //Weight:
            System.out.println("Please enter the weight of an object in pounds:");

            double lbs = input.nextDouble();
            //Convert to Kg.
            double kg = (lbs * 454)/1000;
            //Print and Truncate.
            System.out.println("The weight of an object in kilograms is " + df.format(kg) + "Kg");

            //Distance:
            System.out.println("Please enter the distance to a city in miles:");

            double miles = input.nextDouble();
            //Convert to Km.
            double km = (miles * 1.609);
            //Print and Truncate.
            System.out.println("The distance to a city in kilometers is " + df.format(km) + " Km");
        }
    }

}