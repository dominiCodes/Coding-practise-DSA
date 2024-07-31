class Solution {

    public List<List<Integer>> permute(int[] arr) {

        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> tempAns= new ArrayList<>();
        boolean[] check= new boolean[arr.length]; // taking this to check which index is picked
        return f(arr, tempAns, ans, check);
    }

    public List<List<Integer>> f(int[] arr, List<Integer> tempAns,List<List<Integer>> ans,  boolean[] check){

        if(tempAns.size() == arr.length){
            ans.add(new ArrayList<>(tempAns));
            return ans;
        }
        for(int i=0; i< arr.length; i++){ // traversing ech index one by one
            
            if(!check[i]){ // if not picked then picked
                tempAns.add(arr[i]); // add ele in tempAns
                check[i]= true; // updated the index as picked
                f(arr, tempAns, ans, check); // recc call
                tempAns.remove(tempAns.size()-1); // while returning remove the last ele so that it would not be picked next time for 
                check[i]= false;
            }      
        }
        return ans;
    }


// Reccursive tree
//                             []
//                     /         |        \
//              [1]          [2]        [3]
//              / \         /  \       /   \
//         [1,2] [1,3]  [2,1] [2,3]  [3,1] [3,2]
//        /   \      |       |        |       |
//     [1,2,3] [1,3,2]  [2,1,3]  [2,3,1] [3,1,2] [3,2,1]



// f(arr, [], [], [false, false, false])
// Choose 1: f(arr, [1], [], [true, false, false])
// Choose 2: f(arr, [1, 2], [], [true, true, false])
// Choose 3: f(arr, [1, 2, 3], [], [true, true, true]) → Add to ans
// Backtrack: f(arr, [1, 3], [], [true, false, true])
// Choose 2: f(arr, [1, 3, 2], [], [true, true, true]) → Add to ans
// Backtrack: f(arr, [2], [], [false, true, false])
// Choose 1: f(arr, [2, 1], [], [true, true, false])
// Choose 3: f(arr, [2, 1, 3], [], [true, true, true]) → Add to ans
// Backtrack: f(arr, [2, 3], [], [false, true, true])
// Choose 1: f(arr, [2, 3, 1], [], [true, true, true]) → Add to ans
// Backtrack: f(arr, [3], [], [false, false, true])
// Choose 1: f(arr, [3, 1], [], [true, false, true])
// Choose 2: f(arr, [3, 1, 2], [], [true, true, true]) → Add to ans
// Backtrack: f(arr, [3, 2], [], [false, true, true])
// Choose 1: f(arr, [3, 2, 1], [], [true, true, true]) → Add to ans


}