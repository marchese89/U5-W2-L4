package antoniogiovanni.marchese.U5W2L3.controller;

import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import antoniogiovanni.marchese.U5W2L3.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // 1. GET http://localhost:3001/blogPosts
    @GetMapping
    public Page<BlogPost> getUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return blogPostService.getBlogbostList(page, size, orderBy);
    }

    // 	2. POST http://localhost:3001/blogPosts (+body)
    @PostMapping("/{idAutore}")
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogPost saveUser(@RequestBody BlogPost blogPost,@PathVariable UUID idAutore) {
        return blogPostService.save(blogPost,idAutore);
    }

    // 	3. GET http://localhost:3001/blogPosts/:id
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }


    // 	4. PUT http://localhost:3001/blogPosts/:id (+body)
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable UUID id, @RequestBody BlogPost blogPost) {
        return this.blogPostService.findByIdAndUpdate(id, blogPost);
    }

    // 	5. DELETE http://localhost:3001/blogPosts/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}
