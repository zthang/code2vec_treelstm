public void addEdge(int vname1, int vname2, int cost) {
    vertex vtx1 = vtces.get(vname1);
    vertex vtx2 = vtces.get(vname2);
    vtx1.nbrs.put(vname2, cost);
    vtx2.nbrs.put(vname1, cost);
}