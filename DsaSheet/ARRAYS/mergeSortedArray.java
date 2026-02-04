
class mergeSortedArray{
    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int pt1 = 0;
    //     int pt2 = 0;  
    //     int pt3 = 0;
    //     int temp[]= new int[n+m]; 

    //     while(pt1 < m && pt2 < n ){
    //         if(nums1[pt1] <= nums2[pt2]){
    //             temp[pt3++] = nums1[pt1++]; 
    //         }else{
    //             temp[pt3++] = nums2[pt2++];
    //         }
    //     }   
    //     while(pt1 < m){
    //         temp[pt3++] = nums1[pt1++];
    //     }
    //     while(pt2 < n){
    //         temp[pt3++] = nums2[pt2++];
    //     }
    //     for(int i=0 ; i < nums1.length ; i++){
    //         nums1[i] = temp[i];
    //     }
    //     for(int i :nums1){
    //         System.out.print(i+"\t");
    //     }
    // }
    // public static void merge(int[] nums1, int m, int[] nums2, int n){
    //     //merge both O(n+m)
    //     for(int  i = 0 ; i < nums2.length ;i++){
    //         nums1[i + m] = nums2[i];
    //     }
    //     //sort the nums1
    //     Arrays.sort(nums1);
    // }
    //Best approach
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int pt1 = nums1.length-1;
        int pt2 = nums2.length-1;
        int pt3 = m-1;
        while(pt3 >= 0 && pt2>=0){
            if(nums2[pt2] > nums1[pt3]){
                nums1[pt1--] = nums2[pt2--];
            }else{
                nums1[pt1--] = nums1[pt3--];
            }
        }
        while(pt2>=0){
            nums1[pt1--] = nums2[pt2--];
        }
    }
    public static void main(String[] args) {
        // Best approach//T.C = O(n+m) //S.C=O(n+m)
        // Better approch T.C = O(log(n+m)*(n+m)) S.C =O(1)=>merge than sort
        //Best  approach // T.C = O(n+m); S.C = O(1);
        int[] nums1 = {1,1,2,3,4,6,7,7,8,8,0,0,0,0,0};
        merge(nums1, 10, new int[] {0,2,2,6,8}, 5);
        for(int ele :nums1){
            System.out.print(ele+"\t");
        }
        System.out.println("");
    }
}