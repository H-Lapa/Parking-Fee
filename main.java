import java.util.Scanner;
class Main {
  public static void main(String[] args) 
  {
    disabled();
    System.exit(0);
  }

  public static void disabled () 
  {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Are you disabled?");
    String disabled = scanner.nextLine();

    disabled = disabled.toLowerCase();

    if (disabled.equals("yes")) {
      System.out.println("Parking for you is free");
      return;
    } else if (disabled.equals("no")) {
      totalFee();
    } else {
      System.out.println("Your response was not understood!");
      System.out.println("Please try again!");
      System.out.println("");
      disabled();
    }
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

  public static boolean localDiscount () 
  {
    boolean localDiscount = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you have an ”I live locally badge”?");
    String response = scanner.nextLine();
    response = response.toLowerCase();

    if (response.equals("yes")) {
      localDiscount = true;
    } else if (response.equals("no")) {
      localDiscount = false;
    } else {
      System.out.println("Your response was not understood!");
      System.out.println("Please try again!");
      System.out.println("");
      localDiscount();
    }
    return localDiscount;
  }

  public static boolean oapDiscount () 
  {
    boolean oapDiscount = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Are you an OAP?");
    String response = scanner.nextLine();
    response = response.toLowerCase();

    if (response.equals("yes")) {
      oapDiscount = true;
    } else if (response.equals("no")) {
      oapDiscount = false;
    } else {
      System.out.println("Your response was not understood!");
      System.out.println("Please try again!");
      System.out.println("");
      oapDiscount();
    }
    return oapDiscount;
  }

  public static void totalFee () 
  {
    double fee = feeCalc();
    boolean localDiscount = localDiscount();
    boolean oapDiscount = oapDiscount();

    if (localDiscount == true) {
      fee = fee - 1;
    }

    if (oapDiscount == true)
    {
      fee = fee - 2;
    }

    System.out.println("The parking charge for you is " + fee + " pounds. ");
    return;
  }
}
