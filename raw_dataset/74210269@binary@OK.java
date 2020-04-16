static int binary(int left, int right, int[] ar, int no) {
    int mid = (left + right) / 2;
    if (Math.abs(right - left) <= 1) {
        if (no >= ar[right]) {
            return right + 1;
        } else if (no < ar[left]) {
            return left;
        } else {
            return left + 1;
        }
    }
    if (ar[mid] > no) {
        right = mid - 1;
        return binary(left, right, ar, no);
    } else {
        left = mid;
        return binary(left, right, ar, no);
    }
}