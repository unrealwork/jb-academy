package simulation;

import simulation.SimulationFileServer;

public class SimulationMain {
  public static void test(String[] args) throws Exception {
    try (SimulationFileServer fileServer = SimulationFileServer.simulation()) {
      fileServer.start();
    }
  }
}
