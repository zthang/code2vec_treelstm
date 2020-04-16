	public static void solve(int node, Set<Integer> neighbors) {
		//System.out.println(node);
		for(int each: adjList.get(node)) {
			neighbors.add(each);
		}
		if(node != 1)
			solve(parent[node], neighbors);
	}