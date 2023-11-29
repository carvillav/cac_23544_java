package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.utils.DateUtils;

public class MySqlOradorRepository implements OradorRepository {

	@Override
	public void save(Orador orador) {
		
		//Armar setencia
		String sql = "insert into oradores (nombre, apellido, mail, tema, fecha_alta) values (?; ?, ?, ?, ?)";
		try(Connection con = AdministradorDeConexiones.getConnection()) {//Obtener Conexión
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getTema());
			statement.setString(4, orador.getMail());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			
			statement.execute(); //insert-update-delete
			
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				Long id = res.getLong(1); //acá está el id
				orador.setId(id);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se puede crear el orador: ", e);
		}

	}

	@Override
	public Orador getById(Long id) {
		
		//Armar setencia
		String sql = "select id_orador, nombre, apellido, mail, tema, fecha_alta from oradores where id_orador = ?";
		Orador orador = null;
		try(Connection con = AdministradorDeConexiones.getConnection()) {//Obtener Conexión
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setLong(1, id);
									
				ResultSet res = statement.executeQuery();//select
				if(res.next()) {
					Long dbId = res.getLong(1);  
					String nombre = res.getString(2);  
					String apellido = res.getString(3);  
					String tema = res.getString(4);  
					String email = res.getString(5);  
					Date fechaAlta = res.getDate(6);  
					
					orador = new Orador(dbId, nombre, apellido, email, tema,DateUtils.asLocalDate(fechaAlta));//LocalDate.from(fechaAlta.toInstant())
				}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se puede crear el orador: ", e);
		}
		return orador;
	}

	@Override
	public void update(Orador orador) {
		String sql = "update from oradores"
					 + "set nombre=? apellido=? email=?, tema=? "
					 + "where id_orador = ?";
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getMail());
			statement.setString(4, orador.getTema());
			statement.setLong(5, orador.getId());
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar el orador:", e);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from oradores where id = ?";
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar el orador:", e);
		}
	}

	@Override
	public List<Orador> findAll() {
		String sql = "select id_orador, nombre, apellido, mail, tema, fecha_alta from oradores";

		List<Orador> oradores = new ArrayList<>();//se ve bien en spring!
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet res = statement.executeQuery();// SELECT

			while (res.next()) {
				Long dbId = res.getLong(1);  
				String nombre = res.getString(2);  
				String apellido = res.getString(3);  
				String tema = res.getString(4);  
				String email = res.getString(5);  
				LocalDate fechaAlta = DateUtils.asLocalDate(res.getDate(6));  
				
				oradores.add(new Orador(dbId, nombre, apellido, email, tema,fechaAlta));
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		return oradores;
	}

}
