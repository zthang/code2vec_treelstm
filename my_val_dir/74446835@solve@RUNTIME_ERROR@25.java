	void solve() {
		int n = scn.nextInt(), q = scn.nextInt();
		int[] from = new int[n - 1], to = new int[n - 1];
		for(int i = 0; i < n - 1; i++) {
			from[i] = scn.nextInt() - 1;
			to[i] = scn.nextInt() - 1;
		}
		
		int[][] g = packU(n, from, to);
		int[][] parents3 = parents3(g, 0);
		
		int[] par = parents3[0], depth = parents3[2];
		int[][] sparse = logstepParents(par);
		
		while(q-- > 0) {
			int m = scn.nextInt();
			if(m == 1) {
				out.println("YES");
				continue;
			}
			
			int[][] qr = new int[m][1];
			for(int i = 0; i < m; i++) {
				qr[i][0] = scn.nextInt() - 1;
				if(par[qr[i][0]] != -1) {
					qr[i][0] = par[qr[i][0]];
				}
			}
			
			Arrays.parallelSort(qr, (o1, o2) -> depth[o1[0]] - depth[o2[0]]);
			
			boolean yes = true;
			for(int i = m - 2; i >= 0; i--) {
				int u = qr[i][0], v = qr[i + 1][0];
				if(lca2(u, v, sparse, depth) != u) {
					yes = false;
					break;
				}
			}
			if(yes) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
	}