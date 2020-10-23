package com.step.matrix;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest{
  private Array array;

  @Before
  public void setUpArray() {
    int[] numbers = {1,2,3};
    this.array = new Array(numbers);
  }

  @Test
  public void shouldGiveArrayLength(){
    assertEquals(3, this.array.length);
  }

  @Test
  public void shouldGiveElementOfGivenIndex(){
    assertEquals(3, this.array.getElement(2));
  }

  @Test
  public void shouldGiveTrueForEqualArrays(){
    int[] numbers = {1,2,3};
    Array array = new Array(numbers);
    assertTrue(this.array.equals(array));
  }

  @Test
  public void shouldGiveFalseForTwoUnequalsArray(){
    int[] numbers = {1,2};
    Array array = new Array(numbers);
    assertFalse(this.array.equals(array));
  }

}