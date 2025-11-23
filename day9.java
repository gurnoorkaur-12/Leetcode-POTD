import java.util.*;
class day9{
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(map.get(s1.charAt(i)),0)+1);
        }   
        for(int i=0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i))==0){
                  map.remove(s2.charAt(i));
                }
            } 
        } 
        if(map.isEmpty()){
            return true;
        }
        return false;
    }
    public static int removeDuplicates(int[] nums) {
        int lp=1;
        int rp =1;
        int currEle = nums[0];
        while(rp<nums.length){
            if(!(currEle == nums[rp])){
                nums[lp] = nums[rp];
                currEle = nums[lp];
                lp++;
            }
            rp++;
        }
        return lp;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidaoo"));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}