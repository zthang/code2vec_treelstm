public int[] nextIntArr(int n) throws IOException {
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) arr[i] = nextInt() - 1;
    return arr;
}