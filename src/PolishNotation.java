import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("/");
        operations.add("*");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (operations.contains(token)) {
                int b = numbers.remove(numbers.size() - 1);
                int a = numbers.remove(numbers.size() - 1);
                numbers.add(getResOperation(a, b, token));
            }
            else
                numbers.add(Integer.parseInt(token));

        }
        return numbers.remove(numbers.size() - 1);
    }
    public int getResOperation (int a, int b, String o) {
        switch (o) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }
}

