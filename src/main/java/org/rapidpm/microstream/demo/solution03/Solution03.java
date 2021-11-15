package org.rapidpm.microstream.demo.solution03;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.rapidpm.microstream.demo.model.*;

import java.nio.file.Paths;
import java.util.List;

public class Solution03 {
  public static void main(String[] args) {
    RootNode rootNode = new RootNode();

    final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
        rootNode, Paths.get("_data")
    );
    storageManager.setRoot(rootNode);
    storageManager.storeRoot();

    //modify the root node
    Car car = createCar();
    rootNode.addCar(car);
    storageManager.storeRoot();
    //get all cars with an Engine with 4 cylinders
    //this is the Query
    int sum = rootNode.SumOfCarsWithAmountOfCylinders(4);

    System.out.println("result = " + sum);
    // shutdown storage
    storageManager.close();
//    storageManager.shutdown();
    System.exit(0);
  }

  public static Car createCar() {
    Car car001 = new Car();
    car001.addWheels(List.of(new Wheel(1),
        new Wheel(1),
        new Wheel(1),
        new Wheel(1)));
    Engine engine = new Engine();
    engine.addCylinders(List.of(new Cylinder(1, 1),
        new Cylinder(1, 2),
        new Cylinder(1, 3),
        new Cylinder(1, 4)));
    engine.setPowerInPS(123);
    car001.setEngine(engine);
    return car001;
  }

}
