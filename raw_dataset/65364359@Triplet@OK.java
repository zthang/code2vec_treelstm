public static Comparator<Long[]> Triplet() {
    return new Comparator<Long[]>() {

        @Override
        public int compare(Long[] o1, Long[] o2) {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0)
                result = o1[1].compareTo(o2[1]);
            if (result == 0)
                result = o1[2].compareTo(o2[2]);
            return result;
        }
    };
}