package org.rapidpm.microstream.demo.model;

public record Wheel(int size) {
  @Override
  public String toString() {
    return "Wheel{" +
        "size=" + size +
        '}';
  }
}
