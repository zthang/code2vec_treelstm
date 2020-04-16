public static ArrayList<Integer>[] ALArrayI(int size) {
    ArrayList<Integer>[] l = new ArrayList[size];
    for (int i = 0; i < size; i++) l[i] = new ArrayList<>();
    return l;
}