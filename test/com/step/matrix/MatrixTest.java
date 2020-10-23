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
  public void addMatrix(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.add(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals("Should add two matrix", expected, actual);
  }

  @Test
  public void shouldNotCalculateSumOfUnEqual(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.add(this.matrix3);
    assertNull("Should not add two matrix", actual);
  }

  @Test
  public void subtractMatrix(){
    int[][] numbers3 = {{0,0,0},{0,0,0},{0,0,0}};
    Matrix actual = this.matrix1.subtract(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals("Should subtract one matrix from another matrix", expected, actual);
  }

  @Test
  public void shouldNotCalculateSubtractOfUnEqual(){
    int[][] numbers3 = {{2,4,6},{6,8,10},{2,4,6}};
    Matrix actual = this.matrix1.subtract(this.matrix3);
    assertNull("Should not add two matrix", actual);
  }

  @Test
  public void productMatrix(){
    int[][] numbers3 = {{10,16,22},{20,32,44},{10,16,22}};
    Matrix actual = this.matrix1.multiply(this.matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals("Should calculate the product of two matrix", expected, actual);
  }

  @Test
  public void shouldGiveDeterminantOfMatrix() {
    assertEquals("Should calculate the determinant of matrix", 0, this.matrix1.determinant());
  }
}