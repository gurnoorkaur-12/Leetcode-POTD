import java.util.*;
class day10{
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String str[] = s.split(" ");
        int pt=0;
        int uniqueChars=0;
        if(str.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!(map.get(pattern.charAt(i)).equals(str[i]))){
                    return false;
                }
            }else{
                map.put(pattern.charAt(i),str[i]);
                uniqueChars++;
                set.add(str[i]);
            }
       } 
       if(set.size()!=uniqueChars){
        return false;
       }
       return true;
    }
    //Brute force
    // public static boolean isMagicSquare(int[][] grid,int row,int col){
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i = row; i<row+3 ;i++){
    //         for(int j = col; j<col+3 ; j++){
    //             if(!(grid[i][j]>=1 && grid[i][j]<=9 && !set.contains(grid[i][j]))){
    //                 return false;  
    //             }
    //             set.add(grid[i][j]);
    //         }
           
    //     }
    //     //Row Sum
    //     int rowSum = 0;
    //     int prevSum = grid[row][col]+grid[row][col+1]+grid[row][col+2];
    //     for(int i=row+1; i<row+3 ; i++){
    //         rowSum = grid[i][col]+grid[i][col+1]+grid[i][col+2];
    //         if(!(prevSum == rowSum)){
    //             return false;
    //         }
    //         prevSum = rowSum;
    //     }

    //     //Column Sum
    //     int colSum = 0;
    //     prevSum = grid[row][col]+grid[row+1][col]+grid[row+2][col];
    //     for(int j=col+1; j<col+3 ; j++){
    //         colSum = grid[row][j]+grid[row+1][j]+grid[row+2][j];
    //         if(!(prevSum == colSum)){
    //             return false;
    //         }
    //         prevSum = colSum;
    //     }

    //     //Diagonal  Sum
    //     int diagSum1 = 0;
    //     for(int k = 0 ; k<3 ; k++){
    //         diagSum1 += grid[row+k][col+k];
    //     }
    //     int diagSum2 = 0;
    //     for(int k = 0 ; k<3 ; k++){
    //         diagSum2 += grid[row+k][col+2-k];
    //     }
    //     if(rowSum == colSum && diagSum1 == diagSum2){
    //         if(rowSum == diagSum1){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
     //Optimised approach
    public static boolean isMagicSquare(int[][] grid,int row,int col){
        boolean[] seen = new boolean[10]; 
        int pt = 1;
        //middle element  == 5
        if( grid[row+1][col+1] !=5 ) return false; 

        //opposite elements sum must be 10
        if(grid[row+1][col] + grid[row+1][col+2] !=10) return false; 
        if(grid[row][col] + grid[row+2][col+2] !=10) return false; 
        if(grid[row][col+2] + grid[row+2][col] !=10) return false; 
       
        for(int i=row ; i<row+3 ; i++){
            for(int j = col ; j<col+3; j++){
                //check 1-9 and distinct
                if(!( grid[i][j]>=1 && grid[i][j]<=9 && !seen[pt])) return false;
                seen[pt] = false;
                pt++; 
            }
        }
        //row,col,diagonal sum must be same 
        if( grid[row][col] + grid[row][col+1] + grid[row][col+2] !=15 ) return false;
        if(grid[row+2][col]+grid[row+2][col+1]+grid[row+2][col+2] != 15) return false;
        if( grid[row][col] + grid[row+1][col] + grid[row+2][col] !=15 ) return false;
        if(grid[row][col+2]+grid[row+1][col+2]+grid[row+2][col+2] != 15) return false;
        
        return true;
    } 
    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i=0 ; i < grid.length-2 ; i++){
            for(int j=0 ; j<grid[0].length-2 ; j++){
                if(isMagicSquare(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

   
    public static void main(String[] args) {
        String str="dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern,str));
        System.out.println(numMagicSquaresInside(new int[][] {{4,3,8,4},{9,5,1,9},{2,7,6,2}}));

        
    }
}