package com.step.matrix;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest{
  private Matrix matrix1;
  private Matrix matrix2;
  private Matrix matrix3;

  @Before
  public void setUpMatrix() {
    int[][] numbers1 = {{1,2,3},{3,4,5},{1,2,3}};
    int[][] numbers2 = {{1,2,3},{3,4,5},{1,2,3}};
    int[][] numbers3 = {{1,2,3},{3,4,5}};
    this.matrix1 = new Matrix(numbers1);
    this.matrix2 = new Matrix(numbers2);
    this.matrix3 = new Matrix(numbers3);
  }

  @Test
  public void shouldAddTwoMatrices(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.add(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldGiveNullSumOfUnEqualLengthMatrices(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.add(this.matrix3);
    assertNull(actual);
  }

  @Test
  public void shouldGiveSubtractOfTwoMatrices(){
    int[][] numbers3 = {{0,0,0},{0,0,0},{0,0,0}};
    Matrix actual = this.matrix1.subtract(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldGiveNullSubtractOfUnEqualLengthMatrices(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.subtract(this.matrix3);
    assertNull(actual);
  }

  @Test
  public void shouldMultiplyTwoMatrices(){
    int[][] numbers3 = {{10,16,22},{20,32,44},{10,16,22}};
    Matrix actual = this.matrix1.multiply(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldGiveDeterminantOfMatrix() {
    assertEquals(0, this.matrix1.determinant());
  }
}