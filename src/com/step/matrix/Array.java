package com.step.matrix;

public class Array{
  private int[] array;
  public int length;

  public Array(int[] array) {
    this.array = new int[array.length];
    for(int index = 0; index < array.length; index++){
      this.array[index] = array[index];
    }
    this.length = array.length;
  }

  public int getElement(int index) {
    return this.array[index];
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Array ");
    sb.append("[");
    for(int num: this.array){
      sb.append(num + ", ");
    }
    sb.append("]");
    return new String(sb);
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Array)) return false;

    Array otherArray = (Array)other;
    if(otherArray.length != this.length) return false;

    for(int index = 0; index < this.length; index++){
      if(otherArray.getElement(index) != this.array[index]) return false;
    }

    return true;
  }
}