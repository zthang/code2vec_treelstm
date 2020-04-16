static long answer(int offset, int[] pos) {
    long ans = 0;
    for (int i = 0; i < n; i++) ans += c[i][(int) ((offset + pos[i]) % 3)];
    return ans;
}