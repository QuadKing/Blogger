package data.repositories;


import africa.QuadKing.Blogger.data.models.Comment;
import africa.QuadKing.Blogger.data.repositories.CommentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {

    private CommentRepository commentleRepository;

    private Comment comment;

    @BeforeEach
    public void setUp(){
        commentRepository = new CommentRepositoryImpl();
        comment = new Comment();
        comment.setId(1);
        comment.setArticleId(1);
        comment.setUserId(1);

    }


    @Test
    public void saveOneArticle_countIsOneTest(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals (1, commentRepository.count());
    }


    @Test public void saveOneArticle_idOfUserIsOneTest(){
        Comment savedComment = CommentRepository.save(comment);
        assertEquals(1, savedArticle.getId());
    }

    @DisplayName("Update article test")
    @Test public void saveTwoArticlesWithSameId_countIsOneTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        savedComment.setId(1);
        commentRepository.save(savedArticle);
        assertEquals(1, commentRepository.count());
    }

    @Test public void saveOneArticle_findArticleByIdTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        Comment foundComment = commentRepository.findById(1);
        assertEquals(foundComment, savedComment);

    }

    @Test public void saveOneArticle_deleteOneArticle_countIsZero(){
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count());
    }

}