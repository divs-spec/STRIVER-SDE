class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0) + 1);
        }
        List<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            if(entry.getValue() > (n/3))
            ls.add(entry.getKey());
        }
        return ls;
    }
}
