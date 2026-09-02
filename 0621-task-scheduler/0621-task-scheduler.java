class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> free = new HashMap<>();

        for(int i = 0; i < m; i++){
            char c = tasks[i];
            freq.put(c, freq.getOrDefault(c,0) + 1);
            free.put(c,1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> {
                if(a.first != b.first){
                    return b.first - a.first;
                }else{
                    return b.second - a.second;
                }
            }
        );
         for(Map.Entry<Character, Integer> entry: freq.entrySet()){
            pq.add(new Pair(entry.getValue(), entry.getKey()));
         }

        int seat = 1;
            while(!pq.isEmpty()){
                List<Pair> pulled = new ArrayList<>();
                while(!pq.isEmpty()){
                     Pair p = pq.peek();
                     pq.poll();
                     int currFreq = p.first;
                     int child = p.second;
                     if(free.get((char) child) <= seat){
                        if(p.first > 1){
                            pq.add(new Pair(p.first - 1, p.second));
                            free.put((char) p.second, seat + n + 1);
                        }
                        break;
                     }else{
                        pulled.add(p);
                     }
                }
                for(int j = 0; j < pulled.size(); j++){
                    pq.add(pulled.get(j));
                }
                seat++;
            }
        return seat - 1;
    }
}