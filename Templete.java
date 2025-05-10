import java.util.*;

public class GenericFunctionExample {
    static int count = 0;

    static void check_palindrome(String x) {
        StringBuilder s1 = new StringBuilder(x);
        if (x.equals(s1.reverse().toString())) {
            System.out.println(x + " is a Palindrome");
            count += 1;
        } else {
            System.out.println(x + " is not a Palindrome");
        }
    }

    static void even_odd(int x) {
        if (x % 2 == 0) {
            System.out.println(x + " is Even Number");
            count += 1;
        } else {
            System.out.println(x + " is Odd Number");
        }
    }

    static void prime(int x) {
        boolean flag = false;
        if (x <= 1) {
            flag = true; // 0 and 1 are not prime
        } else {
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println(x + " is a prime number.");
            count += 1;
        } else {
            System.out.println(x + " is not a prime number.");
        }
    }

    static void check(int ch, int x) {
        switch (ch) {
            case 1:
                even_odd(x);
                break;
            case 2:
                prime(x);
                break;
            default:
                System.out.println("ENTER CORRECT OPTION");
        }
    }

    static void number_op() {
        int element, n, choice;
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter the total number of elements:");
        n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            element = sc.nextInt();
            nums.add(element);
        }

        System.out.println("***You have following choices on Integer Numbers***");
        System.out.println("1. Check Number is ODD or EVEN");
        System.out.println("2. Check Number is PRIME OR NOT");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        count = 0;
        Iterator<Integer> itr = nums.iterator();
        while (itr.hasNext()) {
            check(choice, itr.next());
        }

        if (choice == 1) {
            System.out.println("The number of Even numbers is: " + count);
            System.out.println("The number of Odd numbers is: " + (nums.size() - count));
        } else if (choice == 2) {
            System.out.println("Number of Prime numbers is: " + count);
            System.out.println("Number of Non-Prime numbers is: " + (nums.size() - count));
        }
    }

    static void string_op() {
        int n;
        String word;
        ArrayList<String> words = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of elements:");
        n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            word = sc.next();
            words.add(word);
        }

        count = 0;
        for (String w : words) {
            check_palindrome(w);
        }

        System.out.println("The Number of Palindromes is: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****We have following data types to perform operations*****");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        if (ch == 1) {
            number_op();
        } else if (ch == 2) {
            string_op();
        } else {
            System.out.println("Enter valid choice");
        }
    }
}
//file save as=  GenericFunctionExample.java
// compile commond=  javac GenericFunctionExample.java
//run commond= GenericFunctionExample.java
