package algorithm.list;

/**
 * 线性数据结构-数组
 * 参考 https://www.pdai.tech/md/algorithm/alg-basic-array.html
 */
public class ArrayOpt {

    /**
     * 把数组中的 0 移到末尾
     */
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    /**
     * 找出数组中最长的连续 1
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
//        for (int temp: nums){
//            System.out.println(temp);
//        }
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
