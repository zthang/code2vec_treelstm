public static void display(ArrayList<ArrayList<Integer>> al) {
    int i = 0;
    for (ArrayList<Integer> al1 : al) {
        System.out.println(i + " " + al1);
        i++;
    }
}