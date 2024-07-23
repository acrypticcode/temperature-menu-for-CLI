/*
This program provides the user with a menu that lets them either convert Fahrenheit to
Celsius, convert Celsius to Fahrenheit, or end the program. Once a temperature is converted,
the menu is shown again until the user selects to end the program.
 */

import java.util.Scanner;

public class Project7_flanders {

    static Scanner kb = new Scanner(System.in);

    public static int farToCel(int far) {
        //converts a Fahrenheit temperature to Celsius
        return (far - 32) * 5/9;
    }
    public static int celToFar(int cel){
        //converts a Celsius temperature to Fahrenheit;
        return (cel * 9/5 + 32);
    }
    public static char displayMenu() {
        /*shows the user a menu and returns an uppercase version of
         the user's valid menu selection
        does not return until the user makes a valid selection*/
        char input;

        do {
            System.out.println("\nMenu");
            System.out.println("C: converts Celsius to Fahrenheit");
            System.out.println("F: converts Fahrenheit to Celsius");
            System.out.println("Q: quits program");
            System.out.print("\nPlease enter F, C, or Q ");
            input = Character.toUpperCase(kb.next().charAt(0));
            if (input == 'C' || input == 'F' || input == 'Q')
                return input;
            System.out.println("That is not a valid selection.");
        }
        while (true);
    }

    public static void main(String[] args){
        char selection;
        int temp;
        String request = "Enter the %s temperature ";
        String output = "%d degrees %s is %d degrees %s%n";

        /*gets a menu selection from the user
        if the user chose Q, ends the program
        if the user chose F or C, gets a temperature from the user and does a
          Fahrenheit-Celsius or Celsius-Fahrenheit conversion, which it outputs
        repeats until the user selects Q
         */
         do {
             selection = displayMenu();
             if (selection == 'Q')
                 break;
             if (selection == 'F') {
                 System.out.printf(request,"Fahrenheit");
                 temp = kb.nextInt();
                 System.out.printf(output, temp, "Fahrenheit", farToCel(temp), "Celsius");
             }
             else {
                 System.out.printf(request,"Celsius");
                 temp = kb.nextInt();
                 System.out.printf(output, temp, "Celsius", celToFar(temp), "Fahrenheit");
             }
         }
         while(true);
    }
}