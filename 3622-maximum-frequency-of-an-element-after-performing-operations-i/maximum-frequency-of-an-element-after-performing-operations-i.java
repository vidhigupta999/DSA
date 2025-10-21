class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> mp = new HashMap<>();
        for (int num : nums) mp.put(num, mp.getOrDefault(num,0)+1);
        List<Integer> keys = new ArrayList<>(mp.keySet());
        Collections.sort(keys);
        int freq=0, ans=0, i=0, j=0;
        for (int center = keys.get(0); center <= keys.get(keys.size()-1); center++) {
            while (j < keys.size() && keys.get(j) <= center+k) freq += mp.get(keys.get(j++));
            while (i < keys.size() && keys.get(i) < center-k) freq -= mp.get(keys.get(i++));
            ans = Math.max(ans, Math.min(mp.getOrDefault(center,0)+numOperations, freq));
        }
        return ans;
    }
}