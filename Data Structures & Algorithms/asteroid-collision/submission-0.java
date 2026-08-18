class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // index is their position
        // sign is direction of travel : negative is left, positive is right
        // number is size
    
        // need a stack to take and update based on sign and size
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            int curr = asteroids[i];
            
            // Collision only occurs when top is moving right (>0) and curr is moving left (<0)

            while (!st.isEmpty() && st.peek() > 0 && curr < 0){
                
                int top = st.peek();
                if (top < -curr) {
                    st.pop();
                }
                else if (top == -curr) {
                    // both explode
                    st.pop();
                    curr = 0;
                    break;
                }
                else {
                    // current asteroid explodes
                    curr = 0;
                    break;
                }
            }

            if (curr != 0) {
                st.push(curr);
            }
        }

        int[] arr = new int[st.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }
}