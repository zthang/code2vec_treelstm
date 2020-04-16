/*    public static void bfs(int num,int size)
            {
                boolean[] visited=new boolean[size+1];
                Queue<Integer> q=new LinkedList<>();
                q.add(num);
                ans[num]=1;
                visited[num]=true;
                while(!q.isEmpty())
                {
                    int x=q.poll();
                    ArrayList<Integer> al=graph.get(x);
                    for(int i=0;i<al.size();i++)
                    {
                        int y=al.get(i);    
                        if(visited[y]==false)
                        {
                            q.add(y);
                            ans[y]=ans[x]+1;
                            visited[y]=true;
                        }
                    }
                }
            }
            static int[] ans;*/
// static int[] a;
public static int[] sort(int[] a) {
    int n = a.length;
    ArrayList<Integer> ar = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
        ar.add(a[i]);
    }
    Collections.sort(ar);
    for (int i = 0; i < n; i++) {
        a[i] = ar.get(i);
    }
    return a;
}