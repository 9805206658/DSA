import java.util.*;
public class OOP2
{
 public static void main(String args[])
 {
    Scanner sc= new Scanner(System.in);
    // Horse mustang=new Horse();
    // mustang.walk();
    // Bird crow= new Bird();
    // System.out.println(crow.color);
    // crow.changeColor("blue");
    // System.out.println(crow.color);
    // King k=new King();
    // Rook r=new Rook();
    // k.moves();
    // r.moves();
    // Human siya=new Human();
    // siya.eatGrass();
    // siya.eatAnimal();
    // Student s1=new Student();
    // s1.collegeName="cite";
    // s1.name="bikal";
    // s1.displayName();
    // System.out.println(s1.collegeName);
    // Student s2=new Student();
    // System.out.println(s2.collegeName);
    Dogs d1=new Dogs();
    int a, b, c, d;
    System.out.println("Enter the real and imaginary part of first number");
    a=sc.nextInt();
    b=sc.nextInt();
    System.out.println("Enter the real and imaginary part of Second number");
    c=sc.nextInt();
    d=sc.nextInt();
    Complex c1=new Complex(a,b,c,d);
    c1.sum();
    c1.difference();
    c1.product();

}
}


// interface Herbivorse
// {
// void eatGrass();
// }
// interface  Carnivorse
// {
// void eatAnimal();
// }
// class Human implements Herbivorse ,Carnivorse
// {
//    public  void eatGrass()
//     {
//         System.out.println("I am eating grass");
//     }
//     public void eatAnimal()
//     {

//         System.out.println("i am eating the another animal");
//     }
// }
// abstract class Animal{
//     String color="Red";
//     // Animal()
//     // {
//     //     System.out.println("animal class are processing");
//     // }
//     void eat()
//     {
//         System.out.println("i am eating the food");
//     }
//     abstract void walk();
//     abstract void changeColor(String color);
// }
// class Horse extends Animal
// { 
//     Horse()
//     {
//         System.out.println("i am calling the horse contructor");
//     }
//     void walk()
//     {
//         System.out.println("i am walking with the four legs");
//     }
//     void changeColor(String color)
//     {
//         this.color=color;
//     }
// }
// class Bird extends Animal{
//     Bird ()
//     {System.out.println("i am calling the bird constructor");}
//     void dance()
//     { System.out.println("i am dancing"); }
//     void walk()
//     { System.out.println("i am walkig with two legs");}
//     void changeColor(String color)
//     { this.color=color;}
// }

// // here implementing 
// interface ChessPlayer
// {
//     void moves();
// }
// class King implements ChessPlayer 
// {
//    public void moves()
//     { System.out.println("left ,right, top,bottom  after 4 moves");}
// }
// class Rook implements ChessPlayer
// {
//    public void moves() { System.out.println("vertifcal left,right,bottom ,top");}
// }

// class Student 
// {
//     static String collegeName;
//     String name;
//     void displayName()
//     {
//         System.out.println(this.name);
//     }
// }

// // here practice of super keyword implementation
class Animal
{
    int legs;
    Animal()
    {
        System.out.println("i am animal class");
    }
    void setLeg()
    {
        System.out.println("i am called");
        legs=29;
       
    }
}


class Dogs extends Animal
{
    Dogs()
    {
        super();
        System.out.println("i am dogs class");

    }

}

// here peforming complex class problem
class Complex 
{
    int a, b,  c,  d;
    Complex( int a,  int b, int  c, int d)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    void sum()
    {
        System.out.println((a+c)+"+"+"i"+(b+d));
     }
    void difference()
    {
        System.out.println((a-c)+"+"+"i"+(b-d));

    }
    void product()
    {
          System.out.println((a*c-b*d)+"+"+"i"+(a*d+b*c));
    }



}