//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st=new Stack<>();
        
        for(char ch:S.toCharArray()){
            if(Character.isDigit(ch))
            st.push(ch-'0');
            else{
                int opr1=st.pop();
                int opr2=st.pop();
                switch(ch){
                case '+':st.push(opr2+opr1);
                break;
                case '-':st.push(opr2-opr1);
                break;
                case '*':st.push(opr2*opr1);
                break;
                case '/':st.push(opr2/opr1);
                break;
                }
            }
        }
        return st.pop();
    }
}