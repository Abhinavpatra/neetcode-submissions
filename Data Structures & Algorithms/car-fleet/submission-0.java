
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [] time = new double[n];
        // so what if we make an array called time

        int fleet = 0;
        for(int i = 0; i < n; i++){
            time [i] = (double)(target - position[i]) / speed[i];
        }

  // and then if the value in next index is equal then same fleet, more then new fleet, less then same fleet.

// and update when we get a time more than the peak

// once time has been calculated, speed does not matter, so we sort the time array based on position
        
        // Store indices
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        // Sort indices by position, closest to target first
        Arrays.sort(order, (a, b) -> position[b] - position[a]);
        double peak = 0;
        for(int i = 0; i < n; i++){
            if(time[order[i]] > peak){
                fleet++;
                peak = time[order[i]];
            }
        }
        return fleet;
    }
}
 