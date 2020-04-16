public static Comparator<Integer[]> pair() {
    return new Comparator<Integer[]>() {

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0)
                result = o1[1].compareTo(o2[1]);
            return result;
        }
    };
}