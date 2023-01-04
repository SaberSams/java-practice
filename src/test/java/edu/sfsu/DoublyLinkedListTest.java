package edu.sfsu;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.sfsu.DoubleLinkedList.Node;

public class DoublyLinkedListTest {

  @Test
  public void constructorTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertEquals(0, list.size());
  }

  @Test
  public void addTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.add("A");
    assertEquals(1, list.size());
    assertEquals("[A]", list.toString());
  }

  @Test
  public void addAllTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertEquals(3, list.size());
    assertEquals("[A, B, C]", list.toString());
  }

  @Test
  public void addAllTest2() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    list.addAll(Arrays.asList("D", "E", "F"));
    assertEquals(6, list.size());
    assertEquals("[A, B, C, D, E, F]", list.toString());
  }

  @Test
  public void clearTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    list.clear();
    assertEquals(0, list.size());
    assertEquals("[]", list.toString());
  }

  @Test
  public void containsTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertTrue(list.contains("A"));
    assertTrue(list.contains("B"));
    assertTrue(list.contains("C"));
    assertFalse(list.contains("D"));
  }

  @Test
  public void containsAllTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertTrue(list.containsAll(Arrays.asList("A", "B", "C")));
    assertFalse(list.containsAll(Arrays.asList("A", "B", "C", "D")));
  }

  @Test
  public void isEmptyTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertTrue(list.isEmpty());
    list.add("A");
    assertFalse(list.isEmpty());
  }

  @Test
  public void removeTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertTrue(list.remove("B"));
    assertEquals(2, list.size());
    assertEquals("[A, C]", list.toString());
  }

  @Test
  public void removeAllTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertTrue(list.removeAll(Arrays.asList("A", "B")));
    assertEquals(1, list.size());
    assertEquals("[C]", list.toString());
  }

  @Test
  public void retainAllTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    assertTrue(list.retainAll(Arrays.asList("A", "B")));
    assertEquals(2, list.size());
    assertEquals("[A, B]", list.toString());
  }

  @Test
  public void sizeTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertEquals(0, list.size());
    list.add("A");
    assertEquals(1, list.size());
    list.add("B");
    assertEquals(2, list.size());
    list.add("C");
    assertEquals(3, list.size());
  }

  @Test
  public void toArrayTest() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addAll(Arrays.asList("A", "B", "C"));
    Object[] array = list.toArray();
    assertEquals(3, array.length);
    assertEquals("A", array[0]);
    assertEquals("B", array[1]);
    assertEquals("C", array[2]);
  }

}
