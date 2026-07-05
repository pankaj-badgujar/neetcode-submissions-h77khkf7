class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < triplets.length; i++){

            int[] c = triplets[i];
            
            // check if this triplet is less or eq to target, then we can make it candidate
            if (
                c[0] > target[0] ||
                c[1] > target[1] ||
                c[2] > target[2]
            ) {
                // not a candidate
                continue;
            }

            for (int k = 0; k < 3; k++){
                if (c[k] == target[k]){
                    set.add(k);
                }
            }
            if (set.size() == 3) return true;
        }
        return set.size() == 3;
    }
}
