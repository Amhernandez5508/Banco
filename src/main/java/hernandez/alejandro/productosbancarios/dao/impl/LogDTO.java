package hernandez.alejandro.productosbancarios.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hernandez.alejandro.productosbancarios.dao.DAO;
import hernandez.alejandro.productosbancarios.datasource.ConnectionDB;
import hernandez.alejandro.productosbancarios.entity.Log;

public class LogDTO implements DAO<Log, Integer>{

	@Override
	public void insert(Log entity) {
		try {
			String sqlQueryTemp = "INSERT INTO log (Fecha, Clase, Producto, Descripcion) VALUES (?, ?, ?, ?)";
			
			PreparedStatement sqlQueryPrep = ConnectionDB.connect().prepareStatement(sqlQueryTemp);
			sqlQueryPrep.setObject(1, entity.getFecha());
			sqlQueryPrep.setString(2, entity.getClase());
			sqlQueryPrep.setString(3, entity.getProducto());
			sqlQueryPrep.setString(4, entity.getDescripcion());
			
			sqlQueryPrep.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void select() {
		try {
			String sqlQueryTemp = "SELECT * FROM log";
			
			PreparedStatement sqlQueryPrep = ConnectionDB.connect().prepareStatement(sqlQueryTemp);
			
			ResultSet replySQL = sqlQueryPrep.executeQuery();
			
			while(replySQL.next()) {
				System.out.println(String.format("ID: %d || Fecha: %s || Clase: %s || Producto: %s || Descripcion: %s", replySQL.getInt("ID"), replySQL.getObject("Fecha").toString(), replySQL.getString("Clase"), replySQL.getString("Producto"), replySQL.getString("Descripcion")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void select(Integer pID) {
		// TODO Auto-generated method stub
		
	}

	
}
