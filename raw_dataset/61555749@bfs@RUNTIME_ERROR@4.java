	public static void bfs(int v, int[] dist){
		Queue<Integer> que = new ArrayDeque<Integer>();
		Arrays.fill(dist,-1);
		dist[v] = 0;
		que.add(v);
		while(!que.isEmpty()){
			int now = que.poll();
			for(Edge e : edges[now]){
				if(dist[e.to] == -1){
					dist[e.to] = dist[now]+1;
					que.add(e.to);
				}
			}
		}
	}