public class BST <T> {
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
public T retrieve () {
return current.data;
}




    public boolean findkey(String tkey) {
        BSTNode<T> p = root;
        while (p!= null) {
            current=p;
            if(tkey.compareToIgnoreCase(p.key)==0){
                return true;
            }
            else if(tkey.compareToIgnoreCase(p.key)<0){
            p=p.left;
            }
            else{

                p=p.right;
            }  
        }

        return false;
    
    }



    public boolean insert(String  k, T val) {

        if(root==null){
        current=root=new BSTNode<T>(k, val);
        return true;
        }

        BSTNode<T> p = current;

        if(findkey(k)){
            current=p;
            return false;
        }

        BSTNode<T> tmp =new BSTNode<T>(k, val);

        if(((Contact)val).compareTo(current.key)<0){

            current.left=tmp;

        }

        else{
            current.right=tmp;
        }

        current=tmp;
        return true;
  
    }





    
    public boolean chickUnique( Contact tmp) {

        BSTNode<T> p = root;
        while (p!= null) {
            if(tmp.compareToPhone(((Contact)p.data))==0){
                return false;
            }
            else if(tmp.compareToPhone(((Contact)p.data))<0){
            p=p.left;
            }
            else{

                p=p.right;
            }  
        }

        return true;
    
    }










    public boolean remove_key (String tkey){
        Boolean removed = false; /*new Boolean(false); */
        BSTNode<T> p;
        p = remove_aux(tkey, root, removed);
        current = root = p;
        return removed;
    }



    private BSTNode<T> remove_aux(String key, BSTNode<T> p,Boolean flag) {
        BSTNode<T> q, child = null;
        if(p == null) return null;
        if(key.compareTo(p.key)<0 ) // Im not sure
        p.left = remove_aux(key, p.left, flag); //go left
        else if(key.compareTo(p.key)>0) // Im not sure
        p.right = remove_aux(key, p.right, flag); //go right
        else { // key is found
        flag=true;
        if (p.left != null && p.right != null){ //two children
        q = find_min(p.right);
        p.key = q.key;
        p.data = q.data;
        p.right = remove_aux(q.key, p.right, flag);
        } else {
        if (p.right == null) //one child
        child = p.left;
        else if (p.left == null) //one child
        child = p.right;
        return child;
        }
        }
        return p;
        }



        private BSTNode<T> find_min(BSTNode<T> p){
            if(p == null)
            return null;
            while(p.left != null){
            p = p.left;
            }
            return p;
            }






            public boolean update(String key, T data){
                remove_key(current.key);
                return insert(key, data);
            }






                






}