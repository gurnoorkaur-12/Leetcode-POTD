class stockBuySell{
    //BRUTE FORCE APPROACH
    // public static int maxProfit(int[] prices){
    //     int profit = 0;
    //     for(int i = 0 ; i < prices.length ; i++){
    //         for(int j = i+1 ; j< prices.length ;j++){
    //             profit = Math.max(prices[j] - prices[i], profit);
    //         }
    //     }
    //     return profit;
    // }
    //BEST FORCE APPROACH
    public static int maxProfit(int[] prices) {
        int buyDay = 0;
        int profit = 0;
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] - prices[buyDay] > 0){
               profit = Math.max(profit,prices[i] - prices[buyDay]);
            }else{
                buyDay = i;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        // T.C = O(n^2) S.C = O(1)//Naive approach = >nested loops 
        // T.C = O(n) S.C =O(1)//Best approach => single pass approach
        System.out.println("Maxprofit is = "+maxProfit(new int[] {2,3,5,4,6,1,3,0,9,0}));
    }
}