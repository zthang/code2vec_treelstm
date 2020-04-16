public static ArrayList<Long>[] ALArrayL(int size) {
    ArrayList<Long>[] l = new ArrayList[size];
    for (int i = 0; i < size; i++) l[i] = new ArrayList<>();
    return l;
}