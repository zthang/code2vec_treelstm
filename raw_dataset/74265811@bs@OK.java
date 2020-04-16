static void bs(ArrayList<Integer> arr, int max, int k, int n) {
    int l = 1;
    int h = max;
    ans = h;
    while (l <= h) {
        int m = (l + h) / 2;
        int r = 0;
        for (int i = 0; i < n; ++i) {
            r += (arr.get(i) + m - 1) / m;
            r--;
        }
        if (r <= k) {
            ans = m;
            h = m - 1;
        } else
            l = m + 1;
    }
}