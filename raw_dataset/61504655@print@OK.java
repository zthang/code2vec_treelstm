public void print(ArrayList a, String separator) {
    for (int i = 0; i < a.size(); i++) {
        if (i == 0)
            print(a.get(i));
        else
            print(separator + a.get(i));
    }
    println();
}