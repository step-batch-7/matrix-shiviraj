package com.step.matrix;

public class Array{
  private final int[] array;
  public final int length;

  public Array(int[] array) {
    this.length = array.length;
    this.array = new int[this.length];
    System.arraycopy(array, 0, this.array, 0, this.length);
  }

  public int getElement(int index) {
    return this.array[index];
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Array)) return false;

    Array otherArray = (Array)other;
    if(otherArray.length != this.length) return false;

    for(int index = 0; index < this.length; index++){
      if(otherArray.getElement(index) != this.getElement(index)) return false;
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Array ");
    sb.append("[");
    for(int num: this.array){
      sb.append(num).append(", ");
    }
    sb.append("]");
    return new String(sb);
  }
}