import java.util.HashMap;
public class day1{
    //moore's alogorithm
    public static int majorityElement(int arr[]){
        int freq=0;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(freq == 0){
                ans = arr[i];
            }
            if(ans == arr[i]){
                freq++;
            }else{
                freq--;
            }
        }
        //variation if no majority element exists
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == ans){
                count++;
            }
        }
        if(count >= arr.length/2){
            return ans;
        }else{
            return -1;
        }   
    }
    // 2965. Find Missing and Repeated Values
    // public static int[] findMissingAndRepeatedValues(int[][] grid) {
    //     HashSet <Integer> set = new HashSet<>();
    //     int[] ans = {};
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid.length;j++){
    //             if(set.contains(grid[i][j])){
    //                 ans[0] = grid[i][j];
    //             }else{
    //                 set.add(grid[i][j]);
    //             }
    //         }
    //     }
    //     for(int i=0;i<Math.pow(grid.length,2);i++){
    //         if(!set.contains(i)){
    //             ans[1]=i;
    //         }
    //     }
    //     return ans;
    // } 
    //using hashmap
    public static int[] findMissingAndRepeatedValues(int[][] grid){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int repeated = -1;
        int missing = -1;
        for (int[] grid1 : grid) {
            for (int j = 0; j<grid.length; j++) {
                if (!freq.containsKey(grid1[j])) {
                    freq.put(grid1[j], 1);
                } else {
                    repeated = grid1[j];
                }
            }
        }
        for(int i=1;i<=Math.pow(grid.length, 2);i++){
            if(!freq.containsKey(i)){
                missing= i;
            }
        }
        return new int[] {repeated,missing};
    }
    public static void main(String args[]){
        int arr2[] = {1,1,2,2,1,1,1};
        System.out.println(majorityElement(arr2));
        int[][] grid = {{1,2},{3,3}};
        int arr[] =findMissingAndRepeatedValues(grid); 
        System.out.println(arr[0]+" "+arr[1]);
    }
}