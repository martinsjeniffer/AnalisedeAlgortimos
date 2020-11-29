// Esqueleto da classe na qual devem ser implementadas as novas funcionalidades de desenho

public class ImageEx extends Image {

  public ImageEx(int w, int h, int r, int g, int b) {

    super(w, h, r, g, b);
  }

  public ImageEx(int w, int h) {

    super(w, h);
  }

  public static double calcPontos (double p1, double p2, double alpha) //calcula a pos dos pontos A, C e 
  {
    return ((1.0 - (alpha)) * (double) p1 + (alpha) * (double) p2);
  } 

  public void kochCurve(int px, int py, int qx, int qy, int l) {
    // distancia de PQ
    double raizX = (double) Math.pow((qx - px), 2);
    double raizY = (double) Math.pow((qy - py), 2);
    double dist = Math.sqrt(raizX + raizY);
    
    if (dist < l)
      drawLine(px, py, qx, qy); // desenha o segmento PQ
    else {
      // calculando A
      double RAx = calcPontos(px, qx, 1.0 / 3.0);
      double RAy = calcPontos(py, qy, 1.0 / 3.0);

      // calculando C
      double RCx = calcPontos(px, qx, 2.0 / 3.0);
      double RCy = calcPontos(py, qy, 2.0 / 3.0);

      // ponto medio de PQ
      double Mx = calcPontos(px, qx, 1.0 / 2.0);
      double My = calcPontos(py, qy, 1.0 / 2.0);

      double vx = (double) qx - (double) px;
     
      double vy = (double) qy - (double) py;

      double rvx = vy;

      double rvy = -vx;

      double ux = rvx * Math.sqrt(3) / 6.0;
      double uy = rvy * Math.sqrt(3) / 6.0;

      double BxDb = Mx + ux;
      double ByDb = My + uy;

      int Ax = (int) Math.round(RAx);
      int Ay = (int) Math.round(RAy);
      int Bx = (int) Math.round(BxDb);
      int By = (int) Math.round(ByDb);
      int Cx = (int) Math.round(RCx);
      int Cy = (int) Math.round(RCy);

      kochCurve(px, py, Ax, Ay, l);
      kochCurve(Bx, By, Cx, Cy, l);
      kochCurve(Ax, Ay, Bx, By, l);
      kochCurve(Cx, Cy, qx, qy, l);
    }
  }

  public void regionFill(int x, int y, int reference_rgb) {

    // caso o valor de cor do pixel (recebido como parâmetro)
    // seja o mesmo da cor original do pixel inicial (aonde se inciou o processo de preenchimento)
    // System.out.println("\ngetHeight: "+getHeight()+"\ngetWIdth: "+getWidth());
    if (getPixel(x, y) == reference_rgb) {
      // System.out.println("x: "+x+"\ny: "+y+"\nreference: "+reference_rgb+"\n");
      setPixel(x, y);
      if(x + 1 < getWidth()) regionFill(x+1, y, reference_rgb); //direita
      if(y + 1 < getHeight()) regionFill(x, y+1, reference_rgb); //cima
      if(x - 1 >= 0) regionFill(x-1, y, reference_rgb); //esquerda
      if(y - 1 >= 0)regionFill(x, y-1, reference_rgb); // baixo
    }

    //        então tal pixel é colorido e,
    //        em seguida, chamase o algoritmo recursivamente para os pixels vizinhos
    //        (à esquerda, à direita, acima e abaixo);
    // caso contrário, nada é feito.
    
    // Para obter-se a cor de um determinado pixel pode-se usar o método getPixel
    // e para colorir um pixel (com a cor previamente denida pelo método setColor) pode-se usar o método
    // setPixel (funções estas pertencentes à classe Image).
  }
}