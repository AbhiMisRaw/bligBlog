package com.example.BligBlog.validation;

import com.example.BligBlog.domain.Post;
import com.example.BligBlog.service.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public record BlogPostTitleValidator(PostService postService) implements ConstraintValidator<BlogPostTitleAlreadyExists , Post> {
    @Override
    public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post value, ConstraintValidatorContext context) {
        if(!StringUtils.isEmpty(value.getTitle()) && postService.postExistWithTitle(value.getTitle())){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Title Already exist")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
