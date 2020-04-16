void sort(int[] a) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < a.length; i++) {
        pq.add(a[i]);
    }
    for (int i = 0; i < a.length; i++) {
        a[i] = pq.poll();
    }
}