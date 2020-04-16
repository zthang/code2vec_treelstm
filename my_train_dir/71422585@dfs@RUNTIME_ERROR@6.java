	public static void dfs(ArrayList[] graph,int start,int count,int[] visited,ArrayList<Integer> list,int[] crr) {
		visited[start]=1;
		list.add(start);
		for(int i=0;i<graph[start].size();i++) {
			int curr=(int)graph[start].get(i);
			if(visited[curr]==0) {
				
				count++;
				dfs(graph,curr,count,visited,list,crr);
			}
		}
		
		for(int i=0;i<list.size();i++)
		{
			crr[list.get(i)]++;
		}
		
		
		
	}