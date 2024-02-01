package com.bufigol.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bufigol.configFile.ConfigFile;
import com.bufigol.constants.INT_CONST_FILEPATHS;
import com.bufigol.toolboxes.Logger;

public class ConexionBD {
	private Connection conexion;
	private Logger logger;
	private ConfigFile configFile;

	public ConexionBD() {
		// Conexión con la base de datos
		this.logger = new Logger(INT_CONST_FILEPATHS.LOG_PATH);
		this.configFile = new ConfigFile();
		try {
			conexion = DriverManager.getConnection(configFile.obtenerValor("URLCONEXIONDB"),
					configFile.obtenerValor("USRNAME"), configFile.obtenerValor("PWD"));
			this.logger.logInfo("Conexión con la base de datos establecida");
		} catch (SQLException e) {
			this.logger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			conexion.close();
			this.logger.logInfo("Conexión con la base de datos cerrada");
		} catch (SQLException e) {
			this.logger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}

	}

	public void openConection() {
		try {
			conexion = DriverManager.getConnection(configFile.obtenerValor("URLCONEXIONDB"),
					configFile.obtenerValor("USRNAME"), configFile.obtenerValor("PWD"));
			this.logger.logInfo("Conexión con la base de datos reestablecida");
		} catch (SQLException e) {
			this.logger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		this.logger.logInfo("Conexión con la base de datos devuelta");
		return conexion;
	}
}
