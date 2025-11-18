class day6{
    public static boolean kLengthApart(int[] nums, int k) {
        int lp = -1;
        int rp = 0;
        while(lp == -1 && rp<nums.length){
            if(nums[rp]==1){
                lp=rp;
            }
            rp++;
        }
        while(rp<nums.length){
            if(nums[rp]==1){
               if( rp-(lp+1) >= k){
                lp = rp;
               }else{
                return false;
               }
            }
            rp++;
        }
        return true;
    }
    public static boolean isOneBitCharacter(int[] bits) {
        boolean oneBit = false;
        int pt=0;
        while(pt<bits.length){
            if(bits[pt] ==0 ){
                oneBit = true;
            }else{
                if(bits[pt+1] == 0){
                    oneBit = false;
                    pt++;
                }else{
                    pt++;
                }
            }
            pt++;
        }
        return oneBit;
    }
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,0,1,1}, 1));
        System.out.println(isOneBitCharacter(new int[] {1,1,0}));
    }
}