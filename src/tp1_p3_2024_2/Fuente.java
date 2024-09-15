package tp1_p3_2024_2;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Fuente {

	public static Font cargarFuente(String rutaFuente) {
		try {
			File archivoFuente = new File(rutaFuente);
			return Font.createFont(Font.TRUETYPE_FONT, archivoFuente);

		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}