import java.util.*;
class day8{
    // // t.c = O(N^2) S.c = o(1)
    // public int findFinalValue(int[] nums, int original) {
    //     int pt=0;
    //     while(pt<nums.length){
    //         if(nums[pt]==original){
    //             original *=2;
    //             pt=0;
    //         }else{
    //             pt++;
    //         }
    //     }
    //     return original;
    // }
    // t.c = o(n) s.c = o(n)
    public static int findFinalValue(int[] nums, int original) {
        HashSet <Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(set.contains(original)){
            original*=2;
        }
        return original;
    }
     public static int countPalindromicSubsequence(String s) {
        int answer = 0;
        //find all unique characters
        HashSet <Character> uniqueChar = new HashSet<>();
        for(int i=0;i<s.length();i++){
            uniqueChar.add(s.charAt(i));
        }
        //find first and last occurence of each unique characters
        for(char c : uniqueChar){
            int firstOcc = -1;
            int lastOcc = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==c){
                    if(firstOcc==-1){
                        firstOcc = i;
                    }
                    lastOcc = i;
                }
            }
            //find no of unique characters between first and last occurrence
            HashSet<Character> betweenChar = new HashSet<>();
            for(int k=firstOcc+1;k<lastOcc;k++){
                betweenChar.add(s.charAt(k));
            }
            answer+=betweenChar.size();
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[] {2,3,4,2,1,0,8} ,2));
        System.out.println(countPalindromicSubsequence("aabca"));
    }
}