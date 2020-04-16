public void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
        return;
    }
    if (size[a] > size[b]) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    LinkedList<Integer> membersofa = members.get(a);
    LinkedList<Integer> membersofb = members.get(b);
    for (int i = 0; i < size[a]; i++) {
        int member = membersofa.removeFirst();
        component[member] = component[b];
        membersofb.add(member);
    }
    size[b] = size[b] + size[a];
    noOfComponents--;
}