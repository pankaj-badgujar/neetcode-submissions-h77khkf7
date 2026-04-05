class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        //O(n)
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        //O(nlogn)
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        
        
        int fleet = 0;
        double maxHrs = -1.0;

        for(int[] car : cars){
            System.out.println("car0: " + car[0] + "car1: " + car[1]);
            double hrsToTarget = (double)(target - car[0])/car[1];
            System.out.println("hrsToTarget: " + hrsToTarget);

            if(maxHrs == -1.0 ){
                maxHrs = hrsToTarget;
                fleet++;
            } else {
                if(hrsToTarget > maxHrs){
                    maxHrs = hrsToTarget;
            System.out.println("maxHrs: " + maxHrs);
                    fleet++;
                }
            }
        }
        return fleet;
    }
}
