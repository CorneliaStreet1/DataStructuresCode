package srcNo21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class HuffmanTree<T> {
    public Node<T> createTree(List<Node<T>> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node<T> left = nodes.get(nodes.size() - 2);
            left.setCode(0 + "");
            Node<T> right = nodes.get(nodes.size() - 1);
            right.setCode(1 + "");
            Node<T> parent = new Node<T>(null, left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public List<Node<T>> breadth(Node<T> root) {
        List<Node<T>> list = new ArrayList<Node<T>>();
        Queue<Node<T>> queue = new ArrayDeque<Node<T>>();

        if (root != null) {
            queue.offer(root);
            root.getLeft().setCode(root.getCode() + "0");
            root.getRight().setCode(root.getCode() + "1");
        }

        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node<T> node = queue.poll();
            if (node.getLeft() != null)
                node.getLeft().setCode(node.getCode() + "0");
            if (node.getRight() != null)
                node.getRight().setCode(node.getCode() + "1");

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
        return list;
    }
}