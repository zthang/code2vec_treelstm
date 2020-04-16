public static int max_element(int[] arr) {
    int res = -1000000000;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > res)
            res = arr[i];
    }
    return res;
}