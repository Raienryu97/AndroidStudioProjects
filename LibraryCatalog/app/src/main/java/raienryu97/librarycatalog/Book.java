package raienryu97.librarycatalog;


public class Book {
    String Title;
    String Author;
    String Category;
    int id;

    public Book(){
        super();
    }
    public Book(String Title, String Author, String Category, int id){
        super();
        this.Title = Title;
        this.Author = Author;
        this.Category = Category;
        this.id = id;
    }
    public int getid(){
        return id;
    }
    public void setid( int book_id){
        this.id = book_id;
    }
    public String getName(){
        return Title;
    }
    public void setName(String name){
        this.Title = name;
    }
    public String getAuthor(){
        return Author;
    }
    public void setAuthor(String name){
        this.Author = name;
    }
    public String getCategory(){
        return Category;
    }
    public void setCategory(String category){
        this.Category = category;
    }

    @Override
    public String toString() {
        return this.Title;
    }
}
