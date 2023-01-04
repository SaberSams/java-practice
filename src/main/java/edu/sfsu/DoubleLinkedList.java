package edu.sfsu;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class DoubleLinkedList<T> implements Deque<T> {

  protected class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    // Node Constructor
    public Node(T data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    public Node(Node<T> node){
      this.data = (T) node.data;
      this.next = node.next;
      this.prev = node.prev;
    }

    // Getters and Setters
    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public Node<T> getPrev() {
      return prev;
    }

    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }


  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  // DoublyLinkedList Constructor
  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public boolean add(T e) {
    addLast(e);
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> e) {
    for (T t : e) {
      addLast(t);
    }
    return true;
  }

  @Override
  public void addFirst(T e) {
    Node<T> newNode = new Node<T>(e);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  @Override
  public void addLast(T e) {
    Node<T> newNode = new Node<T>(e);
    if (head == null) {
      addFirst(e);
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }

  }

  @Override
  public boolean contains(Object e) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(e)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public Iterator<T> descendingIterator() {
    return new Iterator<T>() {
      Node<T> current = tail;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() throws java.util.NoSuchElementException {
        if (!hasNext()) {
          throw new java.util.NoSuchElementException();
        }
        T data = current.data;
        current = current.prev;
        return data;
      }
    };
  }

  @Override
  public T element() {
    return getFirst();
  }


  public T get() {
    return getFirst();
  }

  @Override
  public T getFirst() {
    return head.getData();
  }

  @Override
  public T getLast() {
    return tail.getData();
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() throws java.util.NoSuchElementException {
        if (!hasNext()) {
          throw new java.util.NoSuchElementException();
        }
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

  @Override
  public boolean offer(T e) {
    return offerLast(e);
  }

  @Override
  public boolean offerFirst(T e) {
    addFirst(e);
    return true;
  }

  @Override
  public boolean offerLast(T e) {
    addLast(e);
    return true;
  }

  @Override
  public T peek() {
    return peekFirst();
  }

  @Override
  public T peekFirst() {
    if (head == null) {
      return null;
    }
    return head.getData();
  }

  @Override
  public T peekLast() {
    if (tail == null) {
      return null;
    }
    return tail.getData();
  }

  @Override
  public T poll() {
    return pollFirst();
  }

  @Override
  public T pollFirst() {
    if (head == null) {
      return null;
    }
    T data = head.getData();
    head = head.next;
    if (head == null) {
      tail = null;
    } else {
      head.prev = null;
    }
    return data;
  }

  @Override
  public T pollLast() {
    if (tail == null) {
      return null;
    }
    T data = tail.getData();
    tail = tail.prev;
    if (tail == null) {
      head = null;
    } else {
      tail.next = null;
    }
    return data;
  }

  @Override
  public T pop() {
    return removeFirst();
  }

  @Override
  public void push(T e) {
    addFirst(e);
  }

  @Override
  public T remove() {
    return removeFirst();
  }

  @Override
  public boolean remove(Object e) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(e)) {
        if (current.prev == null) {
          head = current.next;
        } else {
          current.prev.next = current.next;
        }
        if (current.next == null) {
          tail = current.prev;
        } else {
          current.next.prev = current.prev;
        }
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public T removeFirst() {
    if (head == null) {
      throw new java.util.NoSuchElementException();
    }
    T data = head.getData();
    head = head.next;
    if (head == null) {
      tail = null;
    } else {
      head.prev = null;
    }
    return data;
  }

  @Override
  public boolean removeFirstOccurrence(Object e) {
    return remove(e);
  }

  @Override
  public T removeLast() {
    if (tail == null) {
      throw new java.util.NoSuchElementException();
    }
    T data = tail.getData();
    tail = tail.prev;
    if (tail == null) {
      head = null;
    } else {
      tail.next = null;
    }
    return data;
  }

  @Override
  public boolean removeLastOccurrence(Object e) {
    Node<T> current = tail;
    while (current != null) {
      if (current.data.equals(e)) {
        if (current.prev == null) {
          head = current.next;
        } else {
          current.prev.next = current.next;
        }
        if (current.next == null) {
          tail = current.prev;
        } else {
          current.next.prev = current.prev;
        }
        return true;
      }
      current = current.prev;
    }
    return false;
  }

  @Override
  public int size() {
    int size = 0;
    Node<T> current = head;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
  }

  @Override
  public boolean containsAll(Collection<?> e) {
    for (Object o : e) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public boolean removeAll(Collection<?> e) {
    boolean changed = false;
    for (Object o : e) {
      changed |= remove(o);
    }
    return changed;
  }

  @Override
  public boolean retainAll(Collection<?> e) {
    boolean changed = false;
    Node<T> current = head;
    while (current != null) {
      if (!e.contains(current.data)) {
        changed = true;
        if (current.prev == null) {
          head = current.next;
        } else {
          current.prev.next = current.next;
        }
        if (current.next == null) {
          tail = current.prev;
        } else {
          current.next.prev = current.prev;
        }
      }
      current = current.next;
    }
    return changed;
  }

  @Override
  public Object[] toArray() {
    Object[] array = new Object[size()];
    int i = 0;
    Node<T> current = head;
    while (current != null) {
      array[i++] = current.data;
      current = current.next;
    }
    return array;
  }

  @Override
  public <T> T[] toArray(T[] e) {
    return (T[]) toArray();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> current = head;
    while (current != null) {
      sb.append(current.data);
      if (current.next != null) {
        sb.append(", ");
      }
      current = current.next;
    }
    sb.append("]");
    return sb.toString();

  }

  public static void main(String[] args){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list);
  }
}
