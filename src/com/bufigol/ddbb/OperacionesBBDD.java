package com.bufigol.ddbb;

import java.sql.SQLException;

import com.bufigol.configFile.ConfigFile;
import com.bufigol.toolboxes.Logger;

public class OperacionesBBDD {
	private ConexionBD conexion;
	private Logger logger;
	private ConfigFile configFile;

	public OperacionesBBDD() {
		conexion = new ConexionBD();
		configFile = new ConfigFile();
		this.logger = this.configFile.getLogger();
		this.logger.logInfo("Clase " + this.getClass().getSimpleName() + " creada");
		checkAndOpenConection();
		cerrarConeccion();
	}

	public void cerrarConeccion() {
		conexion.cerrarConexion();
		this.logger.logInfo("Conexión cerrada");
	}

	private void checkAndOpenConection() {
		try {
			if (this.conexion.getConexion().isClosed()) {
				this.conexion.openConection();
			}
		} catch (SQLException e) {
			this.logger.logErrorWithErrorCode(e.getErrorCode(), e.getMessage());
			this.logger.logErrorWithErrorCode(e.getErrorCode(), "Error intenando abrir conexion");
			e.printStackTrace();
		}
	}
}
