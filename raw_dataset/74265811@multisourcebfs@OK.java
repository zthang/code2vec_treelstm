static void multisourcebfs(long[] arr, int n, int m) {
    // HashSet<Long> vis=new HashSet<>();
    HashMap<Long, Long> dis = new HashMap<>();
    Queue<Long> q = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
        dis.put(arr[i], (long) 0);
        q.add(arr[i]);
    // vis.add(arr[i]);
    }
    long[] res = new long[m];
    long ans = 0;
    int k = 0;
    while (!q.isEmpty()) {
        if (k == m)
            break;
        long x = q.remove();
        if (dis.get(x) != 0) {
            ans += dis.get(x);
            res[k] = x;
            k++;
        }
        if (dis.get(x - 1) == null) {
            dis.put(x - 1, dis.get(x) + 1);
            q.add(x - 1);
        // vis.add(x-1);
        }
        if (dis.get(x + 1) == null) {
            dis.put(x + 1, dis.get(x) + 1);
            q.add(x + 1);
        // vis.add(x+1);
        }
    }
    System.out.println(ans);
    for (int i = 0; i < m; i++) System.out.print(res[i] + " ");
}