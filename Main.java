/*********************************************************************/
/**   ACH2003 - Introducao a Analise de Algoritmos                  **/
/**   EACH-USP - Segundo Semestre de 2020                           **/
/**   Prof. Flavio Luiz Coutinho                                    **/
/**                                                                 **/
/**   EP1 - Recursividade aplicada a computação grafica             **/
/**                                                                 **/
/**   Jeniffer Florinda Martins da Silva          10377966          **/
/**                                                                 **/
/*********************************************************************/

import java.util.*;
import java.io.*;

public class Main {
  public static void generateImage(String inputFileName, String outputFileName) throws IOException {
    Scanner scanner = new Scanner(new File(inputFileName));
    ImageEx image = new ImageEx(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    while(scanner.hasNext()){
      String command = scanner.next();

      if(command.equals("SET_COLOR")){
        image.setColor(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
      }

      if(command.equals("SET_PIXEL")){
        image.setPixel(scanner.nextInt(), scanner.nextInt());
      }

      if(command.equals("DRAW_LINE")){
        image.drawLine(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
      }

      if(command.equals("KOCH_CURVE")){
        image.kochCurve(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
      }

      if(command.equals("REGION_FILL")){
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        image.regionFill(x, y, image.getPixel(x, y));
      }
    }
    image.save(outputFileName);
  }

  public static void main(String [] args){
    if (args.length != 2) {
      System.out.println("Uso: java " + Main.class.getName() + " entrada.txt saida.png");
      System.exit(1);
    }
    try {
      generateImage(args[0], args[1]);
    } catch(IOException e) {
      System.out.println("Problem generating image... :(");
      e.printStackTrace();
    }
  }
}
