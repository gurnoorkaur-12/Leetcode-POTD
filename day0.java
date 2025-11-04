import java.util.*;
public class day0{
    public static boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        while(n % 3== 0 ){
            n/=3;
        }
        if(n==1){
            return true;
        }
        return false;
    }
    public static int[] getSneakyNumbers(int[] nums) {
        int ans[] = new int[2];
        int j=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                ans[j] = (nums[i]);
                j++;
            }else{
                set.add(nums[i]);
            }
        }
        return ans;
    }
   
    public static void main(String[] args) {
        // leet-326 power of three
        System.out.println(isPowerOfThree(243));
        //leet -3289 sneaky numbers fo digitville
        int arr[] = {7,1,5,4,3,4,6,0,9,5,8,2};
        int ans[] = getSneakyNumbers(arr);
        System.out.println(ans[0]+"\t"+ans[1]);


    }
}