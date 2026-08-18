class Solution {

    public String encode(List<String> strs) {
        String encoded_string = "";
        for(String s: strs){
            encoded_string += "!z";
            encoded_string += s;
        }
        return encoded_string;
    }
// !zHello!zWorld
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String [] parts = str.split("!z", -1);
        for( int i = 1; i < parts.length; i++){
            res.add(parts[i]);
        }
        return res;
    }
}

