package com.hscoreserver.hscorespring.util;

import java.util.Random;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Base62Util {

  private static final int TOKEN_LENGTH = 6;

  public static String generateBase62() {
    String charArr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < TOKEN_LENGTH; i++) {
      Random rand = new Random();
      int index = rand.nextInt(62);
      res.append(charArr.charAt(index));
    }
    return res.toString();
  }

}
