/**
 * static int bfs(int s)
 * 	{
 * 		Queue<Integer> q = new LinkedList<Integer>();
 * 		q.add(s);
 * 		int count=0;
 * 		int maxcost=0;
 * 		int dist[]=new int[n];
 * 		dist[s]=0;
 * 		while(!q.isEmpty())
 * 		{
 *
 * 			int u = q.remove();
 * 			if(dist[u]==k) {
 * 				break;
 * 			}
 * 			for(Pair v: adj[u])
 * 			{
 * 				maxcost=Math.max(maxcost, v.cost);
 *
 * 			if(!visited[v.v])	{
 *
 * 				visited[v.v]=true;
 * 				q.add(v.v);
 * 				dist[v.v]=dist[u]+1;
 * 				maxcost=Math.max(maxcost, v.cost);
 * 			}
 * 			}
 *
 * 		}
 * 		return maxcost;
 * 	}*
 */
public static boolean FindAllElements(int n, int k) {
    int sum = k;
    int[] A = new int[k];
    Arrays.fill(A, 0, k, 1);
    for (int i = k - 1; i >= 0; --i) {
        while (sum + A[i] <= n) {
            sum += A[i];
            A[i] *= 2;
        }
    }
    if (sum == n) {
        return true;
    } else
        return false;
}