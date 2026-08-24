class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        //hashmap arr1, 
        for(int n: arr1){
            if(mp.containsKey(n)) mp.put(n, mp.get(n) +1);
            else mp.put(n,1); 
        }
        int[] res = new int[arr1.length];
        int i = 0;
        for(int n: arr2){
            int f = mp.get(n);
            for (int j = 0; j < f; j++) {
                res[i++] = n;
            }
            mp.remove(n);
        }
        ArrayList<Integer> rem = new ArrayList<>(mp.keySet());
        Collections.sort(rem);
        for(int n: rem){
            int f = mp.get(n);
            for (int j = 0; j < f; j++) {
                res[i++] = n;
            }
        }
        return res;
    }
}