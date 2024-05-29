//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<int[]> q=new LinkedList<>();
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vis=new boolean[r][c];
        int fresh=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
                else if(grid[i][j]==1)
                fresh++;
            }
        }
        
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        int min=0;
        
        while(!q.isEmpty() && fresh>0){
            int sz=q.size();
            min++;
            while(sz-->0){
                int[] idx=q.remove();
                int x=idx[0];
                int y=idx[1];
                for(int[] dir:dirs){
                    int i=x+dir[0];
                    int j=y+dir[1];
                    if(i>=0 && j>=0 && i<r && j<c && !vis[i][j] && grid[i][j]==1){
                        q.add(new int[]{i,j});
                        vis[i][j]=true;
                        fresh--;
                    }
                }
            }
        }
        return fresh==0?min:-1;
    }
}