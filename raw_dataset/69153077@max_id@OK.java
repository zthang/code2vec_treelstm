public static int max_id(int[] arr) {
    int res = -1000000000, id = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > res) {
            res = arr[i];
            id = i;
        }
    }
    return id;
}