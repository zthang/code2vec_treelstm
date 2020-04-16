static void populate(int u) {
    for (int v : friends[u]) populate(v);
    stack[st++] = ar[u];
}