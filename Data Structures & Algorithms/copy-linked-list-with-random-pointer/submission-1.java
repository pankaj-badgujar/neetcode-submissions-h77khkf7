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
        // if(head == null){
        //     return null;
        // }

        // i will use a map to save key (old node) vs value (its equivalent new node).
        // for keys not already in map (unvisited), i will maintain a stack of old nodes
        Map<Node, Node> map = new HashMap<>();

        Stack<Node> stack = new Stack<>();

        Node dummy = new Node(-1);
        Node curr = dummy;
        Node old = head;

        while(old != null){
            // since old is not null, it means it is a node. 
            // so first we create a new node and assign value and next.
            Node newNode = new Node(old.val);
            System.out.println("old: " + old.val);
            System.out.println("newNode: " + newNode.val);
            System.out.println("curr: " + curr.val);
            newNode.next = old.next;

            // now we put old and newNode in map
            map.put(old, newNode);

            // now for random first we check null
            // then we check if map already has the old's random present
            // if it has, means we have created it before so we set ours to its value
            // if its not, then we need to add that in pending stack
            if(old.random == null){
                newNode.random = null;
            } else if(map.get(old.random) == null){
                // means map does not have it yet,
                stack.push(old);
            } else {
                newNode.random = map.get(old.random);
            }
            curr.next = newNode;
            curr = curr.next;
            old = old.next;
        }

        // now while stack is not empty, lets assign its randoms
        while(!stack.isEmpty()){
            Node oldFromStack = stack.pop();
            map.get(oldFromStack).random = map.get(oldFromStack.random);
        }
        return dummy.next;
    }
}
