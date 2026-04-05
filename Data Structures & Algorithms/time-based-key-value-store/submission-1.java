class TimeValue {
    final int timestamp;
    final String value;

    public TimeValue(int t, String v){
        timestamp = t;
        value = v;
    }
}

class TimeMap {

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> tvList = map.get(key);
        if(tvList == null){
            return "";
        }

        int l = 0, r = tvList.size() - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            int midTimestamp = tvList.get(m).timestamp;
            
            if(midTimestamp == timestamp){
                return tvList.get(m).value;
            }
            if(midTimestamp > timestamp){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return r < 0 ? "" : tvList.get(r).value;
    }
}
