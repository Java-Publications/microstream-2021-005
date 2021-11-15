package org.rapidpm.microstream.demo.client;

import one.microstream.communication.binary.types.ComBinary;
import one.microstream.communication.types.ComChannel;
import one.microstream.communication.types.ComClient;
import org.rapidpm.microstream.demo.model.Car;
import org.rapidpm.microstream.demo.solution03.Solution03;

import java.net.InetSocketAddress;

public class ClientNode {
  public static void main(final String[] args) {
    final ComClient<?> client = ComBinary.Foundation()
        .setClientTargetAddress(new InetSocketAddress("localhost", 1337))
        .createClient();

    final ComChannel channel = client.connect();

    Car car = Solution03.createCar();

    Object request = channel.request(car);
    System.out.println("Host reply: " + request);
  }
}
