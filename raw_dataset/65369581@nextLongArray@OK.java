/**
 * Reads an array of long integers.
 * @return
 * @throws IOException
 */
public long[] nextLongArray(int n) throws IOException {
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
        arr[i] = nextLong();
    }
    return arr;
}