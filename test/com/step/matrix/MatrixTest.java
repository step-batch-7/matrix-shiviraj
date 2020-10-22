package com.step.matrix;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void addMatrix(){
    int[][] numbers1 = {{1,2,3},{3,4,5}};
    int[][] numbers2 = {{1,2,3},{3,4,5}};
    int[][] numbers3 = {{2,4,6},{6,8,10}};
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    Matrix sumMatrix = matrix1.add(matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, sumMatrix);
  }

  @Test
  public void subtractMatrix(){
    int[][] numbers1 = {{10,12,15},{11,12,15}};
    int[][] numbers2 = {{1,2,3},{3,4,5}};
    int[][] numbers3 = {{9,10,12},{8,8,10}};
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    Matrix subMatrix = matrix1.subtract(matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, subMatrix);
  }

  @Test
  public void productMatrix(){
    int[][] numbers1 = {{1,2,3},{1,2,5}};
    int[][] numbers2 = {{1,2},{3,4},{2,4}};
    int[][] numbers3 = {{13,22},{17,30}};
    Matrix matrix1 = new Matrix(numbers1);
    Matrix matrix2 = new Matrix(numbers2);
    Matrix prodMatrix = matrix1.multiply(matrix2);
    Matrix expected = new Matrix(numbers3);
    assertEquals(expected, prodMatrix);
  }
}