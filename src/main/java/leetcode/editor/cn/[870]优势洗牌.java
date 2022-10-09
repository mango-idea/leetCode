package leetcode.editor.cn;

//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 双指针 排序 👍 296 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
        int[] nums1 = {2, 0, 4, 1, 2};
        int[] nums2 = {1, 3, 0, 0, 2};
        int[] res = solution.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            1、记住nums2的下标用于构建结果
            2、对nums1、nums2进行排序
            3、依次用nums1的值与nums2的值进行比较匹配，由于数组已进行排序
            ，若nums1的值不符合则将其值置于最大值的对应位
         */
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int length = nums1.length;
            Map<Integer, List<Integer>> idxMap = new HashMap<>();
            for (int i = 0; i < length; i++) {
                List<Integer> idxList = idxMap.getOrDefault(nums2[i], new ArrayList<>());
                idxList.add(i);
                idxMap.put(nums2[i], idxList);
            }
            int[] ans = new int[length];
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            for (int l1 = 0, l2 = 0, r2 = length - 1; l1 < length; l1++) {
                int t = nums1[l1] > nums2[l2] ? l2 : r2;
                List<Integer> idxList = idxMap.get(nums2[t]);
                Integer idx = idxList.remove(idxList.size() - 1);
                ans[idx] = nums1[l1];
                if (t == l2) {
                    l2++;
                } else {
                    r2--;
                }
            }
            return ans;
        }
        //leetcode submit region end(Prohibit modification and deletion)
    }
}