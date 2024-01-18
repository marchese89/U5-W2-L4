package antoniogiovanni.marchese.U5W2L3.controller;

import antoniogiovanni.marchese.U5W2L3.model.AutoreBlogPost;
import antoniogiovanni.marchese.U5W2L3.service.AutoreBlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AutoreBlogPostController {
    @Autowired
    private AutoreBlogPostService autoreBlogPostService;

    // 1. GET http://localhost:3001/authors
    @GetMapping
    public Page<AutoreBlogPost> getUsers(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "id") String orderBy) {
        return autoreBlogPostService.getAutoriBlogPostList(page, size, orderBy);
    }

    // 	2. POST http://localhost:3001/authors (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public AutoreBlogPost saveUser(@RequestBody AutoreBlogPost autoreBlogPost) {
        return autoreBlogPostService.save(autoreBlogPost);
    }

    // 	3. GET http://localhost:3001/authors/:id
    @GetMapping("/{id}")
    public AutoreBlogPost findById(@PathVariable UUID id) {
        return autoreBlogPostService.findById(id);
    }


    // 	4. PUT http://localhost:3001/authors/:id (+body)
    @PutMapping("/{id}")
    public AutoreBlogPost findByAndUpdate(@PathVariable UUID id, @RequestBody AutoreBlogPost autoreBlogPost) {
        return this.autoreBlogPostService.findByIdAndUpdate(id, autoreBlogPost);
    }

    // 	5. DELETE http://localhost:3001/authors/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.autoreBlogPostService.findByIdAndDelete(id);
    }
}
