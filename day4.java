class day4 {
    public static boolean isPalindrome(String s) {
     String str2=s.toLowerCase();
        int start=0;int end=str2.length()-1;
        while(start<end){
            char st=str2.charAt(start);
            char ed=str2.charAt(end);
            if(!(('a'<=st && st<='z') || (st>='0' && st<='9'))){
                start++;
            }else if(!(('a'<=ed && ed<='z') || (ed>='0' && ed<='9'))){
                end--;
            }else if(st!=ed){
                return false;
            }else{
                start++;
                end--;
            }
        }    
        return true;   
    }
   
    //t.c = O(n) s.c = o(n);
    // public static int[] productExceptSelf(int[] nums) {
    //     int n =nums.length;
    //     int[] answer = new int [n] ;
    //     int[] prefix = new int[n];
    //     int[] suffix = new int [n];
    //     int product;
    //     prefix[0] =1;suffix[n-1]=1;
    //     for(int i=1;i<n;i++){
    //         prefix[i] = prefix[i-1]*nums[i-1];
    //         suffix[n-i-1] = suffix[n-i]*nums[n-i];
    //     }
    //     for(int i=0;i<n;i++){
    //         answer[i] = prefix[i]*suffix[i];
    //     }
    //     return answer;
    // }

    // T.C = O(N)S.C =O(1)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int answer[] = new int [n];
        answer[0] =1;
        for(int i=1;i<n;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        int product = 1;
        for(int i=n-2;i>=0;i--){
            product *= nums[i+1];
            answer[i] *= product;
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome("@#$%^^racecar   #$$@"));
        int[] arr = (productExceptSelf( new int[] {1,2,3,4}));
        for(int ele:arr){
            System.out.print(ele+"\t");
        }
    }
}