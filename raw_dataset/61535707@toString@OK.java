public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("graph with ").append(n).append(" nodes ");
    int res = 0;
    for (int i = 0; i < n; i++) res += adjSize(i);
    stringBuilder.append(res / 2).append(" edges\n");
    for (int u = 0; u < n; u++) {
        for (int v : adj(u)) {
            if (u < v) {
                stringBuilder.append(u).append(" ").append(v).append("\n");
            }
        }
    }
    return stringBuilder.toString();
}