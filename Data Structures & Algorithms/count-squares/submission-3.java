class CountSquares {
    record Cords(int x, int y){};
    
    Map<Cords, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    
    }
    
    public void add(int[] point) {
        Cords c = new Cords(point[0], point[1]);
        map.merge(c, 1, Integer::sum);
    
    }
    
    public int count(int[] point) {
        int count = 0;
        int px = point[0], py = point[1];
        
        for (Cords c : map.keySet()){
            if (
                Math.abs(px - c.x) != Math.abs(py - c.y) ||
                px == c.x || py == c.y
            ){
                continue;
            }
            // diagonal found
            // then we find matches and add counts
            Cords c1 = new Cords(px, c.y);
            Cords c2 = new Cords(c.x, py);
            count += map.get(c) * map.getOrDefault(c1, 0) * map.getOrDefault(c2, 0);
            
        }
        return count;
    }
}
