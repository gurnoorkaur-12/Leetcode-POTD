
class MajorityElement{
    //NAIVE => BRUTE FORCE APPROACH
    // public static int majorityElement(int[] nums){
    //     for(int i=0;i<nums.length;i++){
    //         int count = 1;
    //         for(int j=i+1;j<nums.length;j++){
                
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //             if(count > nums.length/2){
    //                 return nums[i];
    //             }
    //         }
    //     }
    //     return -1;
    // }
    //BETTER=>HASHING
    // public static int majorityElement(int[] nums){
    //     HashMap<Integer,Integer> freq = new HashMap<>();
    //     for(int i=0 ; i < nums.length ; i++){
    //         freq.put(nums[i],freq.getOrDefault(nums[i], 0)+1);
    //         if(freq.get(nums[i]) > nums.length/2){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    //BEST = >Moore's VOTING Algorithm
    public static int majorityElement(int[] nums){
        int freq=0;
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(freq==0){
                ans=nums[i];
            }
            if(nums[i] == ans){
                freq++;
            }else{
                freq--;
            }
        }
        //Verify if element is majority Element
        int count = 0;
        for(int i = 0  ; i <nums.length ; i++){
            if(ans == nums[i]){
                count++;
            }
        }
        if(!(count > nums.length/2)){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        /* 169. Majority Element
            Given an array nums of size n, return the majority element.
            The majority element is the element that appears more than ⌊n / 2⌋ times.
(if majority element may not exist  => VERIFICATION)You may assume that the majority element always exists in the array.

            Example 1:
            Input: nums = [3,2,3]
            Output: 3 */

            int[] nums = {3,1,3,3,3,9,2,3,0,2,3,3,3,5,3,6};
    //NAIVE=>   //Brute force approach //T.C= O(n^2) //S.C= O(1);
    //BETTER=>  //OPTMISED approach   //T.C = O(n)  //S.C = O(n);
    //BEST=>   //Optimised approach // T.C = O(n) // S.C = O(1);
            System.out.println("Majority Element is "+majorityElement(nums));

    }
}