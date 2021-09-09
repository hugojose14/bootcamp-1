package com.scotia.customer.domain.data;

import java.util.Arrays;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * ResponseError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-20T16:03:56.853-05:00[America/Bogota]")
public class ResponseError   {
  @JsonProperty("message")
  private String message;

  @JsonProperty("errors")
  @Valid
  private List<String> errors = new ArrayList<>();

  @JsonProperty("code")
  private String code;

    public ResponseError(String message, String code) {
      this.message = message;
      this.code = code;
    }

    public ResponseError message(String message) {
    this.message = message;
    return this;
  }

  public ResponseError(String message, String code, List<String> errors ) {
    this.message = message;
    this.code = code;
    this.errors = errors;
  }

  public ResponseError(String message, String code, String errors) {
    this.message = message;
    this.code = code;
    this.errors = Arrays.asList(errors);
  }


  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ResponseError errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public ResponseError addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  @ApiModelProperty(value = "")


  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public ResponseError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  @ApiModelProperty(value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseError responseError = (ResponseError) o;
    return Objects.equals(this.message, responseError.message) &&
        Objects.equals(this.errors, responseError.errors) &&
        Objects.equals(this.code, responseError.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, errors, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseError {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

