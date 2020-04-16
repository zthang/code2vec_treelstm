public void shuffle(int[] arr) {
    for (int i = arr.length; i > 0; --i) {
        int r = (int) (Math.random() * i);
        int temp = arr[i - 1];
        arr[i - 1] = arr[r];
        arr[r] = temp;
    }
}