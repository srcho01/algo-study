package week3.BOJ1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Seorim {

    static Map<String, String[]> tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new HashMap<String, String[]>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.put(st.nextToken(), new String[]{st.nextToken(), st.nextToken()});
        }

        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");

        System.out.println(sb);
    }

    private static void preorder(String node) {
        if (node.equals(".")) return;

        sb.append(node); // root
        preorder(tree.get(node)[0]); // left
        preorder(tree.get(node)[1]); // right
    }

    private static void inorder(String node) {
        if (node.equals(".")) return;

        inorder(tree.get(node)[0]); // left
        sb.append(node); // root
        inorder(tree.get(node)[1]); // right
    }

    private static void postorder(String node) {
        if (node.equals(".")) return;

        postorder(tree.get(node)[0]); // left
        postorder(tree.get(node)[1]); // right
        sb.append(node); // root
    }
}