class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i]))
            return nums[i];
            hm.put(nums[i],1);
        }
        return -1;
    }
}
/*
import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // not possible as per problem constraints
    }
}
*/
