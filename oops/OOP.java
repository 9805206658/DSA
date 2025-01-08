public class OOP 
{
    public static void main(String args[])
    {

        Account a1=new Account(3030,50);
        a1.interest[0]=10;
        a1.interest[1]=3;
        a1.interest[2]=20;
         Animal a=new Animal();
        a.eat();
    //  Account a2=new Account(a1);
    // for(int i=0;i<a2.interest.length;i++)
    // {
    //       System.out.println(a2.interest[i]);
    // }
    // Bird crow=new Bird();
    // crow.eat();
    // crow.flying();


    
  
      
    //     Pen p1=new Pen();
    //     p1.setColor("Sarmila");
    //     System.out.println(p1.color);
    //     p1.setTip(10);
    //      Account a2=new Account(2020,10);
    //      System.out.println(a2.getAccount());
    //      System.out.println(a2.getBalance());
    //      Account a1=new Account(a2);
    //    System.out.println(a1.getAccount());
    //      System.out.println(a1.getBalance());
    //      a1.interest[0]=12;
    //      a1.interest[1]=15;
    //      a1.interest[2]=20;
    //    for(int i=0;i<a2.interest.length;i++)
    //    {
    //     System.out.println(a1.interest[i]);
    //    }


   }
}

// class Animal
// {
//     String color;
//     void breathe()
//     {
//         System.out.println("the breathing");
//     }
//     void eat()
//     {
//         System.out.println("the Eating");
//     }
// }
// class Fish extends Animal{
//     int fins;
//     void displayFins()
//     {
//         System.out.println("the fins is four");
//     }
// }

// class Pen
// {
//     int tip;
//     String color;
//     void setColor(String newColor)
//     {
//         color=newColor;
//     }
//     void setTip(int newTip)
//     {
//         tip=newTip;
//     }
// }


// class Account 
// {
//     private int accountNum;
//     private int balance;
//      public  int interest[];
//     // contructor overloading
//     Account ()
//     { 
//         interest=new int[3];
//         System.out.println("the constructor is calling");

//     }
   
//     Account(int accountNum,int balance)
//     {
//         interest=new int[3];
//         this.accountNum=accountNum;
//         this.balance =balance;
//     }

//     // deep copying
//     Account (Account a)
//     {
//         this.accountNum=a.accountNum;
//         this.balance=a.balance;
//         for(int i=0;i<a.interest.length;i++)
//         {
//             this.interest[i]=a.interest[i];
//         }
//     }


//     void setAccountNum(int accNum)
//     {
//         this.accountNum=accNum;
//     }

//     void setBalance (int balance)
//     {
//         this.balance=balance;
//     }
//     int getAccount()
//     {
//         return this.accountNum;

//     }
//     int getBalance()
//     {
//          return this.balance;
//     }
// }



// here defining multilevel inheritance class 

// class Animal
// {
// int legs;
// void displayLegs()
// {
//     System.out.println(legs);
// }
// void breathe()
// {
//     System.out.println("i am breathing");
// }

// }
// class Mamals extends Animal
// {
//   int hands;
//   void  walk()
//     {
//         System.out.println("i am walking");
//     }
// }
// class Dogs extends Mamals
// { void barking()
//     {System.out.println("Dogs is barkign now"); }
// }


// class Animal 
// {
//     void eat()
//     {
//         System.out.println("animals are egtings");
//     }
//     void breathe()
//     {
//         System.out.println("animals are breathings");
//     }
// }
// class Dogs extends Animal
// {
//     void barking ()
//     {
//       System.out.println("the dogs are barking now");
//     }
// }
// class Bird extends Animal
// {
//     void flying()
//     {
//         System.out.println("the birds are flying now");
//     }
// }

// practice fucntion overriding
class Animal 
{
    void eat()
    {  System.out.println("eat anything");}
}
class  Deer extends Animal
{
    void eat()
    {
        System.out.println("I am eating the grass");
    }
}