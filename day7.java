class day7{
    public static int numSub(String s) {
        long window = 0;
        long count = 0;
        int mod = 1000000007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count = count + (++window);
            }else{
                // count += (window)*(window+1)/2;
                window = 0;
            } 
        }
        // count += (window)*(window+1)/2;
        count = count % mod;
        return (int)count;

    }
    // public static int compress(char[] chars) {
    //     String s = "";
    //     int lp = 0;
    //     int rp = 1;
    //     while(rp<chars.length){
    //         if(chars[rp]!=chars[lp]){
    //             if(rp-lp == 1){
    //                 s= s+chars[lp];
    //                 System.out.println(s);
    //                 lp = rp;
    //             }else{
    //                 s = s + chars[lp]+(rp-lp);
    //                 System.out.println(s);
    //                 lp =rp;
    //             }
    //         }
    //         rp++;
    //     }
    //     if(rp-lp == 1){
    //         s= s+chars[lp];
    //         lp = rp;
    //     }else{
    //         s = s + chars[lp]+(rp-lp);
    //         lp =rp;
    //     }
    //     for(int i=0;i<s.length();i++){
    //         chars[i] = s.charAt(i);
    //     }
    //     System.out.println(s);
    //     return s.length();
    // }
    public static int compress(char[] chars) {
        if(chars.length==0){
            return 0;
        }
        char c= chars[0];
        int count = 0;
        int pt=-1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==c){
                count++;
            }else{
                chars[++pt] = c;
                if(count>1){
                   for(char num:Integer.toString(count).toCharArray()){
                    chars[++pt]=num;
                   } 
                }
                c=chars[i];
                count=1;
            }
        }
        chars[++pt] = c;
        if(count>1){
            for(char num:Integer.toString(count).toCharArray()){
            chars[++pt]=num;
            } 
        }
        return pt+1;
    }
    public static void main(String[] args) {
        String str = "111000101010111100000";
        System.out.println(numSub(str));
        System.out.println(compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println("abc"+12);
    }
}


