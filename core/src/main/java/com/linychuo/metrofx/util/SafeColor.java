package com.linychuo.metrofx.util;

import java.util.Random;

/**
 * Created by ivan on 14-8-14.
 */
public class SafeColor {

  private static final Random rand = new Random();

  private SafeColor() {

  }

  private static final String[] VALUES =
      {"#252525", "#006AC1", "#691BB8", "#f4b300", "#001e43", "#1faeff", "#78ba00", "#008287",
       "#1b58b8", "#2673ec", "#004d60", "#56c5ff", "#ae113d", "#199900", "#569ce3", "#632f00",
       "#004a00", "#00d8cc", "#2e1700", "#00c13f", "#00aaaa", "#b01e00", "#15992a", "#91d100",
       "#4e0000", "#ff981d", "#b81b6c", "#4e0038", "#e56c19", "#e1b700", "#c1004f", "#ff2e12",
       "#d39d09", "#7200ag", "#b81b1b", "#ff76bc", "#2d004e", "#ff1077", "#e064b7", "#4617b4",
       "#b81b6c", "#00a4a4", "#1f0068", "#aa40ff", "#ff7d23", "#696969"
      };

  public static String color() {
    return VALUES[rand.nextInt(VALUES.length)];
  }

  public static String color(int i) {
    if (i > VALUES.length || i < 0) {
      i = 32;
    }
    return VALUES[i];
  }
}
