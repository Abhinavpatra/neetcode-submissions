class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if(n == 0 || n == 1) return n;
// need to check, the longest sequence of numbers
// that we can form, using this entire array.
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){ hs.add(num); }
        int maxCount = 1;
        
        for(int num: nums){
            int count = 1;
            if(hs.contains(num - 1)) continue;
            int current = num;
            while(true){
                if(hs.contains(current + 1)){
                     count++;
                }else{
                    break;                
                }
                current++;
            }
            maxCount = (count > maxCount)? count: maxCount;

        }
        return maxCount;
    }
}
