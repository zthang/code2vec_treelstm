		static Answer dfs(int p, int at) {
		    Answer best = new Answer();
		    best.vertex = at;
		    best.val = metaWeight[at];
		    for(int i : metaGraph[at]) {
		        if(i == p) continue;
		        Answer get = dfs(at, i);
		        get.val += metaWeight[at];
		        if(get.val > best.val) {
		            best.val = get.val;
		            best.vertex = get.vertex;
		        }
		    }
		    return best;
		}