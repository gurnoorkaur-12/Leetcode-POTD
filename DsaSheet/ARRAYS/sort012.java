class sort012{
//   public static void sortColors(int[] nums) {
//     int countZero=0,countOne = 0, countTwo = 0;
//     for(int i = 0 ; i < nums.length ; i++){
//       if(nums[i] == 1 ){
//         countOne++;
//       }else if(nums[i] == 2){
//         countTwo++;
//       }else{
//         countZero++;
//       }
//     }
//     for(int i = 0 ; i < nums.length ; i++){
//       if(countZero > 0){
//         nums[i] = 0; 
//         countZero--;
//       }else if(countOne > 0){
//         nums[i] = 1;
//         countOne--;
//       }else{
//         nums[i] = 2;
//         countTwo--;
//       }
//     }
// }
  //Using Dutch National Flag algorithm
  public static void sortColors(int[] nums){
    int low = 0 , mid = 0 , high = nums.length -1 ;

    while (mid <= high) { 
      if(nums[mid] == 0){

        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
        low++;
        mid++;

      }else if(nums[mid] == 1){
        mid++;
      }else{

        int temp = nums[mid];
        nums[mid] = nums[high];
        nums[high] = temp;
        high--;
      }
    }
  }

    public static void main(String[] args) {
        // T.C = O(n) ;S.C = O(1)
        //Using Dutch National Flag algorithm
        int[] arr = {0,1,1,2,0,1,2};
        sortColors(arr);
        for(int ele : arr){
            System.out.println(ele);
        }
    }
}