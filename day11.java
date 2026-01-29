import java.util.*;
class day11{
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int lp = 0;
        int rp = k-1;
        int minDiff = Math.abs(nums[lp] - nums[rp]);
        while( rp < nums.length ){
            int diff = Math.abs(nums[lp++]-nums[rp++]);                          
            if(diff < minDiff){
                minDiff  = diff;
            }
        }
        return minDiff;
    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List <List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for(int i = 1 ; i < arr.length-1 ; i++){
            minDiff = Math.min(minDiff , arr[i+1] - arr[i]);
        }
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i+1] - arr[i] == minDiff){
                List<Integer> ans = new ArrayList<>(); 
                ans.add(arr[i]);
                ans.add(arr[i+1]);
                list.add(ans);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //Leetcode 1984
        //Time Complexity = O(nlogn) => O(nlogn) for sorting and O(n) for array traversal
        //Space Complexity = O(1) 
        System.out.println(minimumDifference(new int[]{9,4,1,7},2));
        //leetcode-1200 T.C = O(nlogn) => nlogn for sorting and n for loop
        // S.C = O(n) for list storage 
        List<List<Integer>> list  = minimumAbsDifference(new int[] {1,3,6,10,15});
        for(List<Integer> l :list){
            System.out.print("[");
            for(int num : l){
                System.out.print(num + "\t");
            }
            System.out.print("]");
            System.out.println();

        }

    }
}