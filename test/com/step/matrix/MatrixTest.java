package com.step.matrix;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void shouldAddTwoMatrices(){
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix matrix1 = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix expected = new Matrix(new int[][]{{2,4,6},{6,8,10},{2,4,6}});
    assertEquals(expected, matrix.add(matrix1));
  }

  @Test
  public void shouldGiveNullSumOfUnEqualLengthMatrices(){
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix matrix1 = new Matrix(new int[][] {{1,2,3},{3,4,5}});
    assertEquals(null, matrix.add(matrix1));
  }

  @Test
  public void shouldGiveSubtractOfTwoMatrices(){
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix matrix1 = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix expected = new Matrix(new int[][]{{0,0,0},{0,0,0},{0,0,0}});
    assertEquals(expected, matrix.subtract(matrix1));
  }

  @Test
  public void shouldGiveNullSubtractOfUnEqualLengthMatrices(){
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix matrix1 = new Matrix(new int[][] {{1,2,3},{3,4,5}});
    assertEquals(null, matrix.subtract(matrix1));
  }

  @Test
  public void shouldMultiplyTwoMatrices(){
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix matrix1 = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    Matrix expected = new Matrix(new int[][]{{10,16,22},{20,32,44},{10,16,22}});
    assertEquals(expected, matrix.multiply(matrix1));
  }

  @Test
  public void shouldGiveDeterminantOfMatrix() {
    Matrix matrix = new Matrix(new int[][] {{1,2,3},{3,4,5},{1,2,3}});
    assertEquals(0, matrix.determinant());
  }
}