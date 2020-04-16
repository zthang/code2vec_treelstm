public static Comparator<Integer[]> column(int i) {
    return new Comparator<Integer[]>() {

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            Integer quantityOne = o1[i];
            Integer quantityTwo = o2[i];
            return quantityOne.compareTo(quantityTwo);
        }
    };
}