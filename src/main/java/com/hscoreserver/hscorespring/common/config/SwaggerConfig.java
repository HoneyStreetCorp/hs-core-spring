package com.hscoreserver.hscorespring.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
        .select()   // ApiSelectorBuilder 생성
        .apis(RequestHandlerSelectors.basePackage("com.hscoreserver.hscorespring"))   // API 패키지 경로
        .paths(PathSelectors.any())       // <- 모든 path 에 대해서 명세 표시
        .build()
        .apiInfo(apiInfo()) // API 문서에 대한 정보 추가
        .useDefaultResponseMessages(false);  // swagger 에서 제공하는 기본 응답 코드 설명 제거
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Hs-core API 문서")
        .description("API 스펙에 대해서 설명해주는 문서입니다.")
        .version("0.0.1")
        .build();
  }
}
