public static int findNthInArray(int[] arr, int val, int start, int o) {
    if (o == 0) {
        return start - 1;
    } else if (arr[start] == val) {
        return findNthInArray(arr, val, start + 1, o - 1);
    } else {
        return findNthInArray(arr, val, start + 1, o);
    }
}