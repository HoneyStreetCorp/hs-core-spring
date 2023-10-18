package com.hscoreserver.hscorespring.error;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorResponse {
  private String errorCode;
  private String errorMessage;

  public static ErrorResponse of(String errorCode, String errorMessage) {
    return new ErrorResponse(errorCode, errorMessage);
  }

  public static ErrorResponse of(String errorCode, BindingResult bindingResult) {
    return new ErrorResponse(errorCode, createErrorMessage(bindingResult));
  }

  private static String createErrorMessage(BindingResult bindingResult) {
    StringBuilder sb = new StringBuilder();
    boolean isFirst = true;
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    for (FieldError fieldError : fieldErrors) {
      if (!isFirst) {
        sb.append(",");
      } else {
        isFirst = false;
      }
      sb.append("[");
      sb.append(fieldError.getField());
      sb.append("]");
      sb.append(fieldError.getDefaultMessage());
    }
    return sb.toString();
  }
}
