public void shuffle(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        int r = (int) (Math.random() * arr.length);
        if (i != r) {
            arr[i] ^= arr[r];
            arr[r] ^= arr[i];
            arr[i] ^= arr[r];
        }
    }
}