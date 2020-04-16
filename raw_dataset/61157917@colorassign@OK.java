public static void colorassign(int[] arr, int i, int[] max, int[] a, int[] b) {
    if (i == arr.length) {
        max[0] = Math.max(max[0], color(arr, a, b));
        return;
    }
    for (int j = 1; j <= 6; j++) {
        arr[i] = j;
        colorassign(arr, i + 1, max, a, b);
    }
}