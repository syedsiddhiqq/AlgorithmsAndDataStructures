package LeetCode.Trees;

import java.util.Objects;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T val) {
        this.data = val;
    }

    BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }

    public static BinaryTreeNode newTree(Integer... vars) {
        return newTree(0, vars);
    }

    private static BinaryTreeNode newTree(int index, Integer... vars) {
        if (index >= vars.length || vars[index] == null) return null;

        BinaryTreeNode node = new BinaryTreeNode(vars[index]);
        node.left = newTree(2 * index + 1, vars);
        node.right = newTree(2 * index + 2, vars);

        return node;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "val=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return Objects.equals(data, that.data) && Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }
}
