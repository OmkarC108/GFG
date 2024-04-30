//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends

                                                                  
//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int min=Arrays.stream(A).max().getAsInt();
        int max=Arrays.stream(A).sum();
        int result=0;
        if(M>N){
            return -1;
        }
        while(min<=max){
            int mid=(min+max)/2;
            if(isfeasible(A,M,mid)){
                result=mid;
                max=mid-1;
            }
            else
            min=mid+1;
        }
        return result;
    }
    public static boolean isfeasible(int[]A,int M,int mid){
        int student=1;
        int sum=0;
        
        for(int i=0;i<A.length;i++){
            if(sum+A[i]>mid){
                student++;
                sum=A[i];
            }
            else 
            sum+=A[i];
        }
        return student<=M;
    }
};