/*
	 * upper_bound() is a standard library function in C++ defined in the header
	 * . It returns an iterator pointing to the first element in the range
	 * [first, last) that is greater than value, or last if no such element is
	 * found
	 * 
	 */
private static int upperBoundNew(Integer[] arr, long num) {
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
            while (mid < len && arr[mid] == num) {
                mid++;
            }
            if (mid == len - 1 && arr[mid] == num) {
                return mid + 1;
            } else {
                return mid;
            }
        }
    }
    if (arr[mid] < num) {
        return mid + 1;
    }
    return mid;
}