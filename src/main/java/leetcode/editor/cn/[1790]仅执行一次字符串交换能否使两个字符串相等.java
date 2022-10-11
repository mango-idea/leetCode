package leetcode.editor.cn;

//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 75 👎 0

import java.util.Arrays;

class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        String s1 = "abcd";
        String s2 = "dcba";
        boolean ans = solution.areAlmostEqual(s1, s2);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            boolean ans = true;
            int[] indexArr = new int[26];
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                int i1 = s1.charAt(i) - 97;
                int i2 = s2.charAt(i) - 97;
                if (i1 != i2) {
                    indexArr[i1]++;
                    indexArr[i2]--;
                    count++;
                }
                if (count > 2) {
                    ans = false;
                    break;
                }
            }
            boolean flag = Arrays.stream(indexArr).anyMatch(i -> i != 0);
            return ans && !flag;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}