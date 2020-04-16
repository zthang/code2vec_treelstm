		void solve(int testNumber, FastScanner s, PrintWriter out) {
			N = s.nextInt(); cost = s.next2DLongArray(3, N);
			deg = new int[N]; to = new int[N]; int k = N, u, v;
			while(--k > 0) { u = s.nextInt() - 1; v = s.nextInt() - 1;
				if(deg[u] == 2) { out.println(-1); return; }
				if(deg[v] == 2) { out.println(-1); return; }
				to[u] ^= v; to[v] ^= u; deg[u]++; deg[v]++;
				root = deg[u] == 1 ? u : deg[v] == 1 ? v : root;
			}
			
			long min = (long) Integer.MAX_VALUE * Integer.MAX_VALUE;
			int col[] = null, ccol[];
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					if(i != j) {
						ccol = new int[N];
						int x = i, y = j, z = 3 ^ x ^ y, w; v = root; u = 0;
						long price = cost[z][v]; ccol[v] = z + 1;
						do {
							w = to[v] ^ u; u = v; v = w;
							x = y; y = z; z = 3 ^ x ^ y;
							ccol[v] = z + 1;
							price += cost[z][v];
						} while(deg[v] != 1);
						if(price < min) {
							min = price; col = ccol;
						}
					}
			
			out.println(min);
			for(int i : col) out.print(i + " " );
		}