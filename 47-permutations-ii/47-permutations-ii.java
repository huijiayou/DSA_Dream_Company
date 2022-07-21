class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res,0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, int i) {
        Set<Integer> set = new HashSet<>();
        if (i >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int item : nums) {
                list.add(item);
            }
            res.add(list);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (set.add(nums[j])) {
                swap(nums, i, j);
                dfs(nums, res, i + 1);
                swap(nums, i, j);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}