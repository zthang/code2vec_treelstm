public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] idx = new int[n];
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
        idx[i] = rand.nextInt();
    }
    int[] hash = new int[n];
    for (int i = 0; i < m; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        hash[x] ^= idx[y];
        hash[y] ^= idx[x];
    }
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
        if (hash[i] == 0) {
            out.println(-1);
            return;
        }
        set.add(hash[i]);
    }
    if (set.size() != 3) {
        out.println(-1);
    } else {
        int c = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : set) {
            map.put(i, c++);
        }
        for (int i = 0; i < n; i++) {
            out.print(map.get(hash[i]) + " ");
        }
    }
}