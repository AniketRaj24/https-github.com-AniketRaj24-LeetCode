class Solution {
    public List<List<Integer>> permute(int[] nums){
        int n = nums.length;
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n]; 
        fun(nums, n, diary, res, used);
        return res;
    }
    public void fun(int[] nums, int n, List<Integer> diary, List<List<Integer>> res, boolean[] used){
        if(diary.size() == n){
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int i = 0; i < n; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            diary.add(nums[i]);
            fun(nums, n, diary, res, used);
            diary.remove(diary.size() - 1);
            used[i] = false;
        }
    }
}