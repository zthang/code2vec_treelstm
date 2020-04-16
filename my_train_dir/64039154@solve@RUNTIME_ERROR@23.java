		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t, i, j, tt, k;
			this.out = out;
			this.in = in;
			n = in.nextInt();
			ArrayList<Edge> ar = new ArrayList<>();
			int x[] = new int[n];
			int y[] = new int[n];
			long c[] = new long[n];
			long kk[] = new long[n];
			for (i = 0; i < n; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			for (i = 0; i < n; i++) {
				c[i] = in.nextInt();
			}
			for (i = 0; i < n; i++) {
				kk[i] = in.nextInt();
			}
			for (i = 0; i < n; i++) {
				for (j = i + 1; i < n; i++) {
					ar.add(new Edge(i + 1, j + 1, (kk[i] + kk[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]))));
				}
			}
			for (i = 0; i < n; i++) {
				ar.add(new Edge(0, i + 1, c[i]));
			}
			ArrayList<Integer> zz = new ArrayList<>();
			ArrayList<Edge> pa = new ArrayList<>();
			DisjointUnionSets dsu = new DisjointUnionSets(n + 1);
			Collections.sort(ar, com);
			long tot = 0;
			for (i = 0; i < ar.size(); i++) {
				Edge tp = ar.get(i);
				if (dsu.find(tp.u) != dsu.find(tp.v)) {
					tot += tp.cost;
					dsu.union(tp.u, tp.v);
					if (tp.u == 0) {
						zz.add(tp.v);
						continue;
					}
					if (tp.v == 0) {
						zz.add(tp.u);
						continue;
					}
					pa.add(new Edge(tp.u, tp.v, 0));
				}
			}
			pn(tot);
			pn(zz.size());
			for (Integer it : zz) {
				p(it);
			}
			pn("");
			pn(pa.size());
			for (Edge it : pa) {
				pn(it.u + " " + it.v);
			}
		}