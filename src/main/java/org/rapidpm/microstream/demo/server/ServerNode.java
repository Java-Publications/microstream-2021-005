package org.rapidpm.microstream.demo.server;

import one.microstream.communication.binary.types.ComBinary;
import one.microstream.communication.types.ComHost;
import org.rapidpm.microstream.demo.model.Car;
import org.rapidpm.microstream.demo.model.Cylinder;
import org.rapidpm.microstream.demo.model.Engine;
import org.rapidpm.microstream.demo.model.Wheel;

import java.net.InetSocketAddress;

public class ServerNode {
  public static void main(final String[] args) {
    final ComHost<?> host = ComBinary.Foundation()
        .setHostBindingAddress(new InetSocketAddress("localhost", 1337))
        .setHostChannelAcceptor(hostChannel -> {
          // sessionless / stateless greeting service
          final Car car = (Car) hostChannel.receive();
          System.out.println("I got a car - " + car);
          hostChannel.send("Welcome, " + car.toString());
          hostChannel.close();
        })
        .registerEntityTypes(Car.class)
//        .registerEntityTypes(Engine.class)
//        .registerEntityTypes(Cylinder.class)
//        .registerEntityTypes(Wheel.class)
        .createHost();
    host.run();
  }
}
