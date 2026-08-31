class Solution {
    public boolean isPalindrome(String s) {
        // all upper->lower, remove alphanumerics, remove space
        // a-z 65 90    
        // A-Z 97-122
        String res="";
        for(char c: s.toCharArray()){
            if(c >= 65 && c <= 90) res += (char)(c + 32);
            else if ( c >= 97 && c <= 122) res +=c;
            else if ( c >= 48 && c <= 57) res +=c;
        }
    
        boolean check = true;
        for(int i = 0 ; i < res.length(); i++){
            if(res.charAt(i) != res.charAt(res.length() - i - 1)){ check = false; break;}
        }
        return check;
    }
}

