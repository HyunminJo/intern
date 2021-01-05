package kr.co.crewmate.ojt.start;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return String.valueOf(this.item);
        }
    }

    Node<T> node(int index) {
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException();
//        }
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<T>(head, e, tail);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }

    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Node<T> firstNode = node(index - 1);
            Node<T> thirdNode = firstNode.next;
            Node<T> newNode = new Node<T>(head, element, tail);
            firstNode.next = newNode;
            newNode.next = thirdNode;
            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public void addLast(T e) {
        add(size, e);
    }

    @Override
    public boolean add(T e) {
        addLast(e);
        return true;
    }

    private Object removeFirst() {
        Node<T> removeNode = head;
        head = removeNode.next;
        Object returnItem = removeNode.item;
        removeNode = null;
        size--;
        return returnItem;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeFirst();
        } else {
            Node<T> prevNode = node(index - 1);
            Node<T> removeNode = prevNode.next;
            prevNode.next = prevNode.next.next;
            Object returnNode = removeNode.item;
            if (removeNode == tail) {
                tail = prevNode;
            }
            removeNode = null;
            size--;

            return (T) returnNode;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {

        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (o.equals(temp.item)) {
                remove(i);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private T unlink(Node<T> i) {
        T element = i.item;
        Node<T> next = i.next;
        Node<T> prev = i.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            i.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            i.next = null;
        }
        i.item = null;
        size--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> temp = head;
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(temp.item)) {
                    return i;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o == temp.item) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> temp = tail;

        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if ((temp.item == null && o == null) || ((temp.item != null && o != null) && temp.item.equals(o))) {
                    return i;
                }
                temp = temp.prev;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (temp.item == null) {
                    return i;
                }
                temp = temp.prev;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] array = c.toArray();
        Node<T> node = head;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (!contains(array[i])) {
                    return false;
                }
            } else {
                if (!contains(array[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }

        Object[] compare = c.toArray();
        int numNew = compare.length;
        if (numNew == 0) {
            return false;
        }

        Node<T> prevNode, nextNode;
        if (index == size) {
            nextNode = null;
            prevNode = tail;
        } else {
            nextNode = node(index);
            prevNode = nextNode.prev;
        }

        for (Object obj : compare) {
            @SuppressWarnings("unchecked")
            T e = (T) obj;
            Node<T> newNode = new Node<>(prevNode, e, null);
            if (prevNode == null) {
                head = newNode;
            } else {
                prevNode.next = newNode;
            }
            prevNode = newNode;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size += numNew;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()) {
            if (c.contains(iter.next())) {
                iter.remove();
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] array = c.toArray();
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            flag = false;
            for (int j = 0; j < array.length; j++) {
                if (get(i).equals(array[j])) {
                    flag = true;
                }
            }
            if (!flag) {
                remove(i);
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        while (size > 0) {
            removeFirst();
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) node(index).item;
    }

    @Override
    public T set(int index, T element) {
        if ((index < 0 || index >= size) || (element == null)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = node(index);
        newNode.item = element;

        return (T) newNode.item;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> arrayNode = head;

        for (int i = 0; i < size; i++) {
            array[i] = arrayNode.item;
            arrayNode = arrayNode.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        Object[] array = new Object[size];
        Node<T> arrayNode = (Node<T>) head;

        if (a.length < size) {

            for (int i = 0; i < size; i++) {
                array[i] = arrayNode.item;
                arrayNode = arrayNode.next;
            }
            return (T[]) array;
        }
        System.arraycopy(arrayNode.item, 0, arrayNode.item, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new Iter();
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return new ListIter();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return new ListIter();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new MyArrayList<>();

        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex <= toIndex) {
            for (int i = fromIndex; i < toIndex; i++) {
                subList.add(node(i).item);
            }
            return subList;
        }
        return null;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node<T> temp = head;
        String str = "[";

        while (temp.next != null) {
            str += temp.item + ", ";
            temp = temp.next;
        }
        str += temp.item;
        return str + "]";
    }

    private class Iter implements Iterator<T> {
        int nextIndex = 0;
        int nowIndex = 1;

        Iter() {
        }

        @Override
        public boolean hasNext() {
            return nextIndex != size;
        }

        @Override
        public T next() {
            int i = nextIndex;
            if (i >= size) {
                throw new NoSuchElementException();
            }

            Node<T> temp = head;
            Object[] elementData = new Object[size];

            for (int j = 0; j < size; j++) {
                elementData[j] = temp.item;
                if (temp.next != null) {
                    temp = temp.next;
                }
            }

            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            nextIndex = i + 1;

            return (T) elementData[nowIndex = i];
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            try {
                MyLinkedList.this.remove(nowIndex);
                nextIndex = nowIndex;
                nowIndex = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class ListIter implements ListIterator<T> {
        private Node<T> currentNode; // 현재
        private Node<T> cursorNode; // 커서
        private int cursorIndex; // 커서 인덱스

        @Override
        public boolean hasNext() {
            return cursorIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentNode = cursorNode;
            cursorNode = cursorNode.next;
            cursorIndex++;

            return currentNode.item;
        }

        @Override
        public boolean hasPrevious() {
            return cursorIndex > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            currentNode = cursorNode;
            cursorNode = cursorNode.prev;
            if (cursorNode == null) {
                cursorNode = tail;
            }
            cursorIndex--;
            return currentNode.item;
        }

        @Override
        public int nextIndex() {
            return cursorIndex;
        }

        @Override
        public int previousIndex() {
            return cursorIndex - 1;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            if (currentNode == null) {
                throw new IllegalStateException();
            }
            Node<T> endNext = currentNode.next;
            MyLinkedList.this.remove(currentNode);
            if (cursorNode == currentNode) {
                cursorNode = endNext;
            } else {
                cursorIndex--;
            }
            currentNode = null;
        }

        @Override
        public void set(T e) {
            if (currentNode == null) {
                throw new IllegalStateException();
            }
            currentNode.item = e;
        }

        @Override
        public void add(T e) {
            MyLinkedList.this.add(e);
            cursorIndex++;
        }
    }
}
