private static int binarySearchPM(int[] arr, int key) {
    int n = arr.length;
    int mid = -1;
    int begin = 0, end = n;
    while (begin <= end) {
        mid = (begin + end) / 2;
        if (mid == n) {
            return n;
        }
        if (key < arr[mid]) {
            end = mid - 1;
        } else if (key > arr[mid]) {
            begin = mid + 1;
        } else {
            return mid;
        }
    }
    // expected Index
    return -begin;
}