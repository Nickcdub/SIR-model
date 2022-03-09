import java.util.Locale;
import java.util.Scanner;

public class SIRTest {

    public static void main(String[] args) {
        Scanner pre = new Scanner(System.in);
        System.out.println("Would you like to load the preset to Washington State?");
        String preset = pre.nextLine();
        if(preset.equalsIgnoreCase("YES")){
            SIR Washington = new SIR(7_766_925,1.28,14, 5_460_000,20_895);
            System.out.println(Washington.getInfo(200));
        }else {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the population size of your area:");
            int population = scan.nextInt();

            System.out.println("Please enter the effective transmission rate of your virus within your area:");
            double transRate = scan.nextDouble();

            System.out.println("Please enter the amount of days it takes to recover from your virus:");
            double recovery = scan.nextDouble();

            System.out.println("Please enter the number of vaccinated people within your area:");
            int vaccinated = scan.nextInt();

            System.out.println("Please enter the amount of people infected with the virus within your area:");
            int Infected = scan.nextInt();

            System.out.println("Finally, please enter the amount of days in the future you would like to project:");
            int days = scan.nextInt();

            SIR sir = new SIR(population, transRate, recovery, vaccinated, Infected);
            System.out.println(sir.getInfo(200));
        }
        System.out.println("S = Susceptibles, I = Infected, R = Recovered + Vaccination immunity (95%)");
    }
}
