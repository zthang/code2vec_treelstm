<T> void printColl(Collection<T> coll) throws IOException {
    for (T e : coll) {
        print(e + " ");
    }
    println();
}