private void rehash() {
    int[] newSlots = new int[Math.max(16, slot.length * 2)];
    int newMask = newSlots.length - 1;
    for (int i = 0; i < slot.length; i++) {
        if (slot[i] == 0) {
            continue;
        }
        int head = slot[i];
        while (head != 0) {
            int n = next[head];
            int s = hash(keys[head]) & newMask;
            next[head] = newSlots[s];
            newSlots[s] = head;
            head = n;
        }
    }
    this.slot = newSlots;
    this.mask = newMask;
}