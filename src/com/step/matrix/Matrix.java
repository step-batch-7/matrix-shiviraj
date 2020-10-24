package com.step.matrix;
import com.step.matrix.Array;

public class Matrix {
  private final Array[] matrix;
  private final int noOfRows;
  private final int noOfCols;

  public Matrix(int[][] other){
    this.noOfRows = other.length;
    this.matrix = new Array[this.noOfRows];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      this.matrix[rowNo] = new Array(other[rowNo]);;
    }
    this.noOfCols = this.row(0).length;
  }

  public static Matrix create(int[][] matrix){
    for(int rowNo = 0; rowNo < matrix.length; rowNo++){
      if(matrix[rowNo].length != matrix[0].length){
        return null;
      };
    }

    return new Matrix(matrix);
  }

  public Matrix add(Matrix other){
    if(!areDimentionsEqual(other)) return null;

    int[][] matrixSum;
    matrixSum = new int[this.noOfRows][this.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      for(int colNo = 0; colNo < this.noOfCols; colNo++){
        matrixSum[rowNo][colNo] = getElement(rowNo, colNo) + other.getElement(rowNo, colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix subtract(Matrix other){
    if(!areDimentionsEqual(other)) return null;

    int[][] matrixSum;
    matrixSum = new int[this.noOfRows][this.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      for(int colNo = 0; colNo < this.noOfCols; colNo++){
        matrixSum[rowNo][colNo] = getElement(rowNo, colNo) - other.getElement(rowNo, colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix multiply(Matrix other){
    if(other.noOfRows != this.noOfCols || other.noOfCols != this.noOfRows){
      return null;
    }

    int[][] matrixProduct;
    matrixProduct = new int[this.noOfRows][other.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      Array row = this.row(rowNo);
      for(int colNo = 0; colNo < this.noOfCols; colNo++){
        int result = 0;
        for(int index = 0; index < row.length; index++){
          result += row.getElement(index) * other.getElement(index, colNo);
        }
        matrixProduct[rowNo][colNo] = result;
      }
    }
    return new Matrix(matrixProduct);
  }

  public int determinant() {
    if (this.noOfRows == 1) return this.getElement(0, 0);

    if (this.noOfRows == 2) {
      return (
        (this.getElement(0, 0) * this.getElement(1, 1)) -
        (this.getElement(0, 1) * this.getElement(1, 0))
      );
    }

    int result = 0;

    for (int i = 0; i < this.noOfCols; i++) {
      Matrix temp = this.createSubMatrix(i);
      result += this.getElement(0, i) * Math.pow(-1, i) * temp.determinant();
    }
    return result;
  }

  private Array row(int index) {
    return this.matrix[index];
  }

  private int getElement(int rowNo, int colNo) {
    return this.row(rowNo).getElement(colNo);
  }

  private boolean areDimentionsEqual(Matrix other) {
    return (other.noOfRows == this.noOfRows) && (other.noOfCols == this.noOfCols);
  }

  private Matrix createSubMatrix(int bisectorRowNo) {
    int[][] temp = new int[this.noOfRows - 1][this.noOfCols - 1];

    for (int rowNo = 1; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfCols; colNo++) {
        int element = this.getElement(rowNo, colNo);
        if (colNo < bisectorRowNo) {
          temp[rowNo - 1][colNo] = element;
        }
        if (colNo > bisectorRowNo) {
          temp[rowNo - 1][colNo - 1] = element;
        }
      }
    }
    return new Matrix(temp);
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Matrix)) return false;

    Matrix otherMatrix = (Matrix)other;
    if(otherMatrix.noOfRows != this.noOfRows) return false;

    for(int index = 0; index < this.noOfRows; index++){
      Array otherRow = otherMatrix.row(index);
      Array row = this.matrix[index];
      if(!otherRow.equals(row)) return false;
    }

    return true;
  }

  @Override
  public String toString(){
    StringBuilder str = new StringBuilder("Matrix ");
    str.append("[\n");
    for(Array row : matrix){
      str.append("\t").append(row).append("\n");
    }
    str.append("]");
    return new String(str);
  }
}
