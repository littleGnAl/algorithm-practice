package nowcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FrogJumpFloor2 {
    public int JumpFloorII(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;

        return 2 * JumpFloorII(target - 1);
    }

    public static void main(String[] args) {
        // 1
        System.out.println(new FrogJumpFloor2().JumpFloorII(1));
        // 2
        System.out.println(new FrogJumpFloor2().JumpFloorII(2));
        // 4
        System.out.println(new FrogJumpFloor2().JumpFloorII(3));
        // 8
        System.out.println(new FrogJumpFloor2().JumpFloorII(4));
    }
}
