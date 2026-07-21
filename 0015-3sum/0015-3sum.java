class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < a.length; i++){
            if(i>0 && a[i] == a[i-1]){
                continue;
            }
            int left = i + 1;
            int right = a.length - 1;

            while(left < right){
                int sum = a[i] + a[left] + a[right];
                if(sum == 0){
                    ans.add(Arrays.asList(a[i], a[left], a[right]));
                    left ++;
                    right --;

                    while(left < right && a[left] == a[left - 1]){
                        left ++;
                    }
                    while(left < right && a[right] == a[right + 1]){
                        right --;
                    }

                }else if(sum < 0){
                    left ++;
                }else{
                    right --;
                }
            }
        }

    return ans;
        
    }
}