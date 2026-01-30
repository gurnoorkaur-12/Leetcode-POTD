import java.util.*;
class twoSum{
    // public static int[] twoSum(int[] nums, int target){
    //     //Brute force T.C = O(n^2) S.C = O(1)
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]+nums[j] == target){
    //                 return new int[] {i,j};
    //             }
    //         }
    //     }
    //     return new int[] {};
    // }
    public static int[] twoSum(int[] nums,int target){
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                if(ans[0]!=ans[1]){
                    return ans;
                }
            }
            map.put(nums[i],i);
        }    
        return ans; 
    }

    public static void main(String[] args) {
    //TWO SUM => 
    // BRUTE FORCE => T.C = O(n^2) S.C= O(1);
    // Best T.C = O(n) S.C = O(n)
        System.out.println(twoSum(new int[] {3,44,6,7,8,3,2,5,7},50)[0]+" "+twoSum(new int[] {3,44,6,7,8,3,2,5,7},50)[1]);   
    }
}