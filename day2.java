class day2{
    public static int singleNumber(int[] nums){
        int ans = 0;
        for(int i=0;i<nums.length;i++){
           ans =  nums[i]^ans;
        }
        return ans;
    }
    public static void sortColors(int[] nums) {
        int fre1 = 0;
        int fre0 = 0;
        int fre2 = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==2){
                fre2++;
            }else if(nums[i]==0){
                fre0++;;
            }else{
                fre1++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<fre0){
                nums[i] = 0;
            }else if(i<(fre1+fre0)){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,4,3,1,9,4,9,3}));
        int nums[]={0,2,1,0,2,2,0,1,1,0};
        sortColors(nums);
        for(int ele:nums){
            System.out.print(ele);
        }
    }
}