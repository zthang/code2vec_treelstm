public int[] or(int[] f, int[] s) {
    int[] ans = new int[26];
    for (int i = 0; i < 26; i++) {
        ans[i] = f[i] | s[i];
    }
    return ans;
}