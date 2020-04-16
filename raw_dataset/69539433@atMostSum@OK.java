static int atMostSum(int[] arr, int n, int k) {
    int sum = 0;
    int cnt = 0, maxcnt = 0;
    for (int i = 0; i < n; i++) {
        // cross limit add it to current window
        if ((sum + arr[i]) <= k) {
            sum += arr[i];
            cnt++;
        } else // window and add the current element
        if (sum != 0) {
            sum = sum - arr[i - cnt] + arr[i];
        }
        // keep track of max length.
        maxcnt = Math.max(cnt, maxcnt);
    }
    return maxcnt;
}