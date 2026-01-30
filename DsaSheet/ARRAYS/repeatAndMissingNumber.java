class repeatAndMissingNumber{
    //Brute Force approach
    // public static int[] findMissingAndRepeatedValues(int[][] grid){
    //     int n = grid.length;
    //     boolean[] arr = new boolean[(n*n)+1];
    //     int[] ans = new int[2];

    //     for(int i = 0; i < grid.length ; i++){
    //         for(int j = 0; j < grid.length ; j++){
    //             if(arr[grid[i][j]]){
    //                 ans[0] = grid[i][j];
    //             }
    //             arr[grid[i][j]] = true;   
    //         }
    //     }

    //     for(int  i = 1 ;i < arr.length;i++){
    //         if(!arr[i]){
    //             ans[1]= i;
    //         }
    //     }
    //     return ans;
    // }
    
    // public static int[] findMissingAndRepeatedValues(int[][] grid){
    //     HashMap<Integer,Integer> freq = new HashMap<>();
    //     int repeated = -1;
    //     int missing = -1;
    //     for (int[] rowVector : grid) {
    //         for (int j = 0; j<grid.length; j++) {
    //             freq.put(rowVector[j],freq.getOrDefault(rowVector[j],0)+1);
    //         }
    //     }
    //     for(int i=1;i<=Math.pow(grid.length, 2);i++){
    //         if(!freq.containsKey(i)){
    //             missing =  i;
    //         }else if(freq.get(i) == 2){
    //             repeated= i;
    //         }
    //     }
    //     return new int[] {repeated,missing};
    // }
    
    //optimised approach
    public static int[] findMissingAndRepeatedValues(int[][] grid){
        long n = grid.length;
        long n2 = n*n;
        long actualSum = n2 * ( n2 + 1 )/2;//sum of n2 elements which were supposed to be there
        long actualSqSum = n2 * (n2 + 1) * (2*n2 + 1) / 6;//sum of square of numbers from 1 to n^2

        //calculate sum and sqSum of grid given
        long sum = 0;
        long sqSum = 0;
        for(int  i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                sum+=grid[i][j];
                sqSum+=Math.pow(grid[i][j],2);
            }
        }
        // sum - repeated +missing = actualSum 
        // sqSum - (repeated)^2 +(missing)^2 = actualSqSum
        long sumDiff = actualSum - sum; // m-r
        long sqSumDiff = actualSqSum - sqSum; // m^2 - r^2

        // sqSumDiff/sumDiff = missing +repeated
        int missing = (int)((sqSumDiff/sumDiff) + sumDiff)/2;
        int repeated = (int)(missing - sumDiff);
        return new int[] {repeated,missing};
    }

    public static void main(String[] args) {
        // 2965. Find Missing and Repeated Values
        // You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
        // Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.
            // Example 1:
            // Input: grid = [[1,3],[2,2]]
            // Output: [2,4]  // Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
        
        //BRUTE FORCE APPROACH T.C = O(n^2) //S.C = O(n^2)
        int[] ans = new int[2];
        ans = findMissingAndRepeatedValues(new int[][] {{9,1,7},{8,9,2},{3,4,6}});
        System.out.println(ans[0]+" "+ans[1]);
        //OPTIMISED APPROACH T.C = O(n^2) S.C = O(1);=>Mathematical approach
        // repeated = r ; missing = m;
// sum of array =(sum of elements from 1 to n^2) = sum of elements - repeated + missing; --> (n^2) *(n^2+1) /2 - r + m ; 
// sum of square of elements => sum - r^2 + m^2 --> (n^2)(n^2+1)(2n^2 + 1)/6 - r^2 +m^2;




    }
}