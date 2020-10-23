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
  public void length(){
    assertEquals("Should give the length of the array", 3, this.array.length);
  }

  @Test
  public void getElement(){
    assertEquals("Should give the element of given index", 3, this.array.getElement(2));
  }

  @Test
  public void equals(){
    int[] numbers = {1,2,3};
    Array array = new Array(numbers);
    assertTrue("Should give true for equal arrays", this.array.equals(array));
  }

  @Test
  public void shouldGiveFalseForTwoUnequalsArray(){
    int[] numbers = {1,2};
    Array array = new Array(numbers);
    assertFalse("Should give false for unequal array", this.array.equals(array));
  }

}