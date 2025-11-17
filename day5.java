import java.util.*;
class day5{
    // using hashmap t.c =O(n) ;s.c = o(n)
    // public static int mostFrequent(int[] nums, int key) {
    //     int maxFreq=0;
    //     int target = 0;
    //     HashMap<Integer,Integer> freq = new HashMap<>();
    //     for(int i=0;i<nums.length-1;i++){
    //         if(nums[i]==key){
    //             if(freq.containsKey(nums[i+1])){
    //              freq.put(nums[i+1],freq.get(nums[i+1])+1);   
    //             }else{
    //                 freq.put(nums[i+1],1);
    //             }
    //         maxFreq = Math.max(maxFreq,freq.get(nums[i+1]));
    //         if(maxFreq == freq.get(nums[i+1])){
    //             target = nums[i+1];
    //         }
    //         }

    //     }
    //     return target;
    // }
    // using array t.c = o(n) ;s.c = o(n)
    public static int mostFrequent(int[] nums, int key) {
        int maxFreq=0;
        int target = 0;
        int[] targetFreq = new int[1001];//index=>target//elements=>freq
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                targetFreq[nums[i+1]]++;
            }
        }
        for(int i=0;i<targetFreq.length;i++){
            maxFreq = Math.max(maxFreq,targetFreq[i]);
            if(maxFreq==targetFreq[i]){
                target = i;
            }
        }
        return target;
    }
    public static  List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(freq.containsKey(nums[i])){
                freq.put(nums[i],freq.get(nums[i])+1);
            }else{
                freq.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            boolean adjacent = false;
            if(freq.containsKey(nums[i]+1)||freq.containsKey(nums[i]-1)){
                adjacent = true;
            }
            if(!adjacent){
                if(freq.get(nums[i])==1){
                    //lonely
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={2,2,2,2,3};
        int  key = 2;
        System.out.println(mostFrequent(nums, key));
        System.out.println(findLonely(new int[]{1,3,5,3}));

    }
}