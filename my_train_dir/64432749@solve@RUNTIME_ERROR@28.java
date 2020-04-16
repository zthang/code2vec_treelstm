    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[][] g = GraphUtils.packUndirectedUnweighted(in.nextIntMatrix(m, 2), n);

      HashSet<Integer> unused = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        unused.add(i);
      }

      int ans = 0;
      int[] queue = new int[n + 1];
      int addPt = 0, pollPt = 0;
      for (int i = 1; i <= n; i++) {
        if (unused.remove(i)) {
          queue[addPt++] = i;
          while (pollPt < addPt) {
            int u = queue[pollPt++];

            HashSet<Integer> neighboors = new HashSet<>();
            for (int v : g[u]) {
              neighboors.add(v);
            }

            int cur = addPt;
            for (int v : unused) {
              if (!neighboors.contains(v)) {
                queue[addPt++] = v;
              }
            }
            for (int j = cur; j < addPt; j++) {
              unused.remove(queue[cur]);
            }
          }

          ++ans;
        }
      }

      out.println(ans - 1);
    }