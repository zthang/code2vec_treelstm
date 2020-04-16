public static void shuffle(int[] arr) {
    Random rgen = new Random();
    for (int i = 0; i < arr.length; i++) {
        int rPos = rgen.nextInt(arr.length);
        int temp = arr[i];
        arr[i] = arr[rPos];
        arr[rPos] = temp;
    }
}