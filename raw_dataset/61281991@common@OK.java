static int common(ArrayList[] gp, int a, int b) {
    int ans = 0;
    for (int i = 0; i < gp[a].size(); i++) {
        if (gp[b].contains(gp[a].get(i)))
            ans++;
    }
    return ans;
}