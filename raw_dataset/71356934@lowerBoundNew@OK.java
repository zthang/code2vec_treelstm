/*
	 * Returns an iterator pointing to the first element in the range [first,
	 * last] which does not compare less than val.
	 * 
	 */
private static int lowerBoundNew(long[] arr, long num) {
    int start = 0;
    int end = arr.length - 1;
    int index = 0;
    int len = arr.length;
    int mid = 0;
    while (true) {
        if (start > end) {
            break;
        }
        mid = (start + end) / 2;
        if (arr[mid] > num) {
            end = mid - 1;
        } else if (arr[mid] < num) {
            start = mid + 1;
        } else {
            while (mid >= 0 && arr[mid] == num) {
                mid--;
            }
            return mid + 1;
        }
    }
    if (arr[mid] < num) {
        return mid + 1;
    }
    return mid;
}