package com.hscoreserver.hscorespring.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class HsConfig {

  @Value("${hscore.base-url}")
  private String baseUrl;

  public String getBaseUrl() {
    return baseUrl;
  }
}

