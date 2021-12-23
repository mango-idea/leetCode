package leetcode.editor.cn;

//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 👍 330 👎 0

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
        String s = "CR";
        List<String> ans = solution.letterCasePermutation(s);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String _s;
        int length;

        public List<String> letterCasePermutation(String s) {
            if (s == null || s.length() == 0) {
                return new ArrayList<>();
            }
            _s = s.toLowerCase();
            length = s.length();
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if ('a' <= _s.charAt(i) && _s.charAt(i) <= 'z') {
                    def(i, ans);
                }
            }
            if (ans.isEmpty()) {
                ans.add(s);
            }
            return ans;
        }

        private void def(int i, List<String> ans) {
            if (ans.isEmpty()) {
                ans.add(_s);
                ans.add(_s.substring(0, i) + Character.toUpperCase(_s.charAt(i)) + _s.substring(i + 1, length));
            } else {
                List<String> ansExt = new ArrayList<>(ans.size());
                for (String res : ans) {
                    ansExt.add(res.substring(0, i) + Character.toUpperCase(res.charAt(i)) + res.substring(i + 1, length));
                }
                ans.addAll(ansExt);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}