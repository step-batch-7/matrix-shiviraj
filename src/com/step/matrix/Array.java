package com.step.matrix;

public class Array{
  private int[] array;

  public Array(int[] array) {
    this.array = new int[array.length];
    for(int index = 0; index < array.length; index++){
      this.array[index] = array[index];
    }
  }

  public int length() {
    return this.array.length;
  }

  public int getElelment(int index) {
    return this.array[index];
  }

  public boolean isEqualLength(Array array) {
    return this.array.length == array.length();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Array ");
    sb.append("[");
    for(int num: this.array){
      sb.append(num);
      sb.append(",");
    }
    sb.append("]");
    return new String(sb);
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) return true;
    if(!(other instanceof Array)) return false;

    Array otherArray = (Array)other;
    if(otherArray.length() != this.array.length) return false;

    for(int index = 0; index < this.array.length; index++){
      if(otherArray.getElelment(index) != this.array[index]) return false;
    }

    return true;
  }
}