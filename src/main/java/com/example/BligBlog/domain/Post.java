package com.example.BligBlog.domain;

import java.time.LocalDateTime;
import java.util.* ;

import com.example.BligBlog.validation.BlogPostTitleAlreadyExists;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@BlogPostTitleAlreadyExists
public class Post {

	private Integer id ;
	@NotNull
	@Size(min = 3, max = 50, message = "Title must  be minimum 3 chars and maximum 50 chars long.")
	private String title ;
	@NotNull
	@Size(min = 3, max = 50, message = "Description must  be minimum 3 chars and maximum 50 chars long.")
	private String description ;
	@NotNull
	@Size(min = 3, max = 5000, message = "Body must  be minimum 3 chars and maximum 50 chars long.")
	private String body ;
	private String slug ;
	private PostStatus postStatus ;
	
	private LocalDateTime createdOn ;
	private LocalDateTime updatedOn ;
	
	private List<Comment> comments ;

	
	
}
