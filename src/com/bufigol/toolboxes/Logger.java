package com.bufigol.toolboxes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private String path;

	public Logger(String path) {
		this.path = path;
		initializeLogFile(path);
	}

	private static void initializeLogFile(String path) {
		File logFile = new File(path);
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void logErrorWithErrorCode(int errorCode, String errorMessage, String path) {
		initializeLogFile(path);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - ERROR CODE: " + errorCode + "\n");
			writer.append(timeStamp + " - ERROR: " + errorMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logErrorWithErrorCode(int errorCode, String errorMessage) {
		logErrorWithErrorCode(errorCode, errorMessage, this.path);
	}

	public static void logError(String errorMessage, String path) {
		initializeLogFile(path);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - ERROR: " + errorMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logError(String errorMessage) {
		logError(errorMessage, this.path);
	}

	public static void logInfo(String infoMessage, String path) {
		initializeLogFile(path);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - INFO: " + infoMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logInfo(String infoMessage) {
		logInfo(infoMessage, this.path);
	}

	public static void logWarning(String warningMessage, String path) {
		initializeLogFile(path);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.append(timeStamp + " - WARNING: " + warningMessage + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logWarning(String warningMessage) {
		logWarning(warningMessage, this.path);
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
