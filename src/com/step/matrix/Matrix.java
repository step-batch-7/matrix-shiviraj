package com.step.matrix;
import com.step.matrix.Array;

public class Matrix {
  private Array[] matrix;

  public Matrix(int[][] other){
    matrix = new Array[other.length];
    for(int rowNo = 0; rowNo < other.length; rowNo++){
      matrix[rowNo] = new Array(other[rowNo]);
    }
  }

  private int length() {
    return this.matrix.length;
  }

  private Array row(int index){
    return this.matrix[index];
  }

  private int rowNo(){
    return this.matrix.length;
  }

  private int colNo(){
    return this.matrix[0].length();
  }

  private Array getRow(int index) {
    return this.matrix[index];
  }

  @Override
  public String toString(){
    StringBuilder str = new StringBuilder("Matrix ");
    str.append("[\n");
    for(Array row : matrix){
      str.append("\t");
      str.append(row);
      str.append("\n");
    }
    str.append("]");
    return new String(str);
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Matrix)) return false;

    Matrix otherMatrix = (Matrix)other;
    if(otherMatrix.length() != this.matrix.length) return false;

    for(int index = 0; index < this.matrix.length; index++){
      Array otherRow = otherMatrix.getRow(index);
      Array row = this.matrix[index];
      if(!otherRow.equals(row)) return false;
    }

    return true;
  }

  public Matrix add(Matrix other){
    if(other.rowNo() != this.rowNo() || other.colNo() != this.colNo()){
      return null;
    }

    int[][] matrixSum;
    matrixSum = new int[this.rowNo()][this.colNo()];

    for(int rowNo = 0; rowNo < this.length(); rowNo++){
      Array row = this.row(rowNo);
      Array otherRow = other.row(rowNo);
      for(int colNo = 0; colNo < row.length(); colNo++){
        matrixSum[rowNo][colNo] = row.getElelment(colNo) + otherRow.getElelment(colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix subtract(Matrix other){
    if(other.rowNo() != this.rowNo() || other.colNo() != this.colNo()){
      return null;
    }

    int[][] matrixSum;
    matrixSum = new int[this.rowNo()][this.colNo()];

    for(int rowNo = 0; rowNo < this.length(); rowNo++){
      Array row = this.row(rowNo);
      Array otherRow = other.row(rowNo);
      for(int colNo = 0; colNo < row.length(); colNo++){
        matrixSum[rowNo][colNo] = row.getElelment(colNo) - otherRow.getElelment(colNo);
      }
    }
    return new Matrix(matrixSum);
  }

  public Matrix multiply(Matrix other){
    if(other.rowNo() != this.colNo() || other.colNo() != this.rowNo()){
      return null;
    }

    int[][] matrixSum;
    int totalRow = this.length();
    int totalCol = other.row(1).length();

    matrixSum = new int[totalRow][totalCol];

    for(int rowNo = 0; rowNo < totalRow; rowNo++){
      Array row = this.row(rowNo);
      for(int colNo = 0; colNo < totalCol; colNo++){
        int result = 0;
        for(int index = 0; index < row.length(); index++){
          Array otherRow = other.row(index);
          result += row.getElelment(index) * otherRow.getElelment(colNo);
        }
        matrixSum[rowNo][colNo] = result;
      }
    }
    return new Matrix(matrixSum);
  }
}