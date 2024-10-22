// We are using DFS algo here, can be done with BFS also but DFS will do it faster slightly , see striver start of vid if requried
// Doing via adjMatrix
// TC: O N*M
// SC: O N*M
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialcolor=image[sr][sc]; // storing the inital color
        int [][]ans=image;
        int delrow[]={-1,0,+1,0}; // storing the indexes to traverse in four directions, watch the dry run 10 sec if doubt
        int delcol[]={0,+1,0,-1}; // storing the indexes to traverse in four directions, watch the dry run 10 sec if doubt
        dfs(sr,sc,ans,image,color,delrow,delcol,initialcolor);  // dfs
        return ans;
    }

    // our normal dfs with input as adjMatrix
    public void dfs(int row, int col , int [][]ans, int [][]image,int color, int delrow[],int delcol[], int initialcolor){
        ans[row][col]=color; // coloring the new color
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){   // traversing in 4 directions
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m // bound check
            && image[nrow][ncol]==initialcolor  // cell with the initial color
            && ans[nrow][ncol]!=color){ // this is the visited condition 
                dfs(nrow, ncol, ans, image, color, delrow, delcol, initialcolor);

            }
        }
    }
}