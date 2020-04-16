static void recursion(int i) {
    for (int j = 1; j <= 6; j++) {
        arr[i] = j;
        if (i < n) {
            recursion(i + 1);
        } else {
            max = Math.max(max, check());
        }
    }
}