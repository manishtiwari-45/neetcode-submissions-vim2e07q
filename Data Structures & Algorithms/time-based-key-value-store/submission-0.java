class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
}

class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap(){
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        Pair current = new Pair(timestamp, value);

        if(!map.containsKey(key)){
            List<Pair> list = new ArrayList<>();
            list.add(current);
            map.put(key, list);
        } else{
            List<Pair> list = map.get(key);
            list.add(current);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;

        String ans = "";
        while(left <= right){
            int mid = left + (right - left)/2;
            if(list.get(mid).timestamp <= timestamp){
                ans = list.get(mid).value;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

