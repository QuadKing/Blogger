package data.repositories;

import africa.QuadKing.Blogger.data.models.Article;
import africa.QuadKing.Blogger.data.repositories.ArticleRepository;
import africa.QuadKing.Blogger.data.repositories.ArticleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
    private ArticleRepository articleRepository;
    private Article article;

    @BeforeEach
    public void setUp(){
        articleRepository = new ArticleRepositoryImpl();
        article = new Article();
        article.setId(1);
        article.setTitle("Article Title");
        article.setBody("Article body, document");

    }


    @Test public void saveOneArticle_countIsOneTest(){
        Article article = new Article();
        articleRepository.save(article);
        assertEquals (1, articleRepository.count());
    }


    @Test public void saveOneArticle_idOfUserIsOneTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
    }

    @DisplayName("Update article test")
    @Test public void saveTwoArticlesWithSameId_countIsOneTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        savedArticle.setId(1);
        articleRepository.save(savedArticle);
        assertEquals(1, articleRepository.count());
    }

    @Test public void saveOneArticle_findArticleByIdTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundArticle= articleRepository.findById(1);
        assertEquals(foundArticle, savedArticle);

    }

    @Test public void saveOneArticle_deleteOneArticle_countIsZero(){
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.count());
    }


}