public static void bfs(int x, int[] arr) {
    Queue<Integer> qrr = new ArrayDeque();
    qrr.add(x);
    arr[x] = 0;
    visit[x] = 1;
    while (!qrr.isEmpty()) {
        x = (int) qrr.poll();
        for (int y : adj[x]) {
            if (visit[y] == 0) {
                arr[y] = arr[x] + 1;
                // System.out.println(y+" "+arr[y]);
                visit[y] = 1;
                qrr.add(y);
            }
        }
    }
}