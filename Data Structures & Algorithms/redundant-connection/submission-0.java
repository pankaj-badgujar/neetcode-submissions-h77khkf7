class Solution {
    int[] par, rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        rank = new int[n + 1];


        for (int i = 0; i < n + 1; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges){
            if(!union(edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[1];
    }

    private boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2){
            return false;
        }
        if (rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        
        return true;
    }

    private int find(int n){
        if (n != par[n]){
            par[n] = find(par[n]);
        }
        return par[n];
    }
}
