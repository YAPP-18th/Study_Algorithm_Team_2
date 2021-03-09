class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        
        for(int n : nums)
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        
        for(int n : countMap.values())
            result += n * (n-1)/2;
        
        return result;
    }
}
