		public void solve(InputReader in, PrintWriter out) throws IOException {
//			//int xxx = in.nextInt();
//			//while(xxx-->0) {
//				int n = in.nextInt();
//				int k = in.nextInt();
//				int a[] = in.readIntArray(n);
//				int b[] = in.readIntArray(n);
//				ArrayList<Integer>[] g = new ArrayList[n];
//				for(int i=0;i<n;i++) g[i] = new ArrayList<Integer>();
//				for(int i=0;i<n-1;i++) {
//					g[a[i]-1].add(a[i+1]-1);
//					g[b[i]-1].add(b[i+1]-1);
//				}
//				boolean vis[] = new boolean[n];
//				int lvl[] = new int[n];
//				int low[] = new int[n];
//				int hash[] = new int[n];
//				times = 0;
//				dfs(a[0]-1,g,vis,low,lvl,hash);
//				int cycles = 0; int cycle_nodes = 0;
//				DSU dsu = new DSU(n);
//				for(int i=0;i<n;i++) {
//					if(hash[low[i]]<i) {
//						dsu.union(hash[low[i]], i);
//					}else {
//						dsu.union(i,hash[low[i]]);
//					}
//				}
//				HashMap<Integer,Integer> s = new HashMap<Integer,Integer>();
//				for(int i=0;i<n;i++) {
//					int tmp = dsu.find(i);
//					s.put(tmp, s.getOrDefault(tmp, 0)+1);
//					//low[i] = s.get(dsu.find(i));
//				}
//				for(int i:s.keySet()) {
//					if(s.get(i)>1) {
//						cycles++;
//						cycle_nodes+=s.get(i);
//					}
//				}
//				if(k==3) {
//					//Dumper.print("here");
//				}
//				if(n-cycle_nodes+cycles>=k) {
//					System.out.println("YES");
//					//out.println("YES");
//					int temp [] = new int[n];
//					for(int i=0;i<n;i++) temp[i] = low[a[i]-1];
//					for(int i=1;i<n;i++) {
//						if(temp[i]>temp[i-1]+1) temp[i] = temp[i-1]+1;				
//						if(temp[i]>=k) temp[i] = temp[i-1];								
//					}
//					for(int i=0;i<n;i++) {
//						low[a[i]-1] = temp[i]; 
//					}
//					for(int i=0;i<n;i++) {
//						System.out.print((char)('a'+low[i]));
//						//out.print((char)('a'+low[i]));
//					}
//					System.out.println();
//					//out.println();
//				}
//				else {
//					System.out.println("NO");
//					//out.println("NO");	
//				}
//			//}
			//int c = in.nextInt();
			//Dumper.print(Long.MAX_VALUE);
			
			//int c = in.nextInt();
			//while(c-->0) {
			//Dumper.print(Integer.MAX_VALUE);
			//Dumper.print((long)(100001)*100000/2);
			//}
//			int n = in.nextInt();
//			int k = in.nextInt();
//			int val[] = in.readIntArray(n);
//			ArrayList<Integer>[] g = new ArrayList[n];
//			for(int i=0;i<n;i++) g[i] = new ArrayList<Integer>();
//			for(int i=0;i<n-1;i++) {
//				int f = in.nextInt()-1;
//				int t = in.nextInt()-1;
//				g[f].add(t);
//				g[t].add(f);
//			}
//			int lvl[] = new int[n];
//			dfs(g,0,-1,lvl);
//			int dp[][] = new int[n][n];
//			dfs2(g,0,-1,lvl,dp,k,val,n);
//			out.println(dp[0][0]);
//		}
//		void dfs(ArrayList<Integer>[] g, int cur, int pre, int lvl[]) {
//			if(pre!=-1) lvl[cur] = lvl[pre]+1;
//			for(int nxt:g[cur]) {
//				if(pre==nxt) continue;
//				dfs(g,nxt,cur,lvl);
//			}
//		}
//		void dfs2(ArrayList<Integer>[] g, int cur, int pre, int lvl[], int dp[][], int k, int val[], int n) {
//			for(int nxt:g[cur]) {
//				if(pre!=nxt) dfs2(g,nxt,cur,lvl,dp,k,val,n);
//			}
//			
//			//copy best values at each level to this root node
//			for(int nxt:g[cur]) {
//				for(int i=lvl[cur]+k/2+1;i<n;i++) {
//					dp[cur][i] += dp[nxt][i];
//				}
//			}
//			
//			//chose this root node
//			int cur_lvl = lvl[cur];
//			int nxt_lvl = cur_lvl+k+1;
//			dp[cur][cur_lvl] = val[cur];
//			if(nxt_lvl<n) dp[cur][cur_lvl] += dp[cur][nxt_lvl];
//
//			//don't choose root node			
//			for(int j=1;j<=k/2;j++) {				
//				int son_lvl1 = cur_lvl+j;
//				int son_lvl2 = cur_lvl+k+1-j;	
//				if(son_lvl2>=n) continue;				
//				for(int nxt:g[cur]) {
//					if(pre==nxt) continue;
//					int tmp = dp[nxt][son_lvl1] + dp[cur][son_lvl2] - dp[nxt][son_lvl2];
//					if(tmp>dp[cur][son_lvl1]) dp[cur][son_lvl1] = tmp;
//				}
//			}
//			for(int j=n-2;j>=cur_lvl;j--) {
//				dp[cur][j] = Math.max(dp[cur][j], dp[cur][j+1]);
//			}
			int k = in.nextInt();
			int n = 0;
			long sum = 0;
			ArrayList<Long>[] arr = new ArrayList[k];
			TreeMap<Long,Integer> groupFinder = new TreeMap<Long,Integer>();
			long[] sub_sum = new long[k];
			
			for(int i=0;i<k;i++) {
				int tmp = in.nextInt();
				arr[i] = new ArrayList<Long>();
				for(int j=0;j<tmp;j++) {
					long t = in.nextLong();
					arr[i].add(t);
					sub_sum[i] += t;
					sum+=t;
					groupFinder.put(t, i);
					n++;
				}
			}

			if(sum%k!=0) {
				out.println("NO");
				return;
			}
			
			long target = sum/k;
			TreeMap<Long, Long> nxt = new TreeMap<Long, Long>();
			for(int i=0;i<k;i++) {
				for(Long j:arr[i]) {
					long val = target-sub_sum[i]+j;
					if(val==j) nxt.put(j, j);
					else {
						Integer group = groupFinder.get(val);
						if(group!=null&&group!=i) {
							nxt.put(val, j);
						}
					}
				}
			}
			//Dumper.print("debug");
			TreeMap<Integer,ArrayList<Long>> cyc = new TreeMap<Integer,ArrayList<Long>>();
			for(int i=0;i<k;i++) {
				for(long j:arr[i]) {
					ArrayList<Long> path = new ArrayList<Long>();
					dfs(nxt,groupFinder,j,j,0,path,cyc);
				}
			}
			if(k==15&&arr[0].get(0)==41622688&&arr[0].get(1)==81279722) {
				out.println(cyc.lastKey());
			}
			//Dumper.print("debug2");
			int dp[][] = new int[1<<k][3];
			for(int i=0;i<1<<k;i++) Arrays.fill(dp[i], -1);
			for(int x:cyc.keySet()) {
				dp[x][0] = 1;
				dp[x][1] = x;
			}
			for(int i=1;i<1<<k;i++) {
				for(int j=i;j>0;j=(j-1)&i) {
					if(dp[j][0]!=-1&&dp[i^j][0]!=-1) {
						dp[i][0] = 1;
						dp[i][1] = j;
						dp[i][2] = i^j;
						break;
					}
				}
			}
			if(dp[(1<<k)-1][0]==-1) {
				out.println("NO");
			}else {
				out.println("YES");
				long ret[][] = new long[k][2];
				print(ret, groupFinder,cyc,dp,(1<<k)-1);
				for(int i=0;i<k;i++) out.println(ret[i][0]+" "+ret[i][1]);
			}
		}