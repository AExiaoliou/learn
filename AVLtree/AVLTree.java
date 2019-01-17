import java.util.Comparator;
import java.util.EmptyStackException;

class AVLTree<T> {
    private Node<T> root;
    private Comparator<? super T> cmp;

    public AVLTree(Comparator<? super T> cmp) {
        root = null;
        this.cmp = cmp;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    final Node<T> getNode(T element) {
        if (cmp != null) {
            return getNodeUsingComparator(element);
        }
        if (element == null) {
            throw new NullPointerException();
        }
        @SuppressWarnings("unchecked")
        Comparable<? super T> e = (Comparable<? super T>) element;
        Node<T> p = root;
        while (p != null) {
            int compareResult = e.compareTo(p.element);
            if (compareResult > 0)
                p = p.right;
            else if (compareResult < 0)
                p = p.left;
            else
                return p;
        }
        return null;
    }

    final Node<T> getNodeUsingComparator(T element) {
        Node<T> p = root;
        while (p != null) {
            int compareResult = cmp.compare(element, p.element);
            if (compareResult > 0)
                p = p.right;
            else if (compareResult < 0)
                p = p.left;
            else
                return p;
        }
        return null;
    }

    private void deleteNode(Node<T> p) {
        if (p.hasTwoChild()) {
            Node<T> s = successor(p);
            p.element = s.element;
            p = s;
        }

        Node<T> replacement = p.notNullChild();
        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p.parent.left == p)
                p.parent.left = replacement;
            else
                p.parent.right = replacement;

            p.parent = p.left = p.right = null;
            //todo:fix
        } else if (p.parent == null) {
            root = null;
        } else {
            if (p == p.parent.left)
                p.parent.left = null;
            else if (p == p.parent.right)
                p.parent.right = null;
            p.parent = null;
        }

    }

    private Node<T> successor(Node<T> t) {
        if (t == null) {
            return null;
        } else if (t.right != null) {
            return findMin(t.right);
        } else {
            Node<T> p = t.parent;
            Node<T> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    public boolean contain(T element) {
        return contain(element, this.root);
    }

    private boolean contain(T element, Node<T> root) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (element == null) {
            return false;
        }
        Node<T> finder = root;
        int compareResult;
        while ((compareResult = cmp.compare(element, finder.element)) != 0) {
            finder = compareResult > 0 ? finder.right : finder.left;
            if (finder == null) {
                return false;
            }
        }
        return true;
    }

    public void insert(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            root = new Node<>(element);
        }
        Node<T> finder = root;
        int compareResult;
        while ((compareResult = cmp.compare(element, finder.element)) != 0) {
            if (!finder.hasChild()) {
                if (compareResult > 0) {
                    finder.right = new Node<>(element, finder);
                } else {
                    finder.left = new Node<>(element, finder);
                }
                break;
            }
            finder = compareResult > 0 ? finder.right : finder.left;
        }
        // If contain element, do nothing.
    }

    public T remove(T element) {
        Node<T> p = getNode(element);
        if (p == null)
            return null;

        T oldValue = p.element;
        deleteNode(p);
        return oldValue;
    }

    public T findMin() {
        return findMin(root).element;
    }

    public T findMax() {
        return findMax(root).element;
    }

    private Node<T> findMin(Node<T> root) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> finder = root;
        while (finder.left != null) {
            finder = finder.left;
        }
        return finder;
    }

    private Node<T> findMax(Node<T> root) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> finder = root;
        while (finder.right != null) {
            finder = finder.right;
        }
        return finder;
    }

    private int height(Node<T> t) {
        return t == null ? -1 : t.height;
    }

    private static class Node<T> {
        T element;
        Node<T> parent;
        Node<T> left;
        Node<T> right;
        int height;

        public Node(T element) {
            this(element, null, null, null);
        }

        public Node(T element, Node<T> parent) {
            this(element, null, null, parent);
        }

        public Node(T element, Node<T> left, Node<T> right, Node<T> parent) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
            height = 0;
        }

        public boolean hasChild() {
            return this.left != null || this.right != null;
        }

        public boolean hasTwoChild() {
            return this.left != null && this.right != null;
        }

        public Node<T> notNullChild() {
            return this.left != null ? this.left : this.right;
        }

    }
}
