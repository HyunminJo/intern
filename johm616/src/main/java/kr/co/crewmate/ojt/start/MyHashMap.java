package kr.co.crewmate.ojt.start;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] table = new Node[16];

    private int size;

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() % table.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public V get(Object arg0) {
        int index = hash(arg0);
        Node<K, V> temp = table[index];
        while (temp != null) {
            if ((temp.key == null && arg0 == null) || (temp.key != null && arg0 != null) && temp.key.equals(arg0)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if ((double) size / table.length > 0.7) {
            extendSize();
        }
        int index = hash(key);
        Node<K, V> newTab = new Node<>(key, value, null);
        Node<K, V> head = table[index];

        if (head == null) {
            table[index] = newTab;
        } else {
            while (head != null) {
                // 배열에 이미 있는 key 값과 동일한 key일 때
                if ((head.key == null && key == null) || (head.key != null && key != null) && head.key.equals(key)) {
                    V temp = head.value;
                    head.value = newTab.value;
                    return temp;
                } else {
                    if (head.next == null) {
                        head.next = newTab;
                    } else {
                        head = head.next;
                    }
                }
            }
        }
        size++;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        clear();
        size = arg0.size();
        for (K key : arg0.keySet()) {
            V value = arg0.get(key);
            for (int i = 0; i < arg0.size(); i++) {
                put(key, value);
            }
        }
    }

    @Override
    public V remove(Object arg0) {
        int index = hash(arg0);
        Node<K, V> node = table[index];
        Node<K, V> nextNode = null;
        if (table[index] == null) {
            return null;
        } else {
            while (node != null) {
                if ((node.key == null && arg0 == null)
                        || ((node.key != null && arg0 != null) && node.key.equals(arg0))) {
                    if (nextNode == null) {
                        table[index] = node.next;
                    } else if (node.next == null) {
                        nextNode.next = null;
                    } else {
                        nextNode.next = node.next;
                    }
                    size--;
                    return node.value;
                }
                nextNode = node;
                node = node.next;
            }
            return null;
        }
    }

    @Override
    public boolean containsKey(Object arg0) {
        int index = hash(arg0);
        Node<K, V> temp = table[index];
        if (table[index] != null) {
            for (int i = 0; i < table.length; i++) {
                if ((temp.key == null && arg0 == null)
                        || ((temp.key != null && arg0 != null) && temp.key.equals(arg0))) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object arg0) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Node<K, V> temp = table[i]; temp != null; temp = temp.next) {
                    if ((temp.value == null && arg0 == null)
                            || ((temp.value != null && arg0 != null) && temp.value.equals(arg0))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (Node<K, V> newTab : table) {
            while (newTab != null) {
                set.add(newTab.key);
                newTab = newTab.next;
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> col = new ArrayList<>();
        for (Node<K, V> newTab : table) {
            if (newTab != null) {
                do {
                    col.add(newTab.value);
                } while ((newTab = newTab.next) != null);
            }
        }
        return col;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = (Set<Entry<K, V>>) new HashSet<K>();

        for (Node<K, V> tab : table) {
            while (tab != null) {
                set.add(new AbstractMap.SimpleEntry<K, V>(tab.key, tab.value));
                tab = tab.next;
            }
        }
        return set;
    }

    private void extendSize() {
        Node<K, V>[] temp = table.clone();
        table = new Node[table.length * 3];
        size = 0;

        for (int i = 0; i < temp.length; i++) {
            Node<K, V> newTab = temp[i];
            while (newTab != null) {
                put(newTab.key, newTab.value);
                newTab = newTab.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Node<K, V> node : table) {
            while (node != null) {
                sb.append(node.key + "=" + node.value + ", ");
                node = node.next;
            }
        }
        return sb.substring(0, sb.lastIndexOf(",")) + "}";
    }
}
