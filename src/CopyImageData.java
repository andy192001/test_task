import java.util.Random;
import java.util.Scanner;

public class CopyImageData {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть ширину масиву frame_width: ");
        int frameWidth = input.nextInt();

        System.out.print("Введіть висоту масиву frame_height: ");
        int frameHeight = input.nextInt();

        System.out.print("Введіть ширину корисних даних pic_width: ");
        int picWidth = input.nextInt();

        System.out.print("Введіть висоту корисних даних pic_height: ");
        int picHeight = input.nextInt();

        System.out.print("Введіть позицію X корисних даних pic_x: ");
        int picX = input.nextInt();

        System.out.print("Введіть позицію Y корисних даних pic_y: ");
        int picY = input.nextInt();

        input.close();

        int[][] source = insertSource(frameHeight, frameWidth);

        int[][] destination = new int[frameHeight][frameWidth];
        for(int i = 0; i < picHeight; i++){
            for (int j = 0; j < picWidth; j++){
                destination[i][j] = source[picY + i][picX + j];
            }
        }

        System.out.println("Початковий масив (Source):");
        print(source, frameHeight, frameWidth);

        System.out.println("\nПеретворений масив (Destination):");
        print(destination, frameHeight, frameWidth);
    }

    private static int[][] insertSource(int frameHeight, int frameWidth){
        int[][] source = new int[frameHeight][frameWidth];
        Random random = new Random();
        for (int i = 0; i < frameHeight; i++) {
            for (int j = 0; j < frameWidth; j++) {
                source[i][j] = random.nextInt(9); // Випадкові значення від 0 до 255
            }
        }

        return source;
    }

    private static void print(int[][] source, int frameHeight, int frameWidth){
        for (int i = 0; i < frameHeight; i++) {
            for (int j = 0; j < frameWidth; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
    }
}
