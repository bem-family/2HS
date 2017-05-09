package com.bem.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bem.domain.UserRegDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 
   
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {       
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
      UserRegDto user = (UserRegDto) obj;
      return user.getPassword().equals(user.getConfirm_password());    
  }     
}
