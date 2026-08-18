class Solution {
    public int removeElement(int[] nums, int val) {
        int check = 0;
        for(int num: nums){
            if(num != val){
                nums[check] = num;
                check++;
            }
        }
        return check;
    }
}