package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.*;
import javafx.scene.*;


public class MyArtsy implements Artsy {

    public MyArtsy(){}
    @Override
    public Image doCheckers(Image src1, Image src2, int size) {
        int width = (int) src1.getWidth();
        int height = (int) src1.getHeight();

        WritableImage ret = new WritableImage(width, height);
        PixelReader pr1 = src1.getPixelReader();
        PixelReader pr2 = src2.getPixelReader();
        PixelWriter pw = ret.getPixelWriter();


        Boolean b = false;
        int tempx = 0;
        for (int x = 0; x < width; ++x) {

            for (int y = 0; y < height; ++y) {
                if (y % size == 0){
		    b = !b;
		}
		    /*
		}else if (tempy == size){
                    b = !b;
		    tempy = 0;
		}else{
		    tempy++;
		    */
		try{

                if(b){
                    pw.setArgb(x, y, pr1.getArgb(x, y));
                }else{ 
                    pw.setArgb(x, y, pr2.getArgb(x, y));
                }
		}catch(Exception ex){}
            } // for
                if (tempx == size){
                    b = !b;
                    tempx = 0;
                }
           tempx++;
        } // for
    
        return ret;
    
        
    } // doCheckers

    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int size) {
        int width = (int) src1.getWidth();
        int height = (int) src1.getHeight();

        WritableImage ret = new WritableImage(width, height);
        PixelReader pr1 = src1.getPixelReader();
        PixelReader pr2 = src2.getPixelReader();
        PixelWriter pw = ret.getPixelWriter();


        Boolean b = false;
        int tempy = 0;
            for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
                if (tempy == size){
                    b = !b;
                    tempy = 0;
                }

                if(b){
                    pw.setArgb(x, y, pr1.getArgb(x, y));
                }else{ 
                    pw.setArgb(x, y, pr2.getArgb(x, y));
                }
            } // for
           tempy++;
        } // for
    
        return ret;
    
    } // doHorizontalStripes

    @Override
    public Image doRotate(Image src, double degrees) {
        double angle =(degrees * Math.PI)/ 180;
        int width = (int) src.getWidth();
        int height = (int) src.getHeight();

        WritableImage ret = new WritableImage(width, height);
        PixelReader pr = src.getPixelReader();
        PixelWriter pw = ret.getPixelWriter();


        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                double tempx = x - (width/2);
                double tempy = y - (height/2);
                

                double newx = (double)(height/2)+(tempx * Math.cos(angle) -(double)tempy * Math.sin(angle));
                double newy =  (double)(height/2)+(tempx * Math.sin(angle) +(double)tempy * Math.cos(angle));
                try{
                    pw.setArgb(x, y, pr.getArgb((int)newx,(int)newy));
                }catch(Exception ex){}
            } // for
        } // for
    
        return ret;
    } // doRotate

    @Override
    public Image doVerticalStripes(Image src1, Image src2, int size) {
        int width = (int) src1.getWidth();
        int height = (int) src1.getHeight();

        WritableImage ret = new WritableImage(width, height);
        PixelReader pr1 = src1.getPixelReader();
        PixelReader pr2 = src2.getPixelReader();
        PixelWriter pw = ret.getPixelWriter();


        Boolean b = false;
        int tempx = 0;
        int tempy = 0;
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (tempx == size){
                    b = !b;
                    tempx = 0;
                }

                if(b){
                    pw.setArgb(x, y, pr1.getArgb(x, y));
                }else{ 
                    pw.setArgb(x, y, pr2.getArgb(x, y));
                }
            } // for
         tempx++;
        } // for
    
        return ret;
    } // doVerticalStripes


} // MyArtsy


