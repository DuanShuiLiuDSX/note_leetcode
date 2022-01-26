package com.company.train1;

/**
 * @author cz
 * @Description  eg1: 常规解法
 *               层序遍历 树  将树的每层节点入队
 *               在以此出队  并且连接每个节点
 *
 *               eg2： 递归解法
 *
 * @date 2021/12/23 14:48
 **/
public class No116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
//            if(root==null) return root;
//
//            Queue queue = new LinkedList<Node>();
//            queue.add(root);
//            while (!queue.isEmpty()){
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    Node node = (Node) queue.poll();
//
//                    if(i<size-1){
//                        node.next = (Node) queue.peek();
//                    }
//                    if (node.left!=null)
//                        queue.add(node.left);
//                    if (node.right!=null)
//                        queue.add(node.right);
//                }
//            }
//            return root;

            /**
             * 递归写法
             */
            if(root==null) return root;
            if(root.left!=null){
                root.left.next = root.right;
                root.right.next = root.next !=null ? root.next.left : null;
                connect(root.left);
                connect(root.right);
            }
            return root;
        }
    }
}
