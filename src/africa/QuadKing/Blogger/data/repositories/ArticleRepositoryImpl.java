package africa.QuadKing.Blogger.data.repositories;

import africa.QuadKing.Blogger.data.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {

    public static void main(String[] args) {

    }
    private int count;

    private List<Article> articles = new ArrayList<>();



    @Override
    public Article save(Article article) {
        boolean userHasNotBeenSaved = article.getId() == 0;
        if (userHasNotBeenSaved) saveNew(article);

        return article;
    }

    private void saveNew(Article article) {
        article.setId(generateArticleId());
        articles.add(article);
        count++;
    }

    private int generateArticleId() {
        return count+1;
    }

    @Override
    public Article findById(int id) {
        for (Article article: articles) if (article.getId() == id) return article;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll() {


        return null;
    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public void delete(int id) {

        for (Article article : articles){
//        boolean userHasNotBeenSaved = user.getId() == id;
            if (article.getId() == id){
                articles.remove(article);
                count--;
                break;
            }
        }
    }



    @Override
    public void deleteAll() {

    }
}
