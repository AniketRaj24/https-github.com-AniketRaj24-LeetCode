class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List <int[]> projects = new ArrayList<>();
        for(int i = 0; i < n; i++){
            projects.add(new int[]{capital[i], profits[i]});
        }
        projects.sort((a,b) -> a[0] - b[0]);

        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while(k-- > 0){
            while(idx < n && projects.get(idx)[0] <= w){
                pq.add(projects.get(idx)[1]);
                idx++;
            }    
                if(pq.isEmpty()){
                    return w;
                }else{
                    w = w + pq.peek();
                    pq.poll();
                }
        }
        return w;
    }
}