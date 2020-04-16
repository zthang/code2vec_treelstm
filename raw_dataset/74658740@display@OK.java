public void display() {
    System.out.println("-------------------------------");
    ArrayList<Integer> keys = new ArrayList<>(vtces.keySet());
    for (int key : keys) {
        vertex vtx = vtces.get(key);
        System.out.println(key + "-> " + vtx.nbrs);
    }
    System.out.println("-------------------------------------");
}