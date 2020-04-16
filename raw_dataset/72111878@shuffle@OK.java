private static void shuffle(int[] arr) {
    for (int i = arr.length - 1; i >= 2; i--) {
        int x = new Random().nextInt(i - 1);
        int temp = arr[x];
        arr[x] = arr[i];
        arr[i] = temp;
    }
}