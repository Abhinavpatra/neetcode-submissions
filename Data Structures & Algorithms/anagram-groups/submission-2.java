class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if( strs == null || strs.length == 0) return new ArrayList<>();
        Map <String, List<String>> map = new HashMap<>(); 
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String check = String.valueOf(chars);
            if(!map.containsKey( check )){
                map.put(check, new ArrayList<>());
            }
            map.get(check).add(s);
        }
        // all are from a-z
        // internally we can arrange all of them in asc order to a new array
        // and then compare and group each of the ones which are equal, and store the indexes
        // refer to those indexes, and create the solution array.

        return new ArrayList<>(map.values());
    }
}
