	void fdfs(int a,int parent,long cost) {
		if(a == parent) {
			return;
		}
		visited[a] = true;
		ArrayList<Integer> t1 = new ArrayList();
		ArrayList<Long> t2 = new ArrayList();
		for(Integer key: adj[a].keySet()){
			if(cost == 0) {
				
					fdfs(key,a,adj[a].get(key));
				
			}else {
				long currcost = Math.min(cost, adj[a].get(key));
				cost = cost - currcost;
				long newW = adj[a].get(key) - currcost;
				
				if(cost == 0) {
					adj[parent].remove(a);
					t1.add(key);
					t2.add(newW);
					fdfs(key,a,newW);
					
				}
				if(newW == 0) {
					adj[parent].put(a,cost);
					t1.add(key);
					t2.add(0L);
				}
				if(adj[parent].containsKey(key)) {
					adj[parent].put(key,adj[parent].get(key) + currcost);
				}else {
					adj[parent].put(key,currcost);
				}
				if(adj[key].containsKey(parent)) {
					if(adj[key].get(parent) > adj[parent].get(key)) {
						adj[key].put(parent,adj[key].get(parent) - adj[parent].get(key));
						adj[parent].remove(key);
						
					}else {
						adj[parent].put(key,adj[parent].get(key) - adj[key].get(parent));
						adj[key].remove(parent);
						if(key == parent) {
							continue;
						}
						fdfs(key,parent,adj[parent].get(key));
					}
					
				}else {
					fdfs(key,parent,adj[parent].get(key));
				}
				
			}
		}
		for(int i = 0;i < t1.size();i++) {
			if(t2.get(i) != 0) {
				adj[a].put(t1.get(i),t2.get(i));
			}else {
				adj[a].remove(t1.get(i));
			}
		}
	}