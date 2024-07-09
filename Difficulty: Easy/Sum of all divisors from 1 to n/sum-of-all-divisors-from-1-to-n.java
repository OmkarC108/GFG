//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int N){
        // code here
       /* if(N==1) return 1;
        
        long totalSum = 0;
        for (int i = 1; i <= N; i++) {
            totalSum += sumOfDivisorsN(i);
        }
        return totalSum;*/
        long totalSum = 0;
        
        // Iterate over each possible divisor
        for (int i = 1; i <= N; i++) {
            // For each divisor i, add it to the total sum (N / i) times
            totalSum += i * (N / i);
        }
        
        return totalSum;
    }
    /*
    static long sumOfDivisorsN(int n) {
        
        long sumDivisors = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sumDivisors += i;
                if (i != n / i) {
                    sumDivisors += n / i;
                }
            }
        }
        return sumDivisors;
    }*/
}