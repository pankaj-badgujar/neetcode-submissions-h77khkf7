class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node left;
    Node right;
    


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(); 


        right = new Node(0,0);
        left = new Node(0,0);
        
        left.prev = null;
        right.prev = left;

        left.next = right;
        right.next = null;
    }

    private void removeNode(Node n){
        Node prv = n.prev;
        Node nxt = n.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    private void insertAtRight(Node n){
        // PN <..> R
        Node prv = right.prev;
        Node nxt = right;

        prv.next = n;
        nxt.prev = n;

        n.prev = prv;
        n.next = nxt;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            // update LL
            removeNode(n);
            insertAtRight(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // remove node
            removeNode(map.get(key));    
        } 
        // create new node
        map.put(key, new Node(key, value));
        // insert new node at right
        insertAtRight(map.get(key));
            
        if(map.size() > capacity){
            Node lru = left.next;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
}
