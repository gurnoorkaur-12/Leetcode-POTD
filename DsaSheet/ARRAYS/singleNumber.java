

class singleNumber{
    // Brute force approach
    // public int singleNumber(int[] nums){
    //     for (int i = 0; i < nums.length; i++) {
    //         int count = 0;
    //         for(int j = 0; j < nums.length; j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count == 1){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }  
    //Better approach
    // public int singleNumber(int[] nums){
    //    HashMap<Integer,Integer> freq = new HashMap<>();
    //     for(int i = 0; i < nums.length ; i++){
    //         freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
    //     }
    //     for(int i = 0 ;i < nums.length ; i++){
    //         if(freq.get(nums[i])==1){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }  
    //Best approach
    public int singleNumber(int[] nums){
        int ans = 0;
       for(int i = 0 ; i < nums.length ; i++){
        ans ^= nums[i];
       }
       return ans;
    }  

    public static void main(String[] args) {
        //Brute force approach T.C = O(n^2) S.C = O(1)=>Nested loops
        //Better approach T.C = O(n) S.C = O(n)=>hashmap
        //Best approach T.C = O(n) S.C = O(1);=>bitwise operator
        singleNumber Number = new singleNumber();
        System.out.println("Single Number = "+Number.singleNumber(new int[]{3,3,4,5,9,4,9}));
    }
}