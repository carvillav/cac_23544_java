package ar.com.codoacodo.herencia;

public class MainHerencia {

	public static void main(String[] args) {
		
		Articulo a1 = new Articulo("titulo1", 150.5f, "http://url.com/bla1.jpg");
		a1.setAutor("autor a1");
		System.out.println(a1);
		
		Musica m1 = new Musica("m1", 250.7f, "http://url.com/bla2.jpg");
		m1.setAutor("autor m1");
		String[] temas = new String[] {"t1", "t2", "t3"};
		m1.setTemas(temas);
		System.out.println(m1);
		
		Articulo p1 = new Pelicula("peli1", 858f, "bla.jpg");
		p1.setAutor("autor pelicula1");
		Pelicula peli = (Pelicula)p1;
		peli.setFormato("BLUE RAY 3D");
		peli.setProductora("WARNER");
		System.out.println("----------------");
		System.out.println(p1);
		
		//Vector para guardar instancias
		Articulo[] resultados = new Articulo[3];
		resultados[0] = a1;
		resultados[1] = m1;
		resultados[2] = p1;
		
		System.out.println("----------------");
		for(Articulo aux : resultados) {
			System.out.println(aux);
		}
	}

}
