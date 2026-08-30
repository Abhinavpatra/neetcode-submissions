class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for (int i = 0; i < k; ++i) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {              
                dq.pollLast();
            }

            dq.addLast(i);
        }

        for (int i = k; i < nums.length; ++i) {          
            res.add(nums[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {              
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        res.add(nums[dq.peekFirst()]);
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

