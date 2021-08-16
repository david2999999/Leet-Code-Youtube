public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = createAdjacencyMap(n, edges);
        Queue<Integer> queue = new LinkedList<>();

        for (int node: map.keySet()) {
            if (map.get(node).size() == 1) queue.add(node);
        }

        while (map.size() > 2) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int neighbor: map.get(node)) {
                    map.get(neighbor).remove(node);

                    if (map.get(neighbor).size() == 1) queue.add(neighbor);
                }

                map.remove(node);
            }
        }

        return new ArrayList<>(map.keySet());
    }

    private Map<Integer, Set<Integer>> createAdjacencyMap(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int node = 0; node < n; node++) {
            map.put(node, new HashSet<>());
        }

        for (int[] e: edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        return map;
    }
}