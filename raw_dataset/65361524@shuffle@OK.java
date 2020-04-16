public static void shuffle(boolean[] arr, Random random) {
    for (int i = 0; i < arr.length - 1; i++) {
        swap(arr, i, i + random.nextInt(arr.length - i));
    }
}