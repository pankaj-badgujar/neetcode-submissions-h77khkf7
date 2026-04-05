class TimeValue {
    private int timestamp;
    private String value;

    public TimeValue(int t, String v){
        this.timestamp = t;
        this.value = v;
    }
    public int getTimestamp(){
        return this.timestamp;
    }
    public String getValue(){
        return this.value;
    }
}

class TimeMap {

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> tvList = map.getOrDefault(key, new ArrayList<TimeValue>());
        TimeValue newTv = new TimeValue(timestamp, value);
        tvList.add(newTv);
        
        map.put(key, tvList);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<TimeValue> tvList = map.get(key);

        int l = 0, r = tvList.size() - 1;

        while(l <= r){
            int m = l + (r - l)/2;
            TimeValue tvMid = tvList.get(m);
            int midTimestamp = tvMid.getTimestamp();
            
            if(midTimestamp == timestamp){
                return tvMid.getValue();
            }
            if(midTimestamp > timestamp){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return r < 0 ? "" : tvList.get(r).getValue();
    }
}
