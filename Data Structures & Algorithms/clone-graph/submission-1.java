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

    private Node dfs(Node node, Map<Node, Node> map){
        if (map.containsKey(node)){
            return map.get(node);
        }
        Node res = new Node(node.val);
        map.put(node, res);

        for (Node neighbor : node.neighbors){
            Node newNeighbor = dfs(neighbor, map);
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

        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
        
    }
}