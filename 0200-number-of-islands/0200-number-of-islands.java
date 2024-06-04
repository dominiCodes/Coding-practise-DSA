class Pair{ // Pair class
    int first;  // row
    int second; // col
    public Pair(int first, int second){
        this.first= first; // 
        this.second= second;
    }
}

// can use any algo, we have used BFS
// we have done using adjMatrix only

// TC: O N^2 (traversing alll node) + O N^2 * 4 (in BFS) ~ TC:--> O N^2
// SC: O N^2
class Solution {
    public int numIslands(char[][] grid) {
    int row= grid.length;
    int col= grid[0].length;
    int visited[][]= new int[row][col];
    int ans=0;
    for(int i=0; i< row; i++){  // here we are going one by one on each cell of grid and checking the firt unvisited of island to pass it in BFS
        for(int j=0; j< col; j++){
            if(grid[i][j] == '1' && visited[i][j]==0){
                ans++;
                bfs(i,j, visited, grid); // BFS traversal
            }
        }
    }   
    return ans;
    }

    // basic BFS with adjMatrix, so here we are storing  the row , col in Pairs
    public void bfs(int row,int col,int[][] vis,char[][] grid){
        vis[row][col] = 1; // marking true

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n = grid.length,m = grid[0].length;

        while(!q.isEmpty()){
            int r = q.peek().first;  // taking first ele which is row
            int c = q.peek().second; // taking second ele which is col
            q.poll();
            //(Imp: note here used the traditional 4 ways by using single for loop of 4)
            for(int drow=-1; drow<=1; drow++){ // passing it in the neghbouring nodes (note: striver has done 8 ways in video but according to this ques we have to do 4 ways only)
                for(int dcol=-1; dcol<=1; dcol++){
                    int nrow = r + drow; // taking the neighbour row one by one
                    int ncol = c + dcol; // taking the neighbour col one by one

                    if((Math.abs(drow-dcol) == 1) // this line is not there in strive bcz there we are going 8 ways and in this ques we have to go 4 ways only
                     && (nrow >= 0 && nrow < n) // out of bound check
                     && (ncol >= 0 && ncol < m) // out of bound check
                     && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}