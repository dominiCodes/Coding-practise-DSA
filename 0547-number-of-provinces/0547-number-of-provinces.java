//Algo used: DFS
// TC: O N + O (nearly V + 2*E) (for DFS) ,  SC: O(N)+O(N)(recc stack) - (We are ignoring the adj list space here) 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected[0].length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i< n; i++){    // creating the input adjList for converting input from matrix to List
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){ // just converting the input adj matrix to our adjList
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited= new boolean[n]; // our input is starting from 1 , if it would have started with 0 then we would have done n+1
        int ans=0;
        for(int i=0; i<n; i++){ // for every node we are check visited, if not visited then it wil go in dfs and that component's all node will be mark as true
            if(!visited[i]){
                ans++;  // this will be call for no. of provinces time i.e our ans
                dfs(i,adj, visited);
            }
        }
        return ans;
    }


    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){    // DFS search
        visited[node]= true;
        for(int i: adj.get(node)){
            if(!visited[i]){
                dfs(i,adj,visited);
            }
        }
    }
}