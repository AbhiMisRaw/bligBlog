package com.example.BligBlog.controller;
import com.example.BligBlog.service.BligBlogException;
import com.example.BligBlog.service.PostService ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.BligBlog.domain.Post;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService ;
	
	@GetMapping
	public String postPage(Model model) {

		model.addAttribute("posts", postService.findAllPosts());
		return "post" ;
		
	}

	@GetMapping("/add")
	public String addPostPage(Model model){
		model.addAttribute("post",new Post());
		return "addPost";
	}

	@PostMapping
	public  String addPost(@ModelAttribute("post") @Valid Post post , Errors errors){
		if(errors.hasErrors()){
			return "addPost";
		}
		postService.addPost(post);
		return "redirect:/posts";
	}

	@GetMapping("/{id}")
	public String onePostPage(Model model, @PathVariable Integer id){
		model.addAttribute("posts",postService.findOnePost(id));
		return "onePost";
	}

	@ExceptionHandler(BligBlogException.class)
	public ModelAndView handleBligBlogException(BligBlogException exception){
		ModelAndView model = new ModelAndView("error");
		model.addObject("exception" , exception);
		return model ;
	}

}
