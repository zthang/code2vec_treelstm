public static int comp(ArrayList<Integer> o1, ArrayList<Integer> o2) {
    try {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            // 
            if (o1.get(i).compareTo(o2.get(i)) < 0)
                return -1;
            if (o1.get(i).compareTo(o2.get(i)) > 0)
                return 1;
        }
        return 0;
    } catch (Exception e) {
        while (true) ;
    }
}