// Returns index of highest number less than or equal to key
public static int upper(long[] a, int length, long key) {
    int low = 0;
    int high = length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (key >= a[mid]) {
            ans = mid;
            low = mid + 1;
        } else if (a[mid] > key) {
            high = mid - 1;
        }
    }
    return ans;
}