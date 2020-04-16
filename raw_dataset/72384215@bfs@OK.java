static void bfs(int[] arr, int ind, int n) {
    boolean[] vis = new boolean[n + 1];
    // Arrays.fill(arr,n+5);
    // arr[ind]=0;
    vis[ind] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(ind);
    while (!q.isEmpty()) {
        int x = q.poll();
        for (int i : incom.get(x)) {
            if (!vis[i]) {
                arr[i] = 1 + arr[x];
                q.add(i);
                vis[i] = true;
            }
        }
    }
}