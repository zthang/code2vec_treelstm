public int[] nextSortedIntArray(int n) {
    int[] array = nextIntArray(n);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < n; i++) {
        pq.add(array[i]);
    }
    int[] out = new int[n];
    for (int i = 0; i < n; i++) {
        out[i] = pq.poll();
    }
    return out;
}