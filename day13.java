import java.util.*;
class day13{
    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i =0 ; i< n ; i ++){
            result[i] = nums[( (i + nums[i]) % n + n) % n];
        }
        return result;
    }
    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 0;
        int n = nums.length;
        int ans = n;
        for(int i = 0 ; i < n ; i++){
            while(j < n && nums[j] <= (long)nums[i] * k){
                j++;
            }
            ans = Math.min(ans , n- (j -i));
        }
        return ans;
    
    }
    public static int longestBalanced(int[] nums) {
        int maxLength = 0;
        int count = 0; 

        for (int i = 0 ; i < nums.length ; i++){
            count = 0;
            HashMap <Integer,Integer> map = new HashMap<>();

            for(int j = i ; j < nums.length ; j++){
                map.put(nums[j],map.getOrDefault(nums[j],0) + 1);
                if(nums[j] % 2 == 0 && map.get(nums[j]) == 1){
                    count++;
                }else if(nums[j] %2 !=0 && map.get(nums[j]) == 1){
                    count--;
                }
                if(count == 0){
                    maxLength = Math.max(j-i+1 , maxLength); 
                }
            }
        } 
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = constructTransformedArray(new int[] {0,-2,2,3,4,5,6,7,8,9});
        for ( int ele : arr ){
            System.out.print(ele+"\t");
        }System.out.println();
       //T.C =  O(nlogn) => sorting takes nlogn and loop takes o(n) time s.c = o(logn) or o(n) due to inbuilt sort
       System.out.println(minRemoval(new int[] {2,1,5},2));
       System.out.println(longestBalanced(new int[] {2,3,4,5}));
    }
}