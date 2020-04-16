public static int getMaxWhileDfs(int ci, boolean[] vis, ArrayList<Integer>[] grph) {
    int retval = ci;
    for (int i = 0; i < grph[ci].size(); i++) {
        if (!vis[grph[ci].get(i)]) {
            vis[grph[ci].get(i)] = true;
            retval = Math.max(retval, getMaxWhileDfs(grph[ci].get(i), vis, grph));
        }
    }
    return retval;
}