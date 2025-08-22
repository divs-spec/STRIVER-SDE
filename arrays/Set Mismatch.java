class Solution {
    public int missingNumber(int[] nums) {
        boolean [] hash = new boolean[nums.length + 1];
        for(int i = 0;i <= nums.length;i++) {
            hash[i] = false;
        }

        for(int num : nums) {
            hash[num] = true;
        }

        for(int i = 0;i <= nums.length;i++) {
            if(!hash[i]) {
                return i;
            }
        }
        return -1;
    }
}
