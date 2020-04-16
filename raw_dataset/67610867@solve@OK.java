static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        n = ni();
        Map<Long, Integer> freq = new HashMap<>();
        Map<Long, Integer> which = new HashMap<>();
        Map<Long, Integer> which2 = new HashMap<>();
        int[] ans = new int[n - 2];
        int[][] adj = new int[n + 1][2];
        int[][] a = new int[n - 2][3];
        for (int i = 2; i < n; ++i) {
            long x = ni(), y = ni(), z = ni();
            a[i - 2][0] = (int) x;
            a[i - 2][1] = (int) y;
            a[i - 2][2] = (int) z;
            long first = get(min(x, y), max(x, y));
            add(freq, first);
            long second = get(min(y, z), max(y, z));
            add(freq, second);
            long third = get(min(x, z), max(x, z));
            add(freq, third);
            if (which.get(first) == null) {
                which.put(first, i - 2);
            } else {
                which2.put(first, i - 2);
            }
            if (which.get(second) == null) {
                which.put(second, i - 2);
            } else {
                which2.put(second, i - 2);
            }
            if (which.get(third) == null) {
                which.put(third, i - 2);
            } else {
                which2.put(third, i - 2);
            }
        }
        int[] curr_edge_freq = new int[n - 2];
        int sx = -1, sy = -1;
        LinkedList<Integer> queue = new LinkedList<>();
        for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                decode(entry.getKey());
                sx = X;
                sy = Y;
                // pl("Edge : "+X+" "+Y);
                if (adj[X][0] == 0) {
                    adj[X][0] = Y;
                } else {
                    adj[X][1] = Y;
                }
                if (adj[Y][0] == 0) {
                    adj[Y][0] = X;
                } else {
                    adj[Y][1] = X;
                }
                int which_triplet = which.get(entry.getKey());
                ++curr_edge_freq[which_triplet];
                if (curr_edge_freq[which_triplet] == 2) {
                    queue.addLast(which_triplet);
                // pl("adding "+which_triplet);
                }
            }
        }
        // pl();
        // pl();
        sb.append(sx);
        sb.append(" ");
        sb.append(sy);
        sb.append(" ");
        for (int i = 0; i < n - 2; ++i) {
            int other = adj[sy][0] == sx ? adj[sy][1] : adj[sy][0];
            sx = sy;
            sy = other;
            sb.append(other);
            sb.append(" ");
        }
        sb.append("\n");
        int idx = 0;
        while (!queue.isEmpty()) {
            int x = queue.pollFirst();
            // pl("x : "+x);
            ans[idx++] = (x + 1);
            long first = get(min(a[x][0], a[x][1]), max(a[x][0], a[x][1]));
            long second = get(min(a[x][1], a[x][2]), max(a[x][1], a[x][2]));
            long third = get(min(a[x][0], a[x][2]), max(a[x][0], a[x][2]));
            remove(freq, first);
            remove(freq, second);
            remove(freq, third);
            if (freq.get(first).equals(1)) {
                int other = which.get(first) == x ? which2.get(first) : which.get(first);
                ++curr_edge_freq[other];
                if (curr_edge_freq[other] == 2) {
                    queue.add(other);
                // pl("adding "+other);
                }
            }
            if (freq.get(second).equals(1)) {
                int other = which.get(second) == x ? which2.get(second) : which.get(second);
                ++curr_edge_freq[other];
                if (curr_edge_freq[other] == 2) {
                    queue.add(other);
                // pl("adding "+other);
                }
            }
            if (freq.get(third).equals(1)) {
                int other = which.get(third) == x ? which2.get(third) : which.get(third);
                ++curr_edge_freq[other];
                if (curr_edge_freq[other] == 2) {
                    queue.add(other);
                // pl("adding "+other);
                }
            }
        }
        for (int e : ans) {
            sb.append(e);
            sb.append(" ");
        }
        sb.append("\n");
    }
    psb(sb);
    pw.flush();
    pw.close();
}