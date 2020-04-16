public IntIterator intIterator() {
    return new IntIterator() {

        private int position = size == 0 ? values.length : -1;

        public int value() throws NoSuchElementException {
            if (position == -1) {
                advance();
            }
            if (position >= values.length) {
                throw new NoSuchElementException();
            }
            if ((present[position] & PRESENT_MASK) == 0) {
                throw new IllegalStateException();
            }
            return values[position];
        }

        public boolean advance() throws NoSuchElementException {
            if (position >= values.length) {
                throw new NoSuchElementException();
            }
            position++;
            while (position < values.length && (present[position] & PRESENT_MASK) == 0) {
                position++;
            }
            return isValid();
        }

        public boolean isValid() {
            return position < values.length;
        }

        public void remove() {
            if ((present[position] & PRESENT_MASK) == 0) {
                throw new IllegalStateException();
            }
            present[position] = REMOVED_MASK;
        }
    };
}