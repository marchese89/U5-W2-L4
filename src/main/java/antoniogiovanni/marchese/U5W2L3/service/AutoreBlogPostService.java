package antoniogiovanni.marchese.U5W2L3.service;

import antoniogiovanni.marchese.U5W2L3.exceptions.NotFoundException;
import antoniogiovanni.marchese.U5W2L3.model.AutoreBlogPost;
import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import antoniogiovanni.marchese.U5W2L3.repository.AutoreBlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AutoreBlogPostService {
    @Autowired
    private AutoreBlogPostRepository autoreBlogPostRepository;
    public Page<AutoreBlogPost> getAutoriBlogPostList(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy).descending());
        return autoreBlogPostRepository.findAll(pageable);
    }

    public AutoreBlogPost save(AutoreBlogPost autoreBlogPost) {
        return autoreBlogPostRepository.save(autoreBlogPost);
    }

    public AutoreBlogPost findById(UUID id) {
        return autoreBlogPostRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        AutoreBlogPost found = this.findById(id);
        autoreBlogPostRepository.delete(found);
    }

    public AutoreBlogPost findByIdAndUpdate(UUID id, AutoreBlogPost autoreBlogPost) {
        AutoreBlogPost found = this.findById(id);

        found.setNome(autoreBlogPost.getNome() != null ? autoreBlogPost.getNome() : found.getNome());
        found.setCognome(autoreBlogPost.getCognome() != null ? autoreBlogPost.getCognome() : found.getCognome());
        found.setEmail(autoreBlogPost.getEmail() != null ? autoreBlogPost.getEmail() : found.getEmail());
        found.setDataDiNascita(autoreBlogPost.getDataDiNascita() != null ? autoreBlogPost.getDataDiNascita(): found.getDataDiNascita());
        found.setAvatar(autoreBlogPost.getAvatar()!= null? autoreBlogPost.getAvatar() : found.getAvatar());

        return autoreBlogPostRepository.save(found);
    }
}
