class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int top = st.pop();
                    int newTop = st.peek();
                    st.push(top);
                    st.push(top + newTop);
                }
                case "D" -> {
                    st.push(st.peek() * 2);
                }
                case "C" -> {
                    st.pop();
                }
                default -> st.push(Integer.parseInt(op));
            }
        }

        int score = 0;
        for (int val : st) {
            score += val;
        }

        return score;
    }
}
