/*********************************************************************/
/**   ACH2003 - Introducao a Analise de Algoritmos                  **/
/**   EACH-USP - Segundo Semestre de 2020                           **/
/**   Prof. Flavio Luiz Coutinho                                    **/
/**                                                                 **/
/**   EP1 - Recursividade aplicada a computacao grafica             **/
/**                                                                 **/
/**   Jeniffer Florinda Martins da Silva          10377966          **/
/**                                                                 **/
/*********************************************************************/

public class ImageEx extends Image {
  public ImageEx(int w, int h, int r, int g, int b) {
    super(w, h, r, g, b);
  }

  public ImageEx(int w, int h) {
    super(w, h);
  }

  /**
   * O metodo combinacaoAfim, calcula um ponto R qualquer dentro da reta
   * que vai do ponto1 ao ponto2 com o auxilio de um parametro alpha.
   * 
   * @param ponto1
   * @param ponto2
   * @param alpha
   */
  public static double combinacaoAfim(double ponto1, double ponto2, double alpha) {
    return (((1.0 - alpha) * (double) ponto1) + (alpha * (double) ponto2));
  }

  /**
   * O metodo comprimentoPQ calcula o comprimento da reta PQ por meio da
   * formula da distancia, utilizando as coordenadas de P e de Q.
   * 
   * @param px
   * @param py
   * @param qx
   * @param qy
   * @return sqrt(((qx - px) ** 2 + (qy - py) ** 2))
   */
  public static double comprimentoPQ(int px, int py, int qx, int qy) {
    double[] raiz = new double[2];
    raiz[0] = (double) Math.pow((qx - px), 2);
    raiz[1] = (double) Math.pow((qy - py), 2);
    return Math.sqrt(raiz[0] + raiz[1]);
  }

  public void kochCurve(int px, int py, int qx, int qy, int l) {
    int x = 0;
    int y = 1;

    if (comprimentoPQ(px, py, qx, qy) < l)
      drawLine(px, py, qx, qy);
    else {
      double[] pontoA = new double[2];
      pontoA[x] = Math.round(combinacaoAfim(px, qx, 1.0 / 3.0));
      pontoA[y] = Math.round(combinacaoAfim(py, qy, 1.0 / 3.0));

      double[] pontoC = new double[2];
      pontoC[x] = Math.round(combinacaoAfim(px, qx, 2.0 / 3.0));
      pontoC[y] = Math.round(combinacaoAfim(py, qy, 2.0 / 3.0));

      /**
       * Para o calculo do ponto B, precisamos das seguintes informacoes:
       *    - coordenadas do ponto Medio de PQ,
       *    - vetor que liga P ate Q ROTACIONADO,
       *    - vetor que liga o ponto Medio ao ponto B
       */
      double[] pontoMedio = new double[2];
      pontoMedio[x] = combinacaoAfim(px, qx, 1.0 / 2.0);
      pontoMedio[y] = combinacaoAfim(py, qy, 1.0 / 2.0);

      double[] rotatePQ = new double[2];
      rotatePQ[x] = (double) qy - (double) py;
      rotatePQ[y] = -((double) qx - (double) px);

      double[] MB = new double[2];
      MB[x] = rotatePQ[x] * Math.sqrt(3) / 6.0;
      MB[y] = rotatePQ[y] * Math.sqrt(3) / 6.0;

      double[] pontoB = new double[2];
      pontoB[x] = Math.round(pontoMedio[x] + MB[x]);
      pontoB[y] = Math.round(pontoMedio[y] + MB[y]);

      kochCurve(px, py, (int) pontoA[x], (int) pontoA[y], l);
      kochCurve((int) pontoB[x], (int) pontoB[y], (int) pontoC[x], (int) pontoC[y], l);
      kochCurve((int) pontoA[x], (int) pontoA[y], (int) pontoB[x], (int) pontoB[y], l);
      kochCurve((int) pontoC[x], (int) pontoC[y], qx, qy, l);
    }
  }

  public void regionFill(int x, int y, int reference_rgb) {
    if (getPixel(x, y) == reference_rgb) {
      setPixel(x, y);

      if (x + 1 < getWidth())
        regionFill(x + 1, y, reference_rgb);
      if (y + 1 < getHeight())
        regionFill(x, y + 1, reference_rgb);
      if (x - 1 >= 0)
        regionFill(x - 1, y, reference_rgb);
      if (y - 1 >= 0)
        regionFill(x, y - 1, reference_rgb);
    }
  }
}