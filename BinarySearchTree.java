import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/*
二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; //根节点
    private int size;  //节点个数

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素e
    public void add(E e) {
        root = add(e, root);
    }
    //向以root为根的二分搜索树中添加元素e
    //并返回新的二分搜索树的根节点
    private Node add(E e, Node root) {
        if(root == null) {
            size++;
            return new Node(e);
        }

        if(e.compareTo(root.e) < 0)
            root.left = add(e, root.left);
        else if(e.compareTo(root.e) > 0)
            root.right = add(e, root.right);

        return root;
    }

    //查询元素e
    public boolean contains(E e) {
        return contains(e, root);
    }
    //查询e是否在以root为根的二分搜索树中
    private boolean contains(E e, Node root) {
        if(root == null)
            return false;

        if(e.compareTo(root.e) == 0)
            return true;
        else if(e.compareTo(root.e) < 0)
            return contains(e, root.left);
        else
            return contains(e, root.right);
    }

    //层序遍历————用队列实现
    public List<E> levelOrder() {
        List<E> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.remove();
            res.add(cur.e);
            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
        return res;
    }

    /*-------------------非递归方法的前、中、后序遍历---------------------*/

    //非递归方法的前序遍历
    public void preOrderNR() {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>(); //用栈记录下一个要遍历的节点
        stack.push(root);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //非递归方法的中序遍历
    public void inOrderNR() {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                System.out.println(cur.e);
                cur = cur.right;
            }
        }
    }

    //非递归方法的后序遍历
    public void postOrderNR() {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Stack<E> output = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            output.push(cur.e);
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }

        while(!output.isEmpty()) {
            System.out.println(output.pop());
        }
    }

    /*-------------------递归方法的前、中、后序遍历---------------------*/

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }
    //前序遍历以root为根的二叉树，递归方法
    private void preOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.e); //先操作根节点
        preOrder(root.left);        //再遍历左子树
        preOrder(root.right);       //再遍历右子树
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }
    //中序遍历以root为根的二叉树，递归方法
    private void inOrder(Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }
    //后序遍历以root为根的二叉树，递归方法
    private void postOrder(Node root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    @Override
    public String toString() {                   //以不同长度的字符串表示不同深度的节点
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node root, int depth, StringBuilder res) {
        if(root == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + root.e + "\n");
        generateBSTString(root.left, depth + 1, res);
        generateBSTString(root.right, depth + 1, res);
    }
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

}
