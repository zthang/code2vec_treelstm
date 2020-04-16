void sort(int[] arr) {
    int sz = arr.length, j;
    Random r = new Random();
    for (int i = 0; i < sz; i++) {
        j = r.nextInt(i + 1);
        arr[i] = arr[j] ^ (arr[i] ^ (arr[j] = arr[i]));
    }
    Arrays.sort(arr);
}