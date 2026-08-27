class Solution {
    static class Pair{
        int first;
        String second;
        Pair(String second, int first){
        this.first = first;
        this.second = second;
        }
    }
    public List<String> topKFrequent(String[] words, int k){
        int n = words.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first){
                    return a.first - b.first;
                }else{
                    return b.second.compareTo(a.second);
                }
            }
        );

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String c = words[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<String, Integer> i : map.entrySet()){
            String element = i.getKey();
            int freq = i.getValue();
            Pair curr = new Pair(element, freq);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }else{
                if(curr.first > pq.peek().first || (curr.first == pq.peek().first && curr.second.compareTo(pq.peek().second) < 0)){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        List <String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().second);
        }      
       Collections.reverse(res);
       return res;
    }
}