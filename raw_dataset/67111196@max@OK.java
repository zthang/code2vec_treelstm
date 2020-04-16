static int max(int... arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) max = Math.max(max, arr[i]);
    return max;
}