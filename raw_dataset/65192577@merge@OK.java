public static void merge(TaskD.Node a, TaskD.Node b) {
    a = a.find();
    b = b.find();
    if (a == b) {
        return;
    }
    if (a.rank == b.rank) {
        a.rank++;
    }
    if (a.rank > b.rank) {
        b.p = a;
    } else {
        a.p = b;
    }
}