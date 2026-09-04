class MyHashSet {
    List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
        
    }
    
    public void add(int key) {
        if (!this.contains(key)){
            list.add(key);
        }
        
    }
    
    public void remove(int key) {
        for(Integer i : list){
            if (i == key){
                list.remove(i);
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        for (Integer i : list){
            if (i == key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */