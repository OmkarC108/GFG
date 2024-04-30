//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
	    long[] result=new long[n];
	    
	    for(int i=0;i<n;i++){
            result[i]=multiplication(nums,i);
	     }
	    return result;
	} 
	public static long multiplication(int[] nums,int index){
	    long product=1;
	    
	    for(int i=0;i<index;i++){
	        product*=nums[i];
	    }
	    for(int i=index+1;i<nums.length;i++){
	        product*=nums[i];
	    }
	    return product;
	}
} 
