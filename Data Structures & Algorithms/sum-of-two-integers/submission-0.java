class Solution {
    public int getSum(int a, int b) {
        
        while (b != 0){
            int xorOp = a ^ b;
            int andOp = (a & b) << 1;

            if (andOp == 0){
                return xorOp;
            }
            a = xorOp;
            b = andOp;
        }
        return a;
    }
}
