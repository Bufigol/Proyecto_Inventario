package com.bufigol.toolboxes;

import java.text.Normalizer;

public interface TextToolbox {
	public static String removerCaracteresEspeciales(String str) {
		String out = "";
		String stringNormalizada = Normalizer.normalize(str, Normalizer.Form.NFD);
		out = stringNormalizada.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return out;
	}

	public static String[] emptyTextArrayInizializer(int length) {
		String[] out = new String[length];
		for (int i = 0; i < length; i++) {
			out[i] = "";
		}
		return out;
	}

	public static String cutToLimit(String input, int limit) {
		String out = "";
		if (input.length() < limit) {
			out = input;
		} else {
			out = input.substring(0, limit - 1);
		}
		return out;
	}
}
