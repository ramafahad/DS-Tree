import javax.swing.tree.TreeNode;

public class BST<T> {
    BSTNode<T> root, current;

    /** Creates a new instance of BST */
    public BST() {
        root = current = null;
    }

    public boolean empty() {
        return root == null;
    }

    public boolean full() {
        return false;
    }

    public T retrieve() {
        return current.data;
    }

    public boolean findkey(String tkey) {
        BSTNode<T> p = root;
        while (p != null) {
            current = p;
            if (tkey.compareToIgnoreCase(p.key) == 0) {
                return true;
            } else if (tkey.compareToIgnoreCase(p.key) < 0) {
                p = p.left;
            } else {

                p = p.right;
            }
        }

        return false;

    }

    public boolean insert(String k, T val) {

        if (root == null) {
            current = root = new BSTNode<T>(k, val);
            return true;
        }

        BSTNode<T> p = current;

        if (findkey(k)) {
            current = p;
            return false;
        }

        BSTNode<T> tmp = new BSTNode<T>(k, val);

        if (((Contact) val).compareTo(current.key) < 0) {

            current.left = tmp;

        }

        else {
            current.right = tmp;
        }

        current = tmp;
        return true;

    }

    public boolean chickUnique(Contact tmp) {

        return chickUnique(tmp, root);
    }

    private boolean chickUnique(Contact tmp, BSTNode<T> n) {
        /*
         * if(n== null)
         * return false;
         * if(tmp.compareToPhone(((Contact)n.data))==0){
         * return true;
         * }
         * return chickUnique(tmp, n.left) || chickUnique(tmp, n.right);
         */
        // in order traversal
        if (n == null)
            return false;

        Boolean left = chickUnique(tmp, n.left);
        Boolean comN = false;

        if (tmp.compareToPhone(((Contact) n.data)) == 0)
            comN = true;

        Boolean right = chickUnique(tmp, n.right);
        return left || comN || right;

    }

    public boolean SearchPhone(String phone) {
        return SearchPhone_pri(root, phone);
    }

    private boolean SearchPhone_pri(BSTNode<T> p, String phone) {
        if (p == null)
            return false;
        if (((Contact) p.data).compareToPhone(phone) == 0) {
            current = p;
            return true;
        }

        return (SearchPhone_pri(p.left, phone) || SearchPhone_pri(p.right, phone));
    }

    public void SearchEmail(String email) {
        SearchEmail_pri(root, email);
    }

    private void SearchEmail_pri(BSTNode<T> p, String email) {
        if (p == null)
            return;

        if (((Contact) p.data).compareToEmail(email) == 0)
            System.out.println(p.data);

        SearchEmail_pri(p.left, email);
        SearchEmail_pri(p.right, email);
    }

    public void SearchAddress(String address) {
        SearchAddress_pri(root, address);
    }

    private void SearchAddress_pri(BSTNode<T> p, String address) {
        if (p == null)
            return;

        if (((Contact) p.data).compareToAddress(address) == 0)
            System.out.println(p.data);

        SearchAddress_pri(p.left, address);
        SearchAddress_pri(p.right, address);
    }

    public void SearchBirthday(String birthday) {
        SearchBirthday_pri(root, birthday);
    }

    private void SearchBirthday_pri(BSTNode<T> p, String birthday) {
        if (p == null)
            return;
        if (((Contact) p.data).compareToBirthday(birthday) == 0)
            System.out.println(p.data);

        SearchBirthday_pri(p.left, birthday);
        SearchBirthday_pri(p.right, birthday);
    }

    public void searchFirstName(String firstName) {
        searchFirstName_pri(root, firstName);
    }

    private void searchFirstName_pri(BSTNode<T> p, String firstName) {
        if (p == null)
            return;
        if (((Contact) p.data).compareFirstName(firstName) == 0)
            System.out.println(p.data);

        searchFirstName_pri(p.left, firstName);
        searchFirstName_pri(p.right, firstName);

    }

    public boolean remove_key(String tkey) {
        Boolean removed = false; /* new Boolean(false); */
        BSTNode<T> p;
        p = remove_aux(tkey, root, removed);
        current = root = p;
        return removed;
    }

    private BSTNode<T> remove_aux(String key, BSTNode<T> p, Boolean flag) {
        BSTNode<T> q, child = null;
        if (p == null)
            return null;
        if (key.compareTo(p.key) < 0) // Im not sure
            p.left = remove_aux(key, p.left, flag); // go left
        else if (key.compareTo(p.key) > 0) // Im not sure
            p.right = remove_aux(key, p.right, flag); // go right
        else { // key is found
            flag = true;
            if (p.left != null && p.right != null) { // two children
                q = find_min(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = remove_aux(q.key, p.right, flag);
            } else {
                if (p.right == null) // one child
                    child = p.left;
                else if (p.left == null) // one child
                    child = p.right;
                return child;
            }
        }
        return p;
    }

    private BSTNode<T> find_min(BSTNode<T> p) {
        if (p == null)
            return null;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public boolean update(String key, T data) {
        remove_key(current.key);
        return insert(key, data);
    }

}