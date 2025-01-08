
9,9,9,-0,-1,-3,-
public class ComplexNumber
{
   public static void printComplex(Complex a)
  {
    if(a.real==0,a.img!=0)
    { System.out.println(a.img+'i'); }
    else if(a.img==0,a.real!=0)
    {System.out.println(a.real)}
    else if(a.img!=0,a.real!=0)
    {System.out.println(a.real+"+"+a.img+'i');}

  }
    public static void  main(String args[])
    {
        Complex a=new Complex(5,10);
        Complex b=new Complex(10,20);
        printComplex(a.add(a,b));
    }

}
// class Complex 
// {
//     int img,real;
//     Complex(img,real)
//     {
//         this.img=img;
//         this.real=real;
//     }
//    public static Complex add(Complex a,Complex b)
//     { return new Complex((a.real+b.real),(a.img+b.img)); }

//   public static Complex product(Complex a,Complex b)
//    { return new Complex((a.real*b.real)-(a.img*b.img),((a.real*b.real)+(a.img*b.img))); }

//   public static Complex diff(Complex a, Complex b)
//   {return new Complex((a.real-b.real),(a.img-b.img)); }
// }