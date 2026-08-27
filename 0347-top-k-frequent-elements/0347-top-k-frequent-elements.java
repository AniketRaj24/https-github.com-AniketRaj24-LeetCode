class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
        this.first = first;
        this.second = second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first){
                    return a.first - b.first;
                }else{
                    return a.second - b.second;
                }
            }
        );

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> i : map.entrySet()){
            int element = i.getKey();
            int freq = i.getValue();
            Pair curr = new Pair(freq, element);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }else{
                if(curr.first > pq.peek().first){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        List <Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.peek().second);
            pq.poll();
        }      
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] += res.get(i);
        }
        return result;
    }
}