class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // total 2^n elements, either a number is selected or not.
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, 0, curr, res);
        // backtrack(array, index(0), curr, res)
        return res;
    }
    
    public void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res){
        
        res.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }// runs on the 2nd rep
            
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1); // removes last element appended

        }
    }

}