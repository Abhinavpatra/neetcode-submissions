class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st  = new Stack<>();
        for(int i = 0; i < n; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int a = st.pop();
                int b = st.pop();
                int dig = 0;
                if(tokens[i].equals("+")) dig = b+a;
                if(tokens[i].equals("-")) dig = b-a;
                if(tokens[i].equals("*")) dig = b*a;
                if(tokens[i].equals("/")) dig = b/a;
                st.push(dig);
            }
            else{
            st.push(Integer.parseInt(tokens[i]));
            }
        }
        int dig = st.pop();
        return dig;
    }
}
