class Solution {
    static class Pair{
        int freq;
        char second;
        Pair(int freq, char second){
            this.freq = freq;
            this.second = second;
        }
    }
    public String reorganizeString(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int[] count = new int[26];
        for(int i = 0; i < n; i++){
            count[s.charAt(i) - 'a']++;
        }

        PriorityQueue <Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq != b.freq){
                    return b.freq - a.freq;
                }else{
                    return b.second - a.second;
                }
            }
        );
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                if(count[i] > (n + 1) / 2){
                    return "";
                }
                pq.add(new Pair(count[i], (char)('a' + i)));
            }
        }

        int seat = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(seat == 0 || res.charAt(seat - 1) != curr.second){
                res.append(curr.second);
                seat++;
                curr.freq--;
                if(curr.freq > 0){
                    pq.add(curr);
                }
            }else{
                if(!pq.isEmpty()){
                    Pair next = pq.poll();
                    res.append(next.second);
                    seat++;
                    next.freq--;
                    if(next.freq > 0){
                        pq.add(next);
                    }
                    pq.add(curr);
                }else{
                    return "";
                }
            }
        }
        return res.toString();
    }
}