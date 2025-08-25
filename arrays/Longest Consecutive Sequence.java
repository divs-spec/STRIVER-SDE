class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        return 0;
        Arrays.sort(nums);
        int ls = Integer.MIN_VALUE, cnt = 0, longest = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 == ls)
            {
                cnt += 1;
                ls = nums[i];
            }
            if(nums[i]!=ls){
                cnt = 1;
                ls = nums[i];
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }
}
