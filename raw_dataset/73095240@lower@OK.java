// Returns index of least number greater than or equal to key
public static int lower(long[] a, int length, long key) {
    int low = 0;
    int high = length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (key <= a[mid]) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}