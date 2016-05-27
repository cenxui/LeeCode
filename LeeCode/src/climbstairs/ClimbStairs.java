package climbstairs;

public class ClimbStairs {
	
	public int climbStairs(int n) {
        return climb(n,0,1);
    }
	
	private int climb (int steps, int method1 ,int method2) {
        if (steps == 0) return method2;
        return climb(steps -1, method2, method1+method2);
    }
}