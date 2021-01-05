package kr.co.crewmate.ojt.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {

    /*
     * null 값을 저장할 수 있다. 값을 중복 저장할 수 없다. 값을 넣는 순서대로 저장한다. 그래서 값을 꺼낼 때도 넣은 순서대로 꺼낼 수
     * 있다. 값을 꺼낼 때 숫자 인덱스를 사용하여 꺼낸다.
     */

    private Object[] item = new Object[10];
    private int size = 0;

    @Override
    public boolean add(T arg0) {

        overSize(size);
        item[size] = arg0;
        size++;

        return true;
    }

    @Override
    public void add(int arg0, T arg1) {

        if (arg0 < 0 || arg0 > size) {
            throw new IndexOutOfBoundsException();
        }

        overSize(size);
        for (int i = size - 1; i >= arg0; i--) {
            item[i + 1] = item[i];
        }
        item[arg0] = arg1;
        size++;

    }

    @Override
    public boolean addAll(Collection<? extends T> arg0) {

//		Object[] array = arg0.toArray();
//		int newSize = array.length;
//		overSize(size);
//		System.arraycopy(array, 0, item, size, newSize);
//		size += newSize;
//		return newSize != 0;
        Iterator<? extends T> iterator = arg0.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;

    }

    @Override
    public boolean addAll(int arg0, Collection<? extends T> arg1) {

        if (arg0 < 0 || arg0 > size) {
            throw new IndexOutOfBoundsException();
        }
//		Object[] array = arg1.toArray();
//		int newSize = array.length;
//		int movedSize = size - arg0;
//		if (movedSize > 0) {
//			System.arraycopy(item, arg0, item, arg0 + newSize, movedSize);
//
//		}
//		System.arraycopy(array, 0, item, arg0, newSize);
//		size += newSize;
//		return newSize != 0;
        int i = 0;
        Iterator<? extends T> iterator = arg1.iterator();
        while (iterator.hasNext()) {
            add(arg0 + i, iterator.next());
            i++;
        }
        return true;

    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            item[i] = null;
        }
        size = 0;

    }

    @Override
    public boolean contains(Object arg0) {
        return indexOf(arg0) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {

//		Object[] arr = arg0.toArray();
//		for (int i = 0; i < arr.length; i++) {
//				if (arr[i] != null) {
//					if (!contains(arr[i])) {
//						return false;
//					}				
//				} else {
//					if (!contains(arr[i])) {
//						return false;
//					}
//				}
//			}
//		return true;
        Iterator<?> iterator = arg0.iterator();
        boolean Flag = true;
        while (iterator.hasNext()) {
            Flag = contains(iterator.next());
            if (!Flag)
                break;
        }
        return Flag;

    }

    @Override
    public T get(int arg0) {

        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) item[arg0];
    }

    @Override
    public int indexOf(Object arg0) {

        if (arg0 == null) {
            for (int i = 0; i < size; i++) {
                if (item[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arg0.equals(item[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    @Override
    public int lastIndexOf(Object arg0) {

        if (arg0 == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (item[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (arg0.equals(item[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<T> listIterator(int arg0) {
        if (arg0 > size || arg0 < 0)
            throw new IndexOutOfBoundsException();
        return new ListIter(arg0);

    }

    @Override
    public boolean remove(Object arg0) {

        int index = indexOf(arg0);

        if (index == -1) {
            return false;
        }
        remove(index);

        return true;
    }

    @Override
    public T remove(int arg0) {

        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object removed = item[arg0];

        for (int i = arg0 + 1; i <= size - 1; i++) {
            item[i - 1] = item[i];
        }
        size--;
        item[size] = null;

        return (T) removed;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {

//		Iterator<?> e = iterator();

        boolean modified = false;
        Iterator<?> e = iterator();
        while (e.hasNext()) {
            if (arg0.contains(e.next())) {
                e.remove();
                modified = true;
            }
        }
        return modified;

//		Object[] array = arg0.toArray();
//		boolean flag = false;
//
//		for (int i = 0; i < arg0.size(); i++) {
//			for (int j = 0; j < size; j++) {
//				if ((item[j].equals(array[i])) || arg0.contains(null)) {
//					for (int k = j; k < size - 1; k++) {
//						item[k] = item[k + 1];
//					}
//					size--;
//					j--;
//				}
//			}
//			flag = true;
//		}
//		return flag;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {

//		boolean flag = false;
//
//		for (int i = 0; i < size; i++) {
//			flag = false;
//			if (!arg0.contains(item[i])) {
//				remove(i);
//			}
//			flag = true;
//		}
//		for (int i = 0; i < size; i++) {
//
//			if (!arg0.contains(item[i])) {
//				remove(i);
//			}
//			flag = true;
//		}
//		return flag;

        for (int i = 0; i < size; i++) {
            boolean flag = arg0.contains(item[i]); // arg0에 있는 요소들과 현재 뽑은 요소가 동일한 것인지 확인
            if (!flag) {
                remove(i); // 요소를 제거하는 remove()메소드 실행
                i--;
            }
        }
        return true;

    }

    @Override
    public T set(int arg0, T arg1) {

        if ((arg0 < 0 || arg0 >= size) || (arg1 == null)) {
            throw new IndexOutOfBoundsException();
        }
        item[arg0] = arg1;
        return (T) item[arg0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> subList(int arg0, int arg1) {

        List<T> subList = new MyArrayList();

        if (arg0 < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + arg0);
        }
        if (arg1 > size) {
            throw new IndexOutOfBoundsException("toIndex = " + arg1);
        }
        if (arg0 > arg1) {
            throw new IllegalArgumentException("fromIndex(" + arg0 + ") > toIndex(" + arg1 + ")");
        }

        if (arg0 <= arg1) {
            for (int i = arg0; i < arg1; i++) {
                subList.add(get(i));
            }
            return subList;
        }
        return null;

    }

    @Override
    public Object[] toArray() {

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = item[i];
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {

        if (arg0.length < size) {
            Object[] array = new Object[size];

            for (int i = 0; i < size; i++) {
                array[i] = item[i];
            }
            return (T[]) array;
        }

        System.arraycopy(item, 0, arg0, 0, size);
        if (arg0.length > size) {
            arg0[size] = null;
        }
        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(item[i]);

            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    private void overSize(int size) {

        if (size >= item.length) {
            Object[] extendSize = new Object[item.length * 10];
            System.arraycopy(item, 0, extendSize, 0, item.length);
            this.item = extendSize;
        }

    }

    private class Iter implements Iterator<T> {
        int nextIndex; // 다음을 가리키는 변수
        int nowIndex = -1; // 현재 선택되어있는 커서의 위치 다음 nextIndex가 0이므로 0보다 작은 값으로 초기화

        Iter() {
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size; // size가 더 크다는 것은 다음 데이터가 있다는 의미
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {

            int i = nextIndex;

            if (i > size) {
                throw new NoSuchElementException();
            }
            nowIndex = i;

            return (T) item[nowIndex++];
        }

        public void remove() {

            if (nowIndex < 0) {
                throw new IllegalStateException();
            }

            try {
                MyArrayList.this.remove(nowIndex);
                nextIndex = nowIndex;
                nowIndex--;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @SuppressWarnings("unused")
    private class ListIter extends Iter implements ListIterator<T> {

        ListIter(int index) {
            nowIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return nowIndex > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T previous() {

            int i = nowIndex - 1;
            
            if (i < 0) {
                throw new NoSuchElementException();
            }
            
            nextIndex = i;
            return (T) item[nowIndex = i];
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void set(T e) {

            if (nowIndex < 0 || nowIndex >= size) {
                throw new IndexOutOfBoundsException();
            }
            MyArrayList.this.set(nowIndex, e);
        }

        @Override
        public void add(T e) {

            try {
                int i = nextIndex;
                MyArrayList.this.add(i, e);
                nextIndex = i + 1;
                nowIndex = -1;

            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }   
}