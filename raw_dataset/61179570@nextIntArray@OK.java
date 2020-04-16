int[] nextIntArray(int n) throws IOException {
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) ans[i] = nextInt();
    return ans;
}