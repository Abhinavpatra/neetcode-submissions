class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int bottom = m-1, right = n-1;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){

            for(int i = left ; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);

            }
            right--;
            
            if (top <= bottom) {
                
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                
                bottom--;// the bottom line is done

            }
            
            if(left <= right){
            
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
            
                left++; // the left line is done            
            }
        }
        return res;
    }
}
