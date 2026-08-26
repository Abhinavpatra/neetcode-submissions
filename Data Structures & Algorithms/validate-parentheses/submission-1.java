class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') st.push(c);
            else if(c==')'){ 
                if(st.isEmpty() || st.peek() != '('){
                    res = false;
                    break;
                }
            st.pop();
            }
            else if(c==']'){ 
                if(st.isEmpty() || st.peek() != '['){
                    res = false;
                    break;
                }
            st.pop();
            }
            else if(c=='}'){ 
                if(st.isEmpty() || st.peek() != '{'){
                    res = false;
                    break;
                }
            st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return res;
    }
}
