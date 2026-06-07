class Solution {
    Map<String, List<String>> adj;
    List<String> result;
    int targetLen;

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        targetLen = tickets.size() + 1;

        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        for (List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }

        result = new ArrayList<>();
        result.add("JFK");

        if(dfs("JFK")){
            return result;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String src){
        if (result.size() == targetLen){
            return true;
        }
        if (!adj.containsKey(src)){
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(src));

        for (int i = 0; i < temp.size(); i++){
            String v = temp.get(i);
            adj.get(src).remove(i);
            result.add(v);
            
            if (dfs(v)) return true;

            adj.get(src).add(i, v);
            result.remove(result.size() - 1);
        }
        return false;
    }
}
