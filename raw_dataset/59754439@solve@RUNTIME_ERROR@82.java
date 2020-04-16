	void solve() {
		int n = scn.nextInt(), k = scn.nextInt();
		int[] p1 = scn.nextIntArray(n);
		int[] p2 = scn.nextIntArray(n);

		for (int i = 0; i < n; i++) {
			p1[i]--;
			p2[i]--;
		}

		int[] from = new int[10 * n], to = new int[10 * n];
		int p = 0;

		for (int i = 0; i < n - 1; i++) {
			to[p] = p1[i];
			from[p] = p1[i + 1];
			p++;

			to[p] = p2[i];
			from[p] = p2[i + 1];
			p++;
		}
		from = Arrays.copyOf(from, p);
		to = Arrays.copyOf(to, p);

		int[][] g = packD(n, from, to);

		int[] clust = decomposeToSCC(g, packD(n, to, from));

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		HashMap<Integer, Integer> need = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(clust[i])) {
				map.put(clust[i], new ArrayList<>());
			}
			map.get(clust[i]).add(i);
			need.put(i, clust[i]);
			max = Math.max(max, clust[i]);
		}
		if (map.size() < k) {
			out.println("NO");
			return;
		}

		from = new int[10 * n];
		to = new int[10 * n];
		p = 0;

		for (int i = 0; i < n - 1; i++) {
			if (need.get(p1[i]) != need.get(p1[i + 1])) {
				to[p] = need.get(p1[i]);
				from[p] = need.get(p1[i + 1]);
				p++;
			}

			if (need.get(p2[i]) != need.get(p2[i + 1])) {
				to[p] = need.get(p2[i]);
				from[p] = need.get(p2[i + 1]);
				p++;
			}
		}
		from = Arrays.copyOf(from, p);
		to = Arrays.copyOf(to, p);

		char[] ans = new char[n];
		n = max + 1;

		g = packD(n, from, to);
		for (int i = 0; i < n; i++) {
			if (g[i].length > 0) {
				g[i] = scn.uniq(g[i]);
			}
		}
		int[] topo = sortTopologically(g);

		int[] lol = new int[n];
		HashSet<Character> set = new HashSet<Character>();

		for (int i = n - 1; i >= 0; i--) {
			int val = 0;
			for (int v : g[topo[i]]) {
				val = Math.max(val, lol[v]);
			}
			val = Math.min(val, 25);
			lol[topo[i]] = val + 1;
			
			for (int ind : map.get(i)) {
				ans[ind] = (char) (val + 'a');
				set.add(ans[ind]);
			}
		}

		if (set.size() < k) {
			out.println("NO");
		} else {
			out.println("YES");
			for (char c : ans) {
				out.print(c);
			}
			out.println();
		}
	}