import java.util.*;

public class ATM{
    public static void main(String[] args) 
    {
        ATMoperation obj = new ATMoperation();
    }
}
class Data
{
    float balance;
}

 class ATMoperation
  {
    HashMap<Integer , Data >  map  = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ATMoperation()
    {
            System.out.println("Welcome to our ATM");
            op();
    }

     public void op()
     {
         System.out.println("Enter valid pin");

         int pin = sc.nextInt();

         if(map.containsKey(pin))
         {
             Data obj = map.get(pin);
             menu(obj);
         }
         else
         {
             System.out.println("Please create account  ");
             System.out.println("set pin code");

             int pincode = sc.nextInt();

             Data obj = new Data();
             if(Integer.toString(pincode).length() < 5 && 2<Integer.toString(pincode).length() ){
                 obj.balance = 0;
                 map.put(pincode, obj);
                 menu(obj);
             }
             else{
                 System.out.println("Invalid pin");
             }
         }
     }


    public void menu(Data obj)
    {
        System.out.println("Enter your choice");
        System.out.println("1 . check balance");
        System.out.println("2 . withdraw money");
        System.out.println("3 . deposit money");
        System.out.println("4 . exit");
        int x = sc.nextInt();

        if(x == 1)
        {
            check_balance(obj);
        }
        else if(x == 2)
        {
            withdraw_money(obj);
        }
        else if(x == 3)
        {
            deposit_money(obj);
        }
        else if(x == 4)
        {
            System.out.println("Thank you for using our ATM");
        }
        else
        {

            System.out.println("Enter valid option");
            menu(obj);
     
        }

    }

    public void check_balance(Data obj)
    {
        System.out.println("Your current balance " + obj.balance);
        menu(obj);
    }

    public void deposit_money(Data obj)
    {

        System.out.println("Enter the amount ");
        float amount = sc.nextFloat();
        obj.balance = obj.balance + amount;
        System.out.println("Amount deposited successfully ");
        menu(obj);

    }

    public void withdraw_money(Data obj)
    {

        System.out.println("Enter the amount ");
        float amount= sc.nextFloat();
       if(amount > obj.balance) {
        System.out.println("ïnsufficient balance"); 
        menu(obj);
        }
       else{

        obj.balance = obj.balance - amount;
        System.out.println("Amount withdraw successfully ");
        menu(obj);
       }

    }


}
