

class maxWaterContainer{
    // public static int maxArea(int[] height){
    //     int area = 0;
    //     for(int i = 0 ; i < height.length ; i++){
    //         for(int j = i+1 ; j < height.length ; j++){
    //             int h = Math.min(height[j] , height[i]); 
    //             area = Math.max(area, h * ( j - i ));
    //         }
    //     }
    //     return area;
    // }
    public static int maxArea(int[] height){
        int lp = 0 ;
        int rp = height.length - 1;
        int area = 0;
        while(lp!=rp){
            if(height[lp]<height[rp]){
                area = Math.max(area , height[lp] * (rp-lp));
                lp++;
            }else{
                area = Math.max(area,height[rp] * (rp-lp));
                rp--;
            }
        }
        return area ;
    }
    public static void main(String[] args) {
        //brute force approach T.C =O(n^2) S.C = O(1)
        //best approach T.C = O(n) S.C = O(1) => two pointer approach

        System.out.println(maxArea(new int[] {1,8,6,2,3,4,8,3,7}));
    }
}