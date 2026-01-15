class MajorityElement{
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
    public static int majorityElement(int[] nums){
        //Moore's Algorithm
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
        return ans;
    }
    public static void main(String[] args) {
        /* 169. Majority Element
            Given an array nums of size n, return the majority element.
            The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
            Example 1:
            Input: nums = [3,2,3]
            Output: 3 */

            int[] nums = {3,1,3,3,3,9,2,3,0,2,3,3,3,5,3,6};
           //Brute force approach //T.C= O(n^2) // S.c = O(1);
           //Optimised approach // T.C = O(n) // S.C = O(1);
            System.out.println("Majority Element is "+majorityElement(nums));

    }
}