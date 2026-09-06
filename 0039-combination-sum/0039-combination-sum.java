class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int idx = 0;
        List <Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        fun(candidates, n, idx, diary, res, sum, target);
        return res;
    }
    public void fun(int[] candidates, int n, int idx, List <Integer> diary, List<List<Integer>> res, int sum, int target){
        if(idx == n){
            if(sum == target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }    
            fun(candidates, n, idx + 1, diary, res, sum, target);
            if(sum + candidates[idx] <= target){
                diary.add(candidates[idx]);
                fun(candidates, n, idx, diary, res, sum + candidates[idx], target);
                diary.remove(diary.size() - 1);
            }
    } 
}