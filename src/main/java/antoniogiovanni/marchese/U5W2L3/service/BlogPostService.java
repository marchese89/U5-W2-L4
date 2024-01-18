package antoniogiovanni.marchese.U5W2L3.service;

import antoniogiovanni.marchese.U5W2L3.exceptions.NotFoundException;
import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import antoniogiovanni.marchese.U5W2L3.repository.AutoreBlogPostRepository;
import antoniogiovanni.marchese.U5W2L3.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreBlogPostService autoreBlogPostService;

    public Page<BlogPost> getBlogbostList(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy).descending());
        return blogPostRepository.findAll(pageable);
    }

    public BlogPost save(BlogPost blogPost,UUID idAutore) {
        blogPost.setAutoreBlogPost(autoreBlogPostService.findById(idAutore));
        return blogPostRepository.save(blogPost);
    }

    public BlogPost findById(UUID id) {
        return blogPostRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        BlogPost found = this.findById(id);
        blogPostRepository.delete(found);
    }

    public BlogPost findByIdAndUpdate(UUID id, BlogPost blogpost) {
        BlogPost found = this.findById(id);

        found.setCategoria(blogpost.getCategoria() != null ? blogpost.getCategoria(): found.getCategoria());
        found.setTitolo(blogpost.getTitolo()!= null ? blogpost.getTitolo(): found.getTitolo());
        found.setCover(blogpost.getCover() != null ? blogpost.getCover() : found.getCover());
        found.setContenuto(blogpost.getContenuto() != null ? blogpost.getContenuto() : found.getContenuto());
        found.setTempoDiLettura(blogpost.getTempoDiLettura() != null ? blogpost.getTempoDiLettura() : found.getTempoDiLettura());

        return blogPostRepository.save(found);
    }
}
