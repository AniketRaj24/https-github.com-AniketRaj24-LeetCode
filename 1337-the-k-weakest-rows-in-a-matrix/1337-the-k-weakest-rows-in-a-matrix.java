class Solution {
    static class Pair{
        int soldiers;
        int index;
        Pair(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue <Pair> pq = new PriorityQueue<> (
            (a,b) -> {
                if(a.soldiers != b.soldiers){
                    return b.soldiers - a.soldiers;
                }else{
                    return b.index - a.index;
                }
            }
        );
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            Pair curr = new Pair(count, i);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }else{
                if(curr.soldiers < pq.peek().soldiers || 
                  (curr.soldiers == pq.peek().soldiers && curr.index < pq.peek().index)){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        int[] result = new int[k];
        int idx = k - 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            result[idx] = p.index;
            idx--;
        }
        return result;
    }
}