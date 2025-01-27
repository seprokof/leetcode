import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<List<String>> in1, double[] in2, List<List<String>> in3, double[] expected) {}

        TestCase[] tests = {
                new TestCase(List.of(List.of("a", "b"), List.of("b", "c")), new double[] { 2.0, 3.0 }, List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")), new double[] { 6.0, 0.5, -1.0, 1.0, -1.0 }),
                new TestCase(List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")), new double[] { 1.5, 2.5, 5.0 }, List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc")), new double[] { 3.75, 0.4, 5.0, 0.2 }),
                new TestCase(List.of(List.of("a", "b")), new double[] { 0.5 }, List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y")), new double[] { 0.5, 2.0, -1.0, -1.0 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double[] actual = s.calcEquation(test.in1, test.in2, test.in3);
            assert Arrays.equals(test.expected, actual) : "calcEquation(%s, %s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), test.in3, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    record Edge(String to, double weight) {
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            graph.computeIfAbsent(equation.get(0), (a) -> new HashSet<>()).add(new Edge(equation.get(1), values[i]));
            graph.computeIfAbsent(equation.get(1), (a) -> new HashSet<>())
                    .add(new Edge(equation.get(0), 1.0 / values[i]));
        }
        return queries.stream().mapToDouble(
                q -> evaluate(graph, q.get(0), q.get(1), new HashSet<>(), graph.containsKey(q.get(0)) ? 1.0 : -1.0))
                .toArray();
    }

    private double evaluate(Map<String, Set<Edge>> graph, String source, String destination, Set<String> visited,
            double val) {
        if (source.equals(destination)) {
            return val;
        }
        visited.add(source);
        for (Edge edge : graph.getOrDefault(source, Set.of())) {
            if (!visited.contains(edge.to)) {
                double result = evaluate(graph, edge.to, destination, visited, val * edge.weight);
                if (result > 0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

}