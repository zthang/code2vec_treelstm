        private void dfs(TaskD.Node root, List<Integer> set) {
            root.a = set.remove(root.c);

            List<TaskD.Node> children = root.children;
            if (children.size() == 0) {
                return;
            } else if (children.size() == 1) {
                dfs(children.get(0), set);
            } else {
                int from = 0;
                for (TaskD.Node child : children) {
                    List<Integer> childSet = new ArrayList<>(child.power);
                    for (int i = 0; i < child.power; i++, from++) {
                        childSet.add(set.get(from));
                    }
                    dfs(child, childSet);
                }
            }
        }