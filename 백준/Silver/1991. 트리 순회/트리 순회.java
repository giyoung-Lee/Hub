import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// node 클래스
class Node {
    String data;
    String leftNode;
    String rightNode;
    // 데이터, 왼쪽 자식노드, 오른쪽 자식노드
    Node(String data, String leftNode, String rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}

public class Main {
    static Map<String, Node> tree = new HashMap<>();

    // 전위 순회
    static void preOrder(Node node) {
        // 먼저 출력하고
        System.out.print(node.data);
        // 왼쪽이 자식이 있으면
        if (!node.leftNode.equals(".")) {
            preOrder(tree.get(node.leftNode));
        }
        // 오른쪽 자식이 있으면
        if (!node.rightNode.equals(".")) {
            preOrder(tree.get(node.rightNode));
        }
    }

    static void inOrder(Node node) {
        // 왼쪽자식을 먼저 검사
        if (!node.leftNode.equals(".")) {
            inOrder(tree.get(node.leftNode));
        }
        // 전부 검사했다면 그때부터 재귀 빠져나오면서 출력
        System.out.print(node.data);
        
        // 다음은 오른쪽을 검사하는데, 가다가 왼쪽 자식 있으면 또 그거부터 출력
        if (!node.rightNode.equals(".")) {
            inOrder(tree.get(node.rightNode));
        }
    }

    static void postOrder(Node node) {
        // 왼쪽 노드가 있는지 최우선 적으로 검사
        if (!node.leftNode.equals(".")) {
            postOrder(tree.get(node.leftNode));
        }
        // 오른쪽 검사
        if (!node.rightNode.equals(".")) {
            postOrder(tree.get(node.rightNode));
        }
        // 길이 막히면 출력 하면서 재귀 빠져나옴
        System.out.print(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 데이터 입력받음
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            // 노드의 값
            String data = input[0];
            // 왼쪽 자식노드
            String leftNode = input[1];
            // 오른쪽 자식노드
            String rightNode = input[2];
            tree.put(data, new Node(data, leftNode, rightNode));
        }

        // 전위 순회
        preOrder(tree.get("A"));
        System.out.println();
        // 중위 순회
        inOrder(tree.get("A"));
        System.out.println();
        // 후위 순회
        postOrder(tree.get("A"));
    }
}