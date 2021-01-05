package kr.co.crewmate.ojt.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyTreeMap<K, V> implements Map<K, V> {

    private Node<K, V> root;
    private int size = 0;

    static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {
        System.out.println(root.left.left.key);
        size = 0;
        root = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object arg0) {
        if (arg0 == null) {
            throw new NullPointerException();
        }
        @SuppressWarnings("unchecked")
        Comparable<? super K> cKey = (Comparable<? super K>) arg0;
        Node<K, V> temp = root;
        while (temp != null) {
            int index = cKey.compareTo(temp.key);
            if (index < 0) {
                temp = temp.left;
            } else if (index > 0) {
                temp = temp.right;
            } else {
                return temp.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K arg0, V arg1) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> cKey = (Comparable<? super K>) arg0;
        int index = 0;
        Node<K, V> temp = root;
        Node<K, V> parent;

        if (temp == null) { // 처음 값이 들어올 때
            root = new Node<K, V>(arg0, arg1);
            size++;
            return root.value;
        }
        if (arg0 == null) {
            throw new NullPointerException();
        } else {
            do {
                parent = temp;
                index = cKey.compareTo(temp.key);
                if (index < 0) {
                    temp = temp.left;
                } else if (index > 0) {
                    temp = temp.right;
                } else {
                    temp.value = arg1;
                    return temp.value;
                }
            } while (temp != null);
        }
        Node<K, V> endNode = new Node<>(arg0, arg1);
        endNode.parent = parent;
        if (index < 0) {
            parent.left = endNode;
        } else {
            parent.right = endNode;
        }
        size++;
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        for (K key : arg0.keySet()) {
            V value = arg0.get(key);
            for (int i = 0; i < arg0.size(); i++) {
                put(key, value);
            }
        }
    }

    @Override
    public V remove(Object arg0) {
        Comparable<Object> cKey = (Comparable<Object>) arg0;
        int index = 0;
        Node<K, V> temp = root;
        if (arg0 == null) {
            throw new NullPointerException();
        } else {
            while (temp != null) {
                if (cKey.compareTo(temp.key) == 0) {
                    // 양쪽 자손이 있을 때
                    if (temp.right != null && temp.left != null) {
                        Node<K, V> rightLast = temp.left;

                        // 양쪽 자손 있고 temp.left의 right가 없을때
                        if (rightLast.right == null) {
                            if (index > 0) {
                                temp.parent.left = rightLast;
                                unlink(temp, rightLast);                      
                            } else if (index < 0) {
                                temp.parent.right = rightLast;
                                unlink(temp, rightLast);
                            } else {
                                unlinkRoot(temp, rightLast);
                            }
                        } else {
                            // 양쪽 자손 있고 temp.left의 right가 있을 떄
                            while (rightLast.right != null) {
                                rightLast = rightLast.right;
                            }
                            if (index > 0) {
                                temp.parent.right = rightLast;    
                                unlinkLast(temp, rightLast);
                            } else if (index < 0) {
                                rightLast.parent.left = null;
                                unlinkLast(temp, rightLast);
                            } else {
                                rightLast.parent.right = null;
                                rightLast.left = temp.left;
                                temp.left.parent = rightLast;
                                unlinkRoot(temp, rightLast);
                            }
                        }
                        // 자손이 왼쪽만 있을 때
                    } else if (temp.left != null && temp.right == null) {
                        if (index > 0) {
                            temp.parent.right = temp.left;
                        } else if (index < 0) {
                            temp.parent.left = temp.left;
                        } else {
                            // root 인 경우
                            temp.left.parent = null;
                            root = temp.left;
                        }
                        // 자손이 오른쪽만 있을 때
                    } else if (temp.right != null && temp.left == null) {

                        if (index > 0) {
                            temp.parent.right = temp.right;
                        } else if (index < 0) {
                            temp.parent.left = temp.right;
                        } else {
                            temp.right.parent = null;
                            root = temp.right;
                        }
                        // 자손이 없을 때
                    } else {
                        if (index < 0) {
                            temp.parent.left = null;
                        } else if (index > 0) {
                            temp.parent.right = null;
                        } else {
                            temp = null;
                        }
                    }
                    size--;
                    if(size == 0) {
                        root = null;
                    }
                    return (V) temp;
                } else {
                    index = cKey.compareTo(temp.key);
                    if (index > 0) {
                        temp = temp.right;
                    } else {
                        temp = temp.left;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new TreeSet<K>();
        searchKey(set, root);
        return set;
    }

    private void searchKey(Set<K> set, Node<K, V> node) {
        if (node != null) {
            searchKey(set, node.left);
            set.add(node.key);
            searchKey(set, node.right);
        }
    }

    @Override
    public Collection<V> values() {
        Collection<V> col = new ArrayList<V>();
        searchVal(col, root);
        return col;
    }

    private void searchVal(Collection<V> col, Node<K, V> node) {
        if (node != null) {
            searchVal(col, node.left);
            col.add(node.value);
            searchVal(col, node.right);
        }
    }

    @Override
    public boolean containsKey(Object arg0) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> cKey = (Comparable<? super K>) arg0;
        Node<K, V> temp = root;
        while (temp != null) {
            int index = cKey.compareTo(temp.key);
            if (index < 0) {
                temp = temp.left;
            } else if (index > 0) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object arg0) {
        return searchValue(arg0, root);
    }

    private boolean searchValue(Object arg0, Node<K, V> node) {
        if (node == null) {
            return false;
        }
        if ((arg0 != null && arg0.equals(node.value)) || (arg0 == null && node.value == null)) {
            return true;
        }
        if (searchValue(arg0, node.left)) {
            return true;
        }
        if (searchValue(arg0, node.right)) {
            return true;
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }
    
    private void unlink(Node<K, V> temp, Node<K, V> rightLast) {
        rightLast.parent = temp.parent;
        rightLast.right = temp.right;
        temp.right.parent = rightLast;
    }
    
    private void unlinkLast(Node<K, V> temp, Node<K, V> rightLast) {
        temp.key = rightLast.key;
        temp.value = rightLast.value;
        rightLast.parent.right = null;
        unlink(temp, rightLast);
        rightLast.left = temp.left;
        temp.left.parent = rightLast;
    }
    
    private void unlinkRoot(Node<K, V> temp, Node<K, V> rightLast) {  
        rightLast.parent = null;
        rightLast.right = temp.right;
        temp.right.parent = rightLast;
        root = rightLast;
    }

    // inorder traversal, helper for toString
    void traverse(Node<K, V> node, StringBuilder sb) {
        if (node == null)
            return;
        traverse(node.left, sb);
        sb.append(node.key + "=" + node.value + ", ");
        traverse(node.right, sb);
    }

    // makes an in-order representation of the keys and their values
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            traverse(root, sb);
            return "{" + sb.substring(0, sb.lastIndexOf(",")) + "}";
        } else {
            return "{}";
        }
    }
}
