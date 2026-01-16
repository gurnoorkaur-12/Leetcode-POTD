import java.util.*;
 class majorityElementII{
    //BRUTE FORCE APPROACH

    // public static List<Integer> majorityElement2(int[] nums){
    //     List <Integer> majEle = new ArrayList<>();
    //     for(int i=0;i<nums.length;i++){
    //         int count = 1;
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]==nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count > nums.length/3 && !majEle.contains(nums[i])){
    //             majEle.add(nums[i]);
    //         }
            
    //     }
    //     return majEle;
    // }

    //OPTIMISED APPROACH
    // public static List<Integer> majorityElement2(int[] nums){
    //     List <Integer> majEle = new ArrayList<>();
    //     HashMap <Integer,Integer> map = new HashMap<>();
    //     for (int i=0 ; i < nums.length; i++){

    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);

    //         if(map.get(nums[i]) > nums.length/3 && !majEle.contains(nums[i])){
    //             majEle.add(nums[i]);
    //         }
            
    //     }
    //     return majEle;
    // }
    //

    //More Optimised approach
    public static List<Integer> majorityElement2(int[] nums){
        List <Integer> majEle = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        // atmost there will be 2 majority elements
        for(int num:nums){
            if(num == num1){
                //if num is number1
                count1++;
            }else if(num == num2){
                // if num is number 2
                count2++;
            }else if (count1 == 0) {
                //if number1 is not set or is not a majorityElement;
                //update number1
                num1 = num;
                count1 = 1;
            }else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        //check if num1 and num2 are majorityElements 
        count1 =0;
        count2 = 0;
        for(int num:nums){
            if(num==num1){
                count1++;
            }else if(num==num2){
                count2++;
            }
        }
        if(count1 > nums.length/3){ majEle.add(num1); };
        if(count2 > nums.length/3){ majEle.add(num2); };
        return majEle;
    }
    public static void main(String[] args) {
        // 229. Majority Element II
        // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
        // Example 1:
        // Input: nums = [3,2,3]
        // Output: [3]

        //Brute force approach T.C= O(n^2) //S.C= O(1)
        //optimised
        List<Integer> list = majorityElement2(new int[] {1,1,13,3,2,13,1,13});

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();
    }
}