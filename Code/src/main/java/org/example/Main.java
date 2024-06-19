package org.example;

import org.variantsync.diffdetective.variation.*;

public class Main {

  public static void main(String[] args) {
    Test test = new Test();
    try {
      test.testSimple1();
      test.testSimple2();
      test.testSimple3();
      test.testSimple4();
    }catch (Exception e){
      e.printStackTrace();
    }

    System.out.println("hallo");
  }
}