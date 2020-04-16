static int search(int x, pair[] arr) {
    int low = 0, high = arr.length - 1, ans = -1;
    while (low <= high) {
        int mid = (low + high) >> 1;
        if (arr[mid].x >= x) {
            ans = mid;
            high = mid - 1;
        } else
            low = mid + 1;
    }
    return ans;
}