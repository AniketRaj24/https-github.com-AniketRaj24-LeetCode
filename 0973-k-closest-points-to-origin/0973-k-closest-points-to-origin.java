class Solution {
    static class Pair{
        int dist;
        int index;
        Pair(int dist, int index){
            this.dist = dist;
            this.index = index;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue <Pair> pq = new PriorityQueue<> (
            (a,b) -> {
                if(a.dist != b.dist){
                    return b.dist - a.dist;
                }else{
                    return b.index - a.index;
                }
            }
        );
        for(int i = 0; i < n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            Pair curr = new Pair(dist, i);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }else{
                if(curr.dist < pq.peek().dist){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        int[][] result = new int[k][2];
        int idx = k - 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            result[idx] = points[p.index];
            idx--;
        }
        return result;
    }
}