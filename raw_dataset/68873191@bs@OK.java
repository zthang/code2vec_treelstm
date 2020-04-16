private static int bs(int i) {
    int high = n - 1;
    int low = i;
    int ans = -1;
    int count = 1;
    while (high >= low) {
        int mid = (high + low) >> 1;
        if (a[mid] - a[i] <= 5) {
            ans = mid;
            low = mid + 1;
            count = mid - i + 1;
        } else {
            high = mid - 1;
        }
    }
    return count;
}