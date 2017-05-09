package com.bem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {
   
  private Pattern pattern;
  private Matcher matcher;
  
  static final String ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~-]";
  static final String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)+";
  static final String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

  static final String EMAIL_PATTERN =
          "^" + ATOM + "+(\\." + ATOM + "+)*@"
                  + DOMAIN
                  + "|"
                  + IP_DOMAIN
                  + ")$";
  @Override
  public void initialize(EmailValid constraintAnnotation) {       
  }
  @Override
  public boolean isValid(String email, ConstraintValidatorContext context){   
      return (validateEmail(email));
  } 
  private boolean validateEmail(String email) {
      pattern = Pattern.compile(EMAIL_PATTERN);
      matcher = pattern.matcher(email);
      return matcher.matches();
  }
}