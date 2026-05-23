/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Node dfs(Node node, Set visited, Map<Integer, Node> map){
        if (visited.contains(node)){
            return map.get(node.val);
        }
        visited.add(node);
        Node res = new Node(node.val);
        map.put(node.val, res);

        for (Node neighbor : node.neighbors){
            Node newNeighbor = dfs(neighbor, visited, map);
            if (newNeighbor != null){
                res.neighbors.add(newNeighbor);
            }
        }

        return res;
    }
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }

        Set<Node> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();

        return dfs(node, set, map);
        
    }
}