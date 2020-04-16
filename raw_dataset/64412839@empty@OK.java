public static SparseVector empty(int length, double sparseValue) {
    return new SparseVector(length, sparseValue) {

        public double get(int index) {
            return getSparseValue();
        }

        public void add(int index, double value) {
            this.length++;
        }

        public double remove(int index) {
            this.length--;
            return getSparseValue();
        }

        public double set(int index, double value) {
            throw new UnsupportedOperationException();
        }
    };
}