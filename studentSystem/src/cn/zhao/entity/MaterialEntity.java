package cn.zhao.entity;

public class MaterialEntity {
	private String isbn;
	private String author;
	private int price;
	private String publishing;
	private String book_name;
	
	public MaterialEntity(String isbn, String author, int price, String publishing, String book_name) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.publishing = publishing;
		this.book_name = book_name;
	}
	
	public MaterialEntity() {

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Override
	public String toString() {
		return "Matertal [isbn=" + isbn + ", author=" + author + ", price=" + price + ", publishing=" + publishing
				+ ", book_name=" + book_name + "]";
	}
}
