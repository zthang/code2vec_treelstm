public static int[] base6(int N, int num) {
    int[] ans = new int[N];
    for (int i = N - 1; i >= 0; i--) {
        int pow = (int) Math.pow(6, i);
        ans[i] = num / pow;
        num -= ans[i] * pow;
    }
    return ans;
}