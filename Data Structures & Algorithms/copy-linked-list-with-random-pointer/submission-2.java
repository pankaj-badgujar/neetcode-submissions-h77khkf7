/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // i will use a map to save key (old node) vs value (its equivalent new node).
        // for keys not already in map (unvisited), i will maintain a stack of old nodes
        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(-1);
        Node curr = dummy;
        Node old = head;

        while(old != null){
            // since old is not null, it means it is a node. 
            // so first we check map if node already exists, if it does, we just pick it, 
            // else we create a new node and assign value and next.
            Node newNode;
            if(map.get(old) == null){
                newNode = new Node(old.val);
                // now we put old and newNode in map
                map.put(old, newNode);
            } else {
                newNode = map.get(old);
            }
            newNode.next = old.next;


            // now for random first we check null
            // then we check if map already has the old's random present
            // if it has, means we have created it before so we set ours to its value
            // if its not, then we create it now and add it to the map
            if(old.random == null){
                newNode.random = null;
            } else if(map.get(old.random) != null){
                newNode.random = map.get(old.random);
            } else {
                // means map does not have it yet, so we create it and put it in map
                Node brandNewNodeForRandom = new Node(old.random.val);
                map.put(old.random, brandNewNodeForRandom);

                // and then we assign it to our node as random
                newNode.random = brandNewNodeForRandom;
            }
            curr.next = newNode;
            curr = curr.next;
            old = old.next;
        }

        return dummy.next;
    }
}
