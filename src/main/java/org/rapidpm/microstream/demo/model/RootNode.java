package org.rapidpm.microstream.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootNode {
  private final List<Car> cars = new ArrayList<>();

  //NOT Immutable !!
  public List<Car> getCars() {
    return cars;
  }

  private Map<Integer, List<Car>> queryForAmountOfCylinders = new HashMap<>();

  public void addCar(Car c) {
    getCars().add(c);
    int amount = c.getEngine().getAmountCylinders();
    queryForAmountOfCylinders.computeIfPresent(amount, (integer, cars) -> {
      cars.add(c);
      return cars;
    });

    queryForAmountOfCylinders.computeIfAbsent(amount, integer -> {
      List<Car> holder = new ArrayList<>();
      holder.add(c);
      return holder;
    });
  }

  public void removeCar(Car c) {
    getCars().remove(c);
    int amount = c.getEngine().getAmountCylinders();
    queryForAmountOfCylinders.computeIfPresent(amount, (integer, cars) -> {
      cars.remove(c);
      return cars;
    });
  }

  //Query
  public int SumOfCarsWithAmountOfCylinders(int i) {
    return ListOfCarsWithAmountOfCylinders(i).size();
  }

  public List<Car> ListOfCarsWithAmountOfCylinders(int i) {
    return queryForAmountOfCylinders.getOrDefault(i, List.of());
  }
}
