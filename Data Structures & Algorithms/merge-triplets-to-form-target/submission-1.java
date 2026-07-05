class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        
        int[] c = null;

        for (int i = 0; i < triplets.length; i++){

            int[] triplet = triplets[i];
            
            // check if this triplet is less or eq to target, then we can make it candidate
            if (
                triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]
            ) {
                // not a candidate
                continue;
            }
            // else we found a new candidate
            if (c == null){
                c = triplet;
            } else {
                // now if there is one there already, we operate and end up with one.
                int[] newTriplet = new int[]{ 
                    Math.max(c[0], triplet[0]), 
                    Math.max(c[1], triplet[1]), 
                    Math.max(c[2], triplet[2])
                };
                c = newTriplet;

            }
            if (
                c[0] == target[0] &&
                c[1] == target[1] &&
                c[2] == target[2]
            ){
                return true;
            }
        }
        return false;
    }
}
