		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int[] node = new int[n];
			for(int i=0;i<n;i++) {
				arr.add(new ArrayList<Integer>());
			}
			Set<Integer> nodes = new HashSet<Integer>();
			ArrayList<Integer> dd = new ArrayList<Integer>();
			int m = sc.nextInt();
			for(int i=0;i<m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr.get(a).add(b);
				arr.get(b).add(a);
				nodes.add(a);
				nodes.add(b);
			}
			for(int x : nodes) {
				dd.add(x);
			}
			Collections.sort(dd);
			vis=new boolean[n];
			int ct=0;
			for(int x : dd) {
				if(!vis[x]) {
					hm.put(ct,new pair(Integer.MAX_VALUE,0));
					dfs(x,ct++);
				}
			}
			ArrayList<pair> p = new ArrayList<pair>();
			for(pair x : hm.values()) {
				p.add(x);
			}
			Collections.sort(p);
			int r =0;
			for(int i=0;i<p.size()-1;i++) {
				if(p.get(i).y>p.get(i+1).x) {
					r++;
					p.get(i+1).y=Math.max(p.get(i+1).y, p.get(i).y);
					p.get(i+1).x=Math.min(p.get(i+1).x, p.get(i).x);
				}
			}
			pw.println(r);
			
		}