package com.step.matrix;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest{
  @Test
  public void shouldGiveArrayLength(){
    Array array = new Array(new int[]{1,2,3});
    assertEquals(3, array.length);
  }

  @Test
  public void shouldGiveElementOfGivenIndex(){
    Array array = new Array(new int[]{1,2,3});
    assertEquals(3, array.getElement(2));
  }

  @Test
  public void shouldGiveTrueForEqualArrays(){
    Array array = new Array(new int[]{1,2,3});
    Array array1 = new Array(new int[]{1,2,3});
    assertTrue(array.equals(array1));
  }

  @Test
  public void shouldGiveFalseForTwoUnequalsArray(){
    Array array = new Array(new int[]{1,2,3});
    Array array1 = new Array(new int[]{1,2});
    assertFalse(array.equals(array1));
  }

}