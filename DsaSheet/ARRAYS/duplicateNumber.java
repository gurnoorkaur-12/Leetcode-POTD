class duplicateNumber{
    //Brute Force Approach 
    // public static int duplicateNumber(int[] nums){
    //     for(int i =0 ; i < nums.length ; i++){
    //         int count = 0 ;
    //         for(int j = 0 ; j < nums.length ; j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //             if(count > 1){
    //                 return nums[i];
    //             }
    //         }
    //     }
    //     return -1;
    // }

    //BETTER APPROACH
    // public static int duplicateNumber(int[] nums){
    //     HashMap <Integer,Integer> freq = new HashMap<>();
    //     for(int i =0 ; i < nums.length ; i++){
    //         freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
    //         if(freq.get(nums[i]) > 1){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    //Best Approach
    public static int duplicateNumber(int[] nums ){
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String args[]){
        //Brute force approach => T.c = O(n^2) S.C = O(1);
        //BETTER APPROACH => T.C = O(n) S.C = O(n);
        //BEST APPROACH => T.C = O(n) S.C = O(1); /// slow fast pointer approach
        System.out.println(duplicateNumber(new int[] {3,1,3,3,2}));
    }
}