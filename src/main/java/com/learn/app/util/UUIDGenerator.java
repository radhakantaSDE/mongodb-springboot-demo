package com.learn.app.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UUIDGenerator {

  /** Help to generate random uuid */
  public static String randomUUID() {
    return UUID.randomUUID().toString();
  }
}
