package tp1_p3_2024_2;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MatrizImagen {
    private BufferedImage originalImage;
    private BufferedImage[][] imageParts;

    public MatrizImagen(String imagePath) {
        try {
            originalImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void divideImagen(int rows, int cols) {
        int chunkWidth = originalImage.getWidth() / cols; // determina el ancho
        int chunkHeight = originalImage.getHeight() / rows; // determina largo

        imageParts = new BufferedImage[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // Inicializa la matriz y la llena con la parte correspondiente de la imagen original
                imageParts[x][y] = new BufferedImage(chunkWidth, chunkHeight, originalImage.getType());
                BufferedImage chunk = originalImage.getSubimage(y * chunkWidth, x * chunkHeight, chunkWidth, chunkHeight);
                imageParts[x][y].getGraphics().drawImage(chunk, 0, 0, null);
            }
        }
    }

    public BufferedImage[][] getImageParts() {
        return imageParts;
    }
}

// NO PUDE ADAPTAR LA IMAGEN A LA MATRIZ TODAVIA, LA DIVIDE PERO NO LA MUESTRA CORRECTAMENTE.
