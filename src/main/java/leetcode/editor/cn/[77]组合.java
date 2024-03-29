package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1164 👎 0

import java.util.ArrayList;
import java.util.List;

class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        List<List<Integer>> ans = solution.combine(4, 2);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            getCombine(n, k, 1, new ArrayList<>());
            return ans;
        }

        void getCombine(int n, int k, int start, ArrayList<Integer> list) {
            if (k == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i <= n - k + 1; i++) {
                list.add(i);
                getCombine(n, k - 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}