import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts;
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        parts = path.split("/");

        for (int i = 0; i < parts.length; i++) {
            if (!stack.isEmpty() && parts[i].equals("..")) {
                stack.pop();
            }
            if (!parts[i].equals("") && !parts[i].equals(".") && !parts[i].equals("..")) {
                stack.push(parts[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "//123//";
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(path));
    }
}
