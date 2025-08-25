class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*Arrays.sort(nums);
        Set<List<Integer>> ls = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    for(int t = k+1; t < nums.length; t++){
                        if(nums[i] + nums[j] + nums[k] + nums[t] == target){
                            List<Integer> ts = new ArrayList<>();
                            ts.add(nums[i]);
                            ts.add(nums[j]);
                            ts.add(nums[k]);
                            ts.add(nums[t]);
                            ls.add(ts);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(ls);
        return ans;*/
        int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
