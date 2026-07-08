class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i : queries){
            set.add(i);
        }

        for (int[] i : intervals){
            int left = i[0];
            int right = i[1];

            for (int j = left; j <= right; j++){
                if (!set.contains(j)) continue;
                map.put(j, Math.min(map.getOrDefault(j, Integer.MAX_VALUE), right - left + 1));
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            res[i] = map.getOrDefault(queries[i], -1);
        }

        return res;

    }
}
