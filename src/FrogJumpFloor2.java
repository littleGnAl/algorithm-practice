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
        // 3
        System.out.println(new FrogJumpFloor2().JumpFloorII(3));
        // 6
        System.out.println(new FrogJumpFloor2().JumpFloorII(4));
    }
}
