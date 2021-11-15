package org.rapidpm.microstream.demo.model;

public record Cylinder(int size, int position) {

  @Override
  public String toString() {
    return "Cylinder{" +
        "size=" + size +
        ", position=" + position +
        '}';
  }
}
