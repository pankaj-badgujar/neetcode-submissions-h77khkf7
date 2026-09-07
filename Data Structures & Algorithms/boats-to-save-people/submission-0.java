class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // [1,2,2,3,3]

        int left = 0, right = people.length - 1;
        int boat = 0;

        while (left < right){
            // since right people are bigger, we should check it first
            if (people[left] + people[right] <= limit){
                left++;
            }
            right--;
            boat++;
        }
        if (left == right) boat++;
        return boat;


        
    }
}