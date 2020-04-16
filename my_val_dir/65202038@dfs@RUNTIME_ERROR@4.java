		static void dfs(int a,int b) {
			vis[a]=true;
			for(int x:arr.get(a)) {
				if(!vis[x]) {
					vis[x]=true;
					hm.get(b).x=Math.min(hm.get(b).x,Math.min(a, x));
					hm.get(b).y=Math.max(hm.get(b).y,Math.max(a, x));
					dfs(x,b);
				}
			}
		}