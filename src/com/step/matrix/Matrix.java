package com.step.matrix;
import com.step.matrix.Array;

public class Matrix {
  private Array[] matrix;
  private int noOfRows;
  private int noOfCols;

  public Matrix(int[][] other){
    this.matrix = new Array[other.length];
    for(int rowNo = 0; rowNo < other.length; rowNo++){
      Array row = new Array(other[rowNo]);
      this.matrix[rowNo] = row;
    }

    this.noOfRows = other.length;
    this.noOfCols = this.matrix[0].length;
  }

  private Array row(int index){
    return this.matrix[index];
  }

  private Array getRow(int index) {
    return this.matrix[index];
  }

  @Override
  public String toString(){
    StringBuilder str = new StringBuilder("Matrix ");
    str.append("[\n");
    for(Array row : matrix){
      str.append("\t" + row + "\n");
    }
    str.append("]");
    return new String(str);
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Matrix)) return false;

    Matrix otherMatrix = (Matrix)other;
    if(otherMatrix.noOfRows != this.noOfRows) return false;

    for(int index = 0; index < this.noOfRows; index++){
      Array otherRow = otherMatrix.getRow(index);
      Array row = this.matrix[index];
      if(!otherRow.equals(row)) return false;
    }

    return true;
  }

  public Matrix add(Matrix other){
    if(other.noOfRows != this.noOfRows || other.noOfCols != this.noOfCols){
      return null;
    }

    int[][] matrixSum;
    matrixSum = new int[this.noOfRows][this.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      Array row = this.row(rowNo);
      Array otherRow = other.row(rowNo);
      for(int colNo = 0; colNo < row.length; colNo++){
        matrixSum[rowNo][colNo] = row.getElement(colNo) + otherRow.getElement(colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix subtract(Matrix other){
    if(other.noOfRows != this.noOfRows || other.noOfCols != this.noOfCols){
      return null;
    }

    int[][] matrixSum;
    matrixSum = new int[this.noOfRows][this.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      Array row = this.row(rowNo);
      Array otherRow = other.row(rowNo);
      for(int colNo = 0; colNo < row.length; colNo++){
        matrixSum[rowNo][colNo] = row.getElement(colNo) - otherRow.getElement(colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix multiply(Matrix other){
    if(other.noOfRows != this.noOfCols || other.noOfCols != this.noOfRows){
      return null;
    }

    int[][] matrixSum;
    matrixSum = new int[this.noOfRows][this.noOfCols];

    for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
      Array row = this.row(rowNo);
      for(int colNo = 0; colNo < this.noOfCols; colNo++){
        int result = 0;
        for(int index = 0; index < row.length; index++){
          Array otherRow = other.row(index);
          result += row.getElement(index) * otherRow.getElement(colNo);
        }
        matrixSum[rowNo][colNo] = result;
      }
    }
    return new Matrix(matrixSum);
  }

  private Matrix createSubMatrix(int bisectorRowNo) {
    int[][] temp = new int[this.noOfRows - 1][this.noOfCols - 1];

    for (int rowNo = 1; rowNo < this.noOfRows; rowNo++) {
      Array row = this.row(rowNo);
      for (int colNo = 0; colNo < this.noOfCols; colNo++) {
        int element = row.getElement(colNo);
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

  public int determinant() {
    if (this.noOfRows == 1) {
      return this.row(0).getElement(0);
    }

    if (this.noOfRows == 2) {
      return (
        (this.row(0).getElement(0) * this.row(1).getElement(1)) -
        (this.row(0).getElement(1) * this.row(1).getElement(0))
      );
    }

    int result = 0;

    for (int i = 0; i < this.noOfCols; i++) {
      Matrix temp = this.createSubMatrix(i);
      result += this.row(0).getElement(i) * Math.pow(-1, i) * temp.determinant();
    }
    return result;
  }
}
