class day12{
    public static int minimumCost(int[] nums) {
        int minVal1 = Integer.MAX_VALUE;
        int minVal2 = Integer.MAX_VALUE;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < minVal1){
                minVal2 = minVal1;
                minVal1 = nums[i];
            }else if(nums[i] < minVal2){
                minVal2 = nums[i];
            }
        }
        return (minVal1 + minVal2 + nums[0]);
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int st = 0 ; 
        int end = letters.length-1;
        char ans = letters[0];
        while( st <= end ){
            int mid = st + (end-st)/2;
            if(letters[mid] > target){
                ans = letters[mid];
                end = mid-1;
            }else{
                st = mid + 1;
            }
        }
        return ans;
    } 
    //  public static boolean isTrionic(int[] nums) {
    //     int n = nums.length;
    //     int p = 0;
    //     int q = 0;
    //     int last = 0;
    //     int i = 1;
    //     while (i < n  && nums[i] > nums[i-1]){
    //         p = i;
    //         i++;
    //     }
    //     while(i < n && nums[i] < nums[i-1]){
    //         q = i;
    //         i++;
    //     }
    //     while(i < n && nums[i] > nums[i-1]){
    //         last = i;
    //         i++;
    //     }  
    //     return (p!=0 && q!=0 && last == n-1);
    // }
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<4 || nums[0] >= nums[1]){
            return false;
        }
        int count = 1;
        for(int i = 2 ; i < n ; i++){
            if(nums[i] == nums[i-1]){
                return false;
            }
            if((nums[i-2] - nums[i-1]) * (nums[i-1]-nums[i]) < 0){
                count++;
            }
        }
        return (count == 3);
    }

    public static void main(String args[]){
        // 3010. Divide an Array Into Subarrays With Minimum Cost I
            //T.C = O(n) S.C = O(1)
        System.out.println(minimumCost(new int[] {13,5,7,8,2,2,0}));
        // 744. Find Smallest Letter Greater Than Target
            //T.C = O(logn) S.C = O(1)
        System.out.println(nextGreatestLetter(new char[] {'a','b','c','d','q','w'},'u'));
        /**
         * Leetcode 3637 =>Trionic Array
         * Approach1 => Check validity of boundaries
         *  T.C = O(n) S.C = O(1)
         * Approach2 => Counting the Number of Turning Points
         */
        System.out.println(isTrionic(new int[] {3,4,3,7,4,7}));
        
    }
}