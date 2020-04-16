    public void go() throws IOException
    {
        ntok();
        int n = ipar();
        int k = ipar();
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++)
        {
            vertices[i] = new Vertex(i);
        }
        int[] arr = new int[n];
        ntok();
        for (int i = 0; i < n; i++)
        {
            int u = ipar()-1;
            arr[i] = u;
            vertices[i].add(vertices[u]);
        }
        ntok();
        for (int i = 0; i < n; i++)
        {
            int u = ipar()-1;
            vertices[i].add(vertices[u]);
        }
        ArrayDeque<Vertex> order = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (Vertex v : vertices)
        {
            dfs(v, visited, order, false, 0);
        }
        Arrays.fill(visited, false);
        int comp = 0;
        for (Vertex v : order)
        {
            if (!visited[v.index])
            {
                dfs(v, visited, order, true, comp);
                comp++;
            }
        }
        if (comp >= k)
        {
            out.println("YES");
            HashMap<Integer, Character> map = new HashMap<>();
            char c = 'a';
            for (Vertex v : order)
            {
                if (!map.containsKey(v.comp))
                {
                    map.put(v.comp, c);
                    c = (char)Math.min(c+1, 'z');
                }
            }
            for (Vertex v : vertices)
            {
                out.print(map.get(v.comp));
            }
            out.println();
        }
        else
        {
            out.println("NO");
        }

        out.flush();
        in.close();
    }