public class BSTNode <T> {
public int key;
public T data;
public BSTNode<T> left, right;
/** Creates a new instance of BSTNode */
public BSTNode(int k, T val) {
key = k;
data = val;
left = right = null;
}
public BSTNode(int k, T val, BSTNode<T> l, BSTNode<T> r) {
key = k;
data = val;
left = l;
right = r;
}
}



