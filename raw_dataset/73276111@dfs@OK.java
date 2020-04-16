public boolean dfs(Node par, int depth) {
    this.par = par;
    this.depth = depth;
    hit = true;
    for (Node nn : adj) {
        if (!nn.hit)
            continue;
        int oDepth = nn.depth;
        int length = depth - oDepth + 1;
        if (length >= sqrt) {
            PrintWriter out = new PrintWriter(System.out);
            out.println(2);
            out.println(length);
            Node cur = this;
            while (cur != nn) {
                out.print(cur.id + 1 + " ");
                cur = cur.par;
            }
            out.println(nn.id + 1);
            out.close();
            return true;
        }
    }
    for (Node nn : adj) if (!nn.hit)
        if (nn.dfs(this, depth + 1))
            return true;
    return false;
}