class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int n = strs.length;
        // iterate from index 1 to last, and compare them with them
        // on each iteration with the first, 
        // as soon as an uncommon is spotted, 
        // ex: a string's 4th position, the rest is snipped
        // Take the first as default, and keep making it smaller.
        String res = strs[0];
        for(int i = 1; i < n; i++){
            int j = 0;
            // j manages indexes
            // as long as:
            // index is smaller than both arrays.
            // both chars are same
            // both arrays indices refer to res and strs[i] chars
            // 
            while( j < strs[i].length() && 
            j < res.length() &&
            strs[i].charAt(j) == res.charAt(j) 

            ){
                j++;
            }
            res = res.substring(0, j);
            if(res.isEmpty()) return "";
        }
        return res;
    }
}