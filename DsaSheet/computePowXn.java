
class computePowXn{
        //BRUTE FORCE APPROACH
    // public static double computePowXn(double x,int n){
    //     double ans =1 ;
    //     for(int i =0 ; i < Math.abs(n) ; i++){
    //         if(n>0){
    //             ans *= x; 
    //         }else{
    //             ans *= 1/x;
    //         }       
    //     }
    //     return ans;
    // }
        //OPTIMISED APPROACH
    public static double computePow(double x, int n){
        double ans;
        if(n == 0){
            return 1;
        }
        double halfPower = computePow(x, n/2);
        ans = halfPower * halfPower;
        if(n%2 !=0 ){
            ans *= x ;
        }
        return ans;
    }
    public static double computePowXn(double x, int n) {
        if(n<0){
            x = 1/x;
        }
        n =Math.abs(n);
        return computePow(x,n);
    }

    public static void main(String[] args) {
    // 50. Pow(x, n)
    // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
        // Example 1:
        // Input: x = 2.00000, n = 10
        // Output: 1024.00000

            //Brute Force approach T.C = O(n);S.c = O(1);
            //OPTMISED APPROACH T.C =O(LOGN);S.C = O(logn);
            System.out.println(computePowXn(-2,-2147483648));

    }
}