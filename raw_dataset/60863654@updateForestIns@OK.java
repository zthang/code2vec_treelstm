private void updateForestIns(int k, int x) {
    for (Node q = lvs[k].forest[x]; q != null; q = q.parent) q.desaux++;
}