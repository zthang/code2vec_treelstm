static void solve() throws IOException {
    int n = Reader.nextInt();
    parent = new int[2 * n + 1];
    for (int i = 0; i <= 2 * n; i++) {
        parent[i] = i;
    }
    int[] arr = new int[2 * n + 1];
    for (int i = 0; i < n; i++) {
        int l = Reader.nextInt();
        int r = Reader.nextInt();
        arr[l] = l;
        arr[r] = -l;
    }
    TreeSet<Integer> q = new TreeSet<>(Collections.reverseOrder());
    int edge = n;
    for (int i = 1; i <= 2 * n; i++) {
        if (arr[i] > 0) {
            q.add(arr[i]);
        } else {
            q.remove(-arr[i]);
            int cur = -arr[i];
            Iterator<Integer> ii = q.iterator();
            while (ii.hasNext()) {
                int next = ii.next();
                if (next > cur) {
                    if (merge(next, cur)) {
                        edge--;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
    if (edge == 1) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}