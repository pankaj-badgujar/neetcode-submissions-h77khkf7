class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean firstMatch = false;
        boolean secondMatch = false;
        boolean thirdMatch = false;

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

            firstMatch = firstMatch || c[0] == target[0];
            secondMatch = secondMatch || c[1] == target[1];
            thirdMatch = thirdMatch || c[2] == target[2];

            if (firstMatch && secondMatch && thirdMatch) return true;
        }
        return false;
    }
}
