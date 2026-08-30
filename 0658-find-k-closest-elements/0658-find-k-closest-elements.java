class Solution {
    static class Pair{
        int dist;
        int val;
        Pair(int dist, int val){
            this.dist = dist;
            this.val = val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> {
                if(a.dist != b.dist){
                    return b.dist - a.dist;
                }else{
                    return b.val - a.val;
                }
            }
        );

        for(int i = 0; i < n; i++){
            int val = arr[i];
            int dist = Math.abs(val - x);
            Pair curr = new Pair(dist, val);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }else{
                if(curr.dist < pq.peek().dist || curr.dist == pq.peek().dist && curr.val < pq.peek().val){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().val);
        }
        Collections.sort(result);
        return result;
    }
}