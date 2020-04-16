public LongObjectEntryIterator<V> iterator() {
    return new LongObjectEntryIterator() {

        int index = 1;

        int readIndex = -1;

        public boolean hasNext() {
            while (index <= alloc && removed[index]) {
                index++;
            }
            return index <= alloc;
        }

        public long getEntryKey() {
            return keys[readIndex];
        }

        public Object getEntryValue() {
            return values[readIndex];
        }

        public void next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            readIndex = index;
            index++;
        }
    };
}