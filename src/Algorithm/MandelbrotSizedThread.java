package Algorithm;

public class MandelbrotSizedThread extends Thread{
    public int begin;
    public int end;
    public int width;
    public Long timeBegin;
    public Long timeEnd;
    public MandelbrotSizedThread(int begin, int end, int width) {
        this.begin = begin;
        this.end = end;
        this.width = width;
        timeBegin =System.nanoTime();
    }


    @Override
    public void run() {
    while(Mandelbrot.nbLineDone<Mandelbrot.taille){
        synchronized (Mandelbrot.nbLineDone){
            setBegin(Mandelbrot.nbLineDone);
            setEnd(Mandelbrot.nbLineDone+1);
            Mandelbrot.nbLineDone++;
        }
        for (int i = 0; i < width; i++) {
            for (int j = begin; j < end; j++) {
                Mandelbrot.colorierPixel(i,j) ;
            }
            //Mandelbrot.image.show();
        }

    }


        timeEnd=System.nanoTime();
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
