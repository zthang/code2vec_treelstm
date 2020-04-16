		void solve(int testNumber, FastScanner s, PrintWriter out) {
			N = s.nextInt(); M = s.nextInt(); K = s.nextInt(); Q = s.nextInt();
			Arrays.setAll(adj = new ArrayList[N], x -> new ArrayList<>());
			for(int m = 0, u, v, w; m < M; m++) {
				u = s.nextInt() - 1; v = s.nextInt() - 1; w = s.nextInt();
				adj[u].add(new int[] { v, w }); adj[v].add(new int[] { u, w });
			}
			
			Arrays.setAll(dist = new HashMap[N], x -> new HashMap<>());
			unions = new int[N - 1][2]; limits = new long[N - 1]; IDX = 0;
			PriorityQueue<State> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
			DSU = new DisjointSet(K);
			for (int i = 0; i < K; i++) { q.add(new State(i, i, 0)); dist[i].put(i, 0L); } 
			
			State cur; long cdist, ndist, dto; int to, root, vtx, vroot;
			while(IDX < K - 1) {
				cur = q.poll(); root = DSU.find(cur.origin);
				cdist = dist[root].get(vtx = cur.vtx);
				if(cur.dist != cdist) continue; // is this state outdated?
				
				if(vtx < K && vtx != cur.origin) { // we hit another station
					if(root == (vroot = DSU.find(vtx))) continue; // same group
					// CRITICAL JOIN!
					unions[IDX][0] = root; unions[IDX][1] = vroot; limits[IDX++] = cdist;
					DSU.union(cur.origin, vtx);
					continue; // the station at vtx has already searched neighbors
				}
				
				for(int e[] : adj[vtx]) { // search neighbors
					to = e[0]; dto = cdist + e[1];
					ndist = dist[root].getOrDefault(to, oo);
					if(dto < ndist) {
						dist[root].put(to, dto);
						q.add(new State(cur.origin, to, dto));
					}
				}
			}
			
			int[] qAns = new int[Q]; qq = new ArrayDeque[2][N]; Arrays.fill(qAns, N - 1);
			Arrays.setAll(qq[0], x -> new ArrayDeque<>());
			Arrays.setAll(qq[1], x -> new ArrayDeque<>());
			for(int i = 0, m = K - 1 >> 1; i < Q; i++) 
				qq[0][m].add(new Query(s.nextInt() - 1, s.nextInt() - 1, 0, K - 1, i));
			
			int done = 0, w = 0;
			while(done < Q) {
				// pass through disjoint set, update queries
				Arrays.fill(DSU.s, -1);
				for(int i = 0; i < unions.length; i++) {
					DSU.union(unions[i][0], unions[i][1]);
					// process queries at this time step
					while(!qq[w][i].isEmpty()) {
						Query curq = qq[w][i].poll();
						if(DSU.find(curq.a) == DSU.find(curq.b)) {
							// they've been joined by now 
							qAns[curq.qi] = i; curq.hi = curq.m - 1; curq.recalc();
						} else {
							// they've not been joined
							curq.lo = curq.m + 1; curq.recalc();
						}
						if(curq.lo > curq.hi) done++;
						else qq[w ^ 1][curq.m].add(curq);
					}
				}
				
				w ^= 1; // flip the queue we use
			}
			
			for(int x : qAns) out.println(limits[x]);
			
		}