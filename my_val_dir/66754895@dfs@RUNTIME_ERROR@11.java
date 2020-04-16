    void dfs(int u) {
    	
    	if(completed[u]) return;
    	
    	boolean isEven = y[u] % 2 == 0;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i = 0; i<graph[u].size(); i++) {
    		int v = graph[u].get(i);
    		
    		dfs(v);
    		
    		if(isEven) {
    			min = Math.min(min, odd[v]);
    		}
    		else {
    			min = Math.min(min, even[v]);
    		}
    	}
    	
    	completed[u] = true;
    	
		if(isEven) {
			even[u] = 0;
			
			if(min == Integer.MAX_VALUE) {
				
				odd[u] = min;
			}
			else {
				
				odd[u] = min + 1;
			}
		}
		else {
			odd[u] = 0;
			
			if(min == Integer.MAX_VALUE) {
				
				even[u] = min;
			}
			else {
				
				even[u] = min + 1;
			}
		}
    }