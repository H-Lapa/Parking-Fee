import java.util.Scanner;
class Main {

  public static void main(String[] args) 
  {
    parkingCharge();
    System.exit(0);
  }

  public static double feeCalc ()
  {
    double fee = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("How many hours do you wish to park (1-8)?");
    int hours = scanner.nextInt();

    if (hours == 1) {
      fee = 3;
      
    } else if (2 <= hours && hours <= 4) {
      fee = 4;

    } else if (5 <= hours && hours <= 6) {
      fee = 4.50;

    } else if (7 <= hours && hours <= 8) {
      fee = 5.50;

    } else {
      System.out.println("pick a smaller time!");
      System.out.println(" ");
      feeCalc();
    }

    return fee;
  }

  public static boolean question (String question) 
  {
    boolean r = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println(question);
    String response = scanner.nextLine();
    response = response.toLowerCase();

    if (response.equals("yes")) {
      r = true;
    } else if (response.equals("no")) {
      r = false;
    } else {
      System.out.println("Your response was not understood!");
      System.out.println("Please try again!");
      System.out.println("");
      question(question);
    }
    return r;
  }

  public static void parkingCharge () 
  {
    double fee = 0;
    boolean disabled = question("Are you Disabled?");
    if (disabled == true) {
      System.out.print("Parking for you is free");
    } else {
      fee = feeCalc();
      boolean localDiscount = question("Do you have an ”I live locally badge”?");
      if (localDiscount == true) {
        fee = fee - 1;
      }

      boolean oapDiscount = question("Are you an OAP?");

      if (oapDiscount == true){
      fee = fee - 2;
      }

    }
    

    System.out.println("The parking charge for you is " + fee + " pounds. ");
    return;
  }

}
