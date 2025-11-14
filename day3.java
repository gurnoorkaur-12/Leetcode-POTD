import java.util.*;
class day3{
    //brute force T.C = O(n^2) S.C = o(n)
//     public static int lengthOfLongestSubstring(String s) {
//     HashSet <Character> subStr = new HashSet<>();
//     int pt = 0;
//     int maxLength = 0;
//     int i = pt;
//     while(pt<s.length() && i<s.length()){
//         if(subStr.contains(s.charAt(i))){
//             maxLength = Math.max(maxLength,subStr.size()) ;
//             subStr.clear();
//             pt++;
//             i=pt;
//         }else{
//             subStr.add(s.charAt(i));
//             i++;
//         }
//         maxLength  = Math.max(maxLength,subStr.size());
//     }
//     return maxLength;
// }
    //T.C=O(n) ;S.c = O(n) 
    public static int lengthOfLongestSubstring(String s){
        int windowSt = 0;
        int pt = 0;
        int maxLength = 0;
        HashSet <Character> subStr = new HashSet<>();
        while(pt <s.length()){
            if(!subStr.contains(s.charAt(pt))){
                subStr.add(s.charAt(pt));
                maxLength = Math.max(maxLength, subStr.size());
                pt++;
            }else{
                subStr.remove(s.charAt(windowSt));
                windowSt++;
            }
        }
        return maxLength;
    }
    //using hashmap T.C = O(n) S.C = o(n)
    public static List<Integer> majorityElement(int[] nums) {
        List <Integer> majEle = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }    
            if(map.get(nums[i]) > nums.length/3 && !majEle.contains(nums[i])){
                majEle.add(nums[i]);
            }
        }
         return majEle;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        int nums[] = {2,2,3,3};
        System.out.println(majorityElement(nums));
    }
}