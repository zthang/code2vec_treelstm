static Item go(int at) {
    visited[at] = true;
    Item curr = new Item(at, at);
    for (int i : adj[at]) {
        if (!visited[i]) {
            Item next = go(i);
            curr.first = Math.min(next.first, curr.first);
            curr.second = Math.max(next.second, curr.second);
        }
    }
    return curr;
}