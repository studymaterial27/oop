
import java.util.Scanner; 
public class complex 
{ 
public static void main(String args[]) 
{ 
int num1, num2, answer,ch=0; 
Complex_Op cal = new Complex_Op () ; 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter first Number :\n"); 
num1 = sc.nextInt(); 
num2 = sc.nextInt();  
Complex_Op Object1 = new Complex_Op(num1,num2); 
System.out.print("Enter Second Number :\n"); 
num1 = sc.nextInt(); 
num2 = sc.nextInt();  
Complex_Op Object2 = new Complex_Op(num1,num2); 
System.out.println ("Following Arithmetic Operations are perform on Complex Numbers"); 
System.out.println("1. Addition"); 
System.out.println("2. Substraction"); 
System.out.println("3. Multiplication"); 
System.out.println("4. Division"); 
System.out.println("Enter Your Choice : "); 
ch=sc.nextInt(); 
switch(ch) 
{ 
case 1: cal.Addition(Object1,Object2); 
break; 
case 2: cal.Substraction(Object1,Object2); 
break; 
case 3: cal.Multiplication(Object1,Object2); 
break; 
case 4: cal.Division(Object1,Object2); 
break; 
  } 
  } 
             
} 
class Complex_Op 
{ 
 float real,imag; 
Complex_Op()  
 { 
 real=0; 
  imag=0; 
 } 
 Complex_Op(float Comp1,float Comp2) 
{ 
    real=Comp1; 
    imag=Comp2; 
} 
void Addition(Complex_Op C1,Complex_Op C2) 
{ 
      float real,imag; 
      real = (C1.real + C2.real); 
      imag = (C1.imag + C2.imag); 
 System.out.println("Addition is:("+real+") + ("+imag+")i" ); 
} 
void Substraction(Complex_Op C1,Complex_Op C2) 
{ 
    float real,imag; 
    real = (C1.real -C2.real); 
    imag = (C1.imag - C2.imag); 
    System.out.println("Substraction is:("+real+") - ("+imag+")i"); 
} 
void Multiplication(Complex_Op C1,Complex_Op C2) 
{ 
   float real,imag; 
   real=(C1.real * C2.real - C1.imag * C2.imag); 
   imag=(C1.real * C2.imag+ C1.imag * C2.real); 
   System.out.println("Multiplication is:("+real+") *("+imag+")i"); 
} 
void Division(Complex_Op C1,Complex_Op C2) 
{ 
      float real,imag; 
      float a = C1.real; 
      float b = C1.imag; 
      float c= C2.real; 
      float d = C2.imag; 
      float denominator = c * c + d * d; 
      real = (a * c + b * d) / denominator; 
      imag= (b * c - a * d) / denominator; 
      System.out.println("Division is:("+real+") / ("+imag+")i" );  
      } 
 } 
//javac complex.java
//java complex