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
    System.out.println("px antes das contas: " + px + " py antes das contas: " + py);
    System.out.println("qx antes das contas: " + qx + " qy antes das contas: " + qy);

    // distancia de PQ
    double raizX = (double) Math.pow((qx - px), 2);
    System.out.println("quadradoX: " + raizX);
    double raizY = (double) Math.pow((qy - py), 2);
    System.out.println("quadradoY: " + raizY);
    double dist = Math.sqrt(raizX + raizY);
    System.out.println("dist: " + dist);

    if (dist < l)
      drawLine(px, py, qx, qy); // desenha o segmento PQ
    else {
      // calculando A
      double RAx = calcPontos(px, qx, 1.0 / 3.0);
      double RAy = calcPontos(py, qy, 1.0 / 3.0);
      System.out.println("RAx " + RAx + " RAy: " + RAy);

      // calculando C
      double RCx = calcPontos(px, qx, 2.0 / 3.0);
      double RCy = calcPontos(py, qy, 2.0 / 3.0);
      System.out.println("RCx " + RCx + " RAy: " + RCy);

      // ponto medio de PQ
      double Mx = calcPontos(px, qx, 1.0 / 2.0);
      double My = calcPontos(py, qy, 1.0 / 2.0);
      System.out.println("Mx " + Mx + " My: " + My);

      double vx = (double) qx - (double) px;
     
      double vy = (double) qy - (double) py;

      double rvx = vy;

      double rvy = -vx;

      double ux = rvx * Math.sqrt(3) / 6.0;
      double uy = rvy * Math.sqrt(3) / 6.0;


      double BxDb = Mx + ux;
      double ByDb = My + uy;
      // rv = vetor penperdicular a v
      // double rv = 
      //     Math.sqrt(Math.pow(((double) qy - (double) py), 2) 
      //   + (Math.pow(((double) qx - (double) px * -1.0), 2)));
      // System.out.println("rv: " + rv);

      // // u = vetor que liga M a B
      // double u = (Math.abs(rv) * Math.sqrt(3)) / 6.0;
      // System.out.println("u " + u);

      // double BxDb =  Math.abs(((Math.sqrt(3)*RAx+ 2*Mx)/2)+Math.sqrt(3));
      // double ByDb =  Math.abs(((Math.sqrt(3)*RAy+ 2*My)/2)+Math.sqrt(3));
      System.out.println("BxDb " + BxDb + " ByDb: " + ByDb);

      int Ax = (int) Math.round(RAx);
      int Ay = (int) Math.round(RAy);
      int Bx = (int) Math.round(BxDb);
      int By = (int) Math.round(ByDb);
      int Cx = (int) Math.round(RCx);
      int Cy = (int) Math.round(RCy);

      System.out.println("Ax " + Ax + " Ay: " + Ay);
      System.out.println("Bx " + Bx + " By: " + By);
      System.out.println("Cx " + Cx + " Cy: " + Cy);
      System.out.println("px " + px + " py: " + py);
      System.out.println("qx " + qx + " qy: " + qy);

      drawLine(px, py, Ax, Ay);
      drawLine(Ax, Ay, Bx, By);
      drawLine(Bx, By, Cx, Cy);
      drawLine(Cx, Cy, qx, qy);

      kochCurve(px, py, Ax, Ay, l);
      kochCurve(Ax, Ay, Bx, By, l);
      kochCurve(Bx, By, Cx, Cy, l);
      kochCurve(Cx, Cy, qx, qy, l);
    }
  }

  public void regionFill(int x, int y, int reference_rgb) {

  }
}