package com.bufigol.configFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.bufigol.constants.INT_CONST_FILEPATHS;
import com.bufigol.toolboxes.Logger;

public class ConfigFile {
	/**
	 * Propiedades del archivo de configuración.Aqui se cargan las propiedades del
	 * archivo de configuración.
	 */
	private Properties properties;
	/**
	 * Ruta del archivo de configuración.
	 */
	private String configFile;
	private Logger lg;

	/**
	 * Constructor de la clase.Se inicializa el archivo de configuración, y se carga
	 * las propiedades. Se utiliza por defecto la ruta de la configuración que se
	 * encuenta en la interfaz de constantes (INT_CONST_FILES_PATHS).
	 */
	public ConfigFile() {
		this.properties = new Properties();// Carga las propiedades
		this.configFile = INT_CONST_FILEPATHS.CONFIG_FILE_PATH;// Carga la ruta
		leerConfiguracion();// Carga las propiedades
		this.lg = new Logger(properties.getProperty("LogFile"));
	}

	public ConfigFile(String configPath, String logPath) {
		this.properties = new Properties();// Carga las propiedades
		this.configFile = configPath;// Carga la ruta
		leerConfiguracion();// Carga las propiedades
		this.lg = new Logger(logPath);
	}

	/**
	 * Constructor de la clase.Se inicializa el archivo de configuración, y se
	 * cargan las propiedades de un archivo de configruacion dado.
	 * 
	 * @param configFile Ruta del archivo de configuiracion a utilizar
	 */
	public ConfigFile(String configFile) {
		this.configFile = configFile;
		properties = new Properties();
		leerConfiguracion();
	}

	public void escribirConfiguracion() {
		try (FileOutputStream output = new FileOutputStream(configFile)) {
			properties.store(output, null);
			this.lg.logInfo("ConfiguracionGeneral guardada");
		} catch (IOException e) {
			this.lg.logError(e.getMessage());
			e.printStackTrace();
		}
	}

	public String obtenerValor(String clave) {
		String out = properties.getProperty(clave);
		this.lg.logInfo("\"" + clave + "\" cargada con el valor \"" + out + "\"");
		return out;
	}

	public void establecerValor(String clave, String valor) {
		String antes = properties.getProperty(clave);
		properties.setProperty(clave, valor);
		this.lg.logInfo("\"" + clave + "\" cambiada de \"" + antes + "\" a \"" + valor + "\"");
	}

	public void crearNuevaCategoria(String nombreCategoria) {
		properties.setProperty(nombreCategoria, "");
		this.lg.logInfo("\"" + nombreCategoria + "\" creada");
	}

	public void crearNuevaCategoriaValor(String nombreCategoria, String valor) {
		crearNuevaCategoria(nombreCategoria);
		establecerValor(nombreCategoria, valor);
	}

	private void leerConfiguracion() {
		FileInputStream input;
		try {
			input = new FileInputStream(configFile);
			properties.load(input);
			this.lg.logInfo("Configuracion cargada");
		} catch (FileNotFoundException e) {
			this.lg.logError("Archivo de configuración no encontrado");
			this.lg.logError(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			this.lg.logError(e.getMessage());
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public Logger getLogger() {
		return lg;
	}

	public void setLogger(Logger lg) {
		this.lg = lg;
	}
}
