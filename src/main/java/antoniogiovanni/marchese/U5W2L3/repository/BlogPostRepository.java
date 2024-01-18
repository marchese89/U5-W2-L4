package antoniogiovanni.marchese.U5W2L3.repository;

import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}
