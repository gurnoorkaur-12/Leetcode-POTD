class singleNumberSortedArray{
    //Brute force Approach
    // public static int singleNumber(int[] nums){
    //     for(int i = 0 ; i < nums.length ; i++){
    //         if(!(nums[i] == nums[i + 1] || nums[i] == nums[i-1])){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    //Optimised approach
    public static int leftRight(int[] nums,int mid){
        int n =nums.length;
        // 0 => left ; 1=>Right ; 2=>mid
        if(mid == 0 && nums[0] != nums[1]) return 2;
        else if(mid == n-1 && nums[n-1] != nums[n-2]) return 2;

        if(nums[mid] == nums[mid-1] ) {
            if((mid % 2 == 0)){
                //go left (0)
                return 0;
            }else{
                //go right (1)
                return 1;
            }
        }else if(nums[mid] == nums[mid+1]){
            // end = mid-1;
            if((mid % 2 == 0)){
                //go right (1)
                return 1 ;
            }else{
                //go left (0)
                return 0;
            }
        }else{
            return 2;
        }
    }
    public static int singleNumber(int[]nums){
        int n = nums.length;
        if(n == 1) return nums[0] ;

        int st = 0 , end = n -1 ;
        while(st <= end){
            int mid = st + (end-st) / 2;

            int i = leftRight(nums, mid);
            if (i == 0){
                //left 
                end = mid - 1;
            }else if(i == 1){
                //right
                st = mid + 1;
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Leetcode-540 => Single element in sorted array
        //brute force => T.C = O(n) S.C = O(1) // Linear Search or XOR operator
        //Optmised approach => T.C =(logn) S.C= O(1) //Binary Search
        System.out.println(singleNumber(new int[] {1,1,2}));
    }
}