import java.util.Arrays;
import java.util.Scanner;

public class Combinatorics
{

    public static int factorial(double monomials2)
    {
        if(monomials2 == 0)
        {
            return 1;
        }

        return (int)(factorial(monomials2 - 1) * monomials2);
    }

    public static int choose(int n, int k)
    {
        return factorial(n)/(factorial(k) * factorial(n - k));
    }

    public static int totalNumberOfTerms(int n, int k)
    {
        return choose(n + k - 1, n);
    }

    public static int whatNumberofNumbersToAdd()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("What number of numbers would you like to add:");

        int choice = scan.nextInt();

        return choice;
    }

    public static int whatNumbersAddTo()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("What number would you like to add up to:");

        int choice = scan.nextInt();

        return choice;
    }

    public double[][] comb(int n, int k)
    {
      double[][] a = new double[totalNumberOfTerms(n, k)][k];
      
      int m = 0;
      
      if(k == 1)
        {
            a[0][0] = n;
            return a;
        }
        
        for(int i = 0; i < n; i++)
        {
            double[][] sub = comb(n - i, k - 1);

            int N = sub.length;

            for(int j = 0; j < N; j++)
            {
                a[m][0] = i;

                for(int l = 0; l < k - 1; l++)
                {
                    a[m][l + 1] = sub[j][l];
                }

                m++;
            }
        }

        a[m] = new double[k];

        a[m][0] = n;

        return a;
    }

    public static void printA(double[][] a)
    {
      for (int i = 0; i < a.length; i++) {  
      System.out.println(Arrays.toString(a[i]));
      }
    }
}
