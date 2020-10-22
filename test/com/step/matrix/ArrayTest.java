package com.step.matrix;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayTest{
  @Test
  public void length(){
    int[] numbers = {1,2,3};
    Array array = new Array(numbers);
    assertEquals(3, array.length());
  }

  @Test
  public void getElelment(){
    int[] numbers = {1,2,3};
    Array array = new Array(numbers);
    assertEquals(3, array.getElelment(2));
  }

  @Test
  public void isEqualLength(){
    int[] numbers = {1,2,3};
    int[] numbers2 = {1,2,3};
    Array array = new Array(numbers);
    Array array2 = new Array(numbers2);
    assertEquals(true, array.isEqualLength(array2));
  }

  @Test
  public void shouldGiveFalseIsEqualLength(){
    int[] numbers = {1,2,3};
    int[] numbers2 = {1,2};
    Array array = new Array(numbers);
    Array array2 = new Array(numbers2);
    assertEquals(false, array.isEqualLength(array2));
  }

  @Test
  public void equals(){
    int[] numbers = {1,2,3};
    int[] numbers2 = {1,2,3};
    Array array = new Array(numbers);
    Array array2 = new Array(numbers2);
    assertEquals(true, array.equals(array2));
  }

  @Test
  public void shouldGiveFalseForTwoUnequalsArray(){
    int[] numbers = {1,2,3};
    int[] numbers2 = {1,2};
    Array array = new Array(numbers);
    Array array2 = new Array(numbers2);
    assertEquals(false, array.equals(array2));
  }

}