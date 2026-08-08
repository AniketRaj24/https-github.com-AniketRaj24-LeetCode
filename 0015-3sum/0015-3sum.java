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
            int sum = -1 * a[i];

            while(left < right){
                int s = a[left] + a[right];
                if(s == sum){
                    ans.add(Arrays.asList(a[i], a[left], a[right]));
                    left ++;
                    right --;

                    while(left < a.length && a[left] == a[left - 1]){
                        left ++;
                    }
                    while(right >= 0 && a[right] == a[right + 1]){
                        right --;
                    }

                }else if(s < sum){
                    left ++;
                }else{
                    right --;
                }
            }
        }

    return ans;
        
    }
}