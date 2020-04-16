static int longestSubSeg(int[] a, int n, int k) {
    int cnt0 = 0;
    int l = 0;
    int max_len = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] == 0)
            cnt0++;
        while (cnt0 > k) {
            if (a[l] == 0)
                cnt0--;
            l++;
        }
        max_len = Math.max(max_len, i - l + 1);
    }
    return max_len;
}