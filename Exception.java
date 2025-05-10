
import java.util.Scanner;

public class Exception
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
try {

System.out.println("Enter the first number (Num1): ");
String input1 = sc.nextLine();
System.out.println("Enter the second number (Num2): ");
String input2 = sc.nextLine();


int num1 = Integer.parseInt(input1);
int num2 = Integer.parseInt(input2);
int[] array = {10, 20, 30, 40, 50};

int result = num1 / num2;
System.out.println("Result of division: " + result);
System.out.println("Value at index " + num1 + ": " +array[num1]);
System.out.println("Value at index " + num2 + ": " + array[num2]);
} catch (ArrayIndexOutOfBoundsException e)

{
System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
}catch (NumberFormatException e)
{
System.out.println("NumberFormatException: Invalid number format.");
} catch (ArithmeticException e)
{
System.out.println("ArithmeticException: Cannot divide by zero.");
} finally
{
System.out.println("Program execution completed………..");
}
}
}
//save file as Exception.java
// compile commond   javac Exception.java
// run commond  java Exception


