class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for(int num: nums){
            if(!res.add(num)){
                return true;
            }
        }
        return false;
    }
}