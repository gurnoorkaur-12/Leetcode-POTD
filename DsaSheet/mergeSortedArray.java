class mergeSortedArray{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = 0;
        int pt2 = 0;  
        int pt3 = 0;
        int temp[]= new int[n+m]; 

        while(pt1 < m && pt2 < n ){
            if(nums1[pt1] <= nums2[pt2]){
                temp[pt3++] = nums1[pt1++]; 
            }else{
                temp[pt3++] = nums2[pt2++];
            }
        }   
        while(pt1 < m){
            temp[pt3++] = nums1[pt1++];
        }
        while(pt2 < n){
            temp[pt3++] = nums2[pt2++];
        }
        for(int i=0 ; i < nums1.length ; i++){
            nums1[i] = temp[i];
        }
        for(int i :nums1){
            System.out.print(i+"\t");
        }
    }
    public static void main(String[] args) {
        //T.C = O(n+m) //S.C=O(n+m)
        merge(new int[] {1,1,2,3,4,6,7,7,8,8,0,0,0,0,0}, 10, new int[] {0,2,2,6,8}, 5);
    }
}