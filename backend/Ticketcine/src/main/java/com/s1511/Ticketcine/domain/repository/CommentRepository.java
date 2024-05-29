package com.s1511.Ticketcine.domain.repository;
import com.s1511.Ticketcine.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    Optional<Comment> findByIdAndActive(String id, Boolean active);
    List<Comment> findAllCommentByUserIdAndActive(String userId, Boolean active);
    List<Comment> findAllCommentByMovieIdAndActive(String movieId, Boolean active);
    Optional<Comment> findByUserIdAndMovieId(String userId, String movieId); //Necesario para corroborar previo a crear.
}
