	static void dfs(int curr,int parent) {
//		System.out.println(curr + "  " + parent + " " + c[curr]);
		int add = c[curr];
		ret[curr] = set.get(add);
		set.remove(add);
		for(int next : tree[curr]) {
			if(next!=parent) {
				dfs(next,curr);
			}
		}
	}