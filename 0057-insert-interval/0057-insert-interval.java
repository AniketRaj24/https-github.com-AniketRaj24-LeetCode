class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> temp = new ArrayList<> ();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean insert = false;
        for(int i = 0; i < intervals.length; i++){
            if(!insert && start <= intervals[i][0]){
                temp.add(new int[] {start, end});
                insert = true;
            }
            temp.add(intervals[i]);
        }
        if(!insert){
            temp.add(new int[] {start, end});
        }
        List<int[]> result = new ArrayList<> ();
        int start1 = temp.get(0)[0];
        int end1 = temp.get(0)[1];

        for(int i = 1; i < temp.size(); i++){
            int start2 = temp.get(i)[0];
            int end2 = temp.get(i)[1];
            if(end1 >= start2){
                end1 = Math.max(end1, end2);
            }else{
            result.add(new int[] {start1, end1});
            start1 = start2;
            end1 = end2;
            }
        }
        result.add(new int[] {start1, end1});
        return result.toArray(new int[result.size()][]);
    }
}