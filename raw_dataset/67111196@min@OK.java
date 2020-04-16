static int min(int... arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) min = Math.min(min, arr[i]);
    return min;
}