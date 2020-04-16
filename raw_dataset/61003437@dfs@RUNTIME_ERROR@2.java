	private long[] dfs(int node,int pre, boolean[] vis) {
		if(vis[node]==true) return new long[] {1,-1};//1:find loop
		vis[node]=true;
		long[] ret=new long[] {0,w[node]};
		for(int nn:graph[node]) {
			if(nn!=pre) {
				long[] r=dfs(nn,node,vis);
				ret[0]|=r[0];
				ret[1]+=r[1];
			}
		}
		if(ret[0]==0) {
			max=Math.max(max, ret[1]);
		}else {
			sum+=w[node];
		}
		return ret;
	}