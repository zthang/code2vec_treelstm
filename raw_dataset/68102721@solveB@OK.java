private void solveB() throws IOException {
    PriorityQueue<Integer> pq = new PriorityQueue<>(reverseOrder());
    for (int n = in.nextInt(); n-- > 0; ) pq.add(in.nextInt());
    int ans = 0;
    while (!pq.isEmpty()) {
        int x = pq.poll();
        while (!pq.isEmpty() && pq.peek() == x) pq.poll();
        if (x % 2 == 0) {
            ans++;
            pq.add(x / 2);
        }
    }
    out.println(ans);
}