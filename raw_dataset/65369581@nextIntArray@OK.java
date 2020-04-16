/**
 * Reads an array of integers.
 * @return
 * @throws IOException
 */
public int[] nextIntArray(int n) throws IOException {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = nextInt();
    }
    return arr;
}