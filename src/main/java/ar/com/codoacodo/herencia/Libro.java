package ar.com.codoacodo.herencia;

public class Libro extends Articulo{

	private String isbn;
	
	public Libro(String titulo, 
				 Float precio, 
				 String img) {
		super(titulo, precio, img);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return super.toString() 
			   + ", Libro [isbn=" + isbn + "]";
	}

	
}
