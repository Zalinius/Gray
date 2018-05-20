package com.company.architecture;

import java.awt.*;

public class DoubleBufferedFrame extends Frame {

    private int bufferWidth, bufferHeight;
    private Image bufferImage;
    private Graphics2D bufferGraphics;

    public DoubleBufferedFrame(String title){
        super(title);
    }

    //We are overriding this to enforce buffering
    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g){
        if(bufferWidth!=getSize().width || bufferHeight!=getSize().height || bufferImage==null || bufferGraphics==null)
            resetBuffer();

        if(bufferGraphics != null){
            //this clears the offscreen image, not the onscreen one
            bufferGraphics.clearRect(0,0,bufferWidth,bufferHeight);

            //calls the paintbuffer method with
            //the offscreen graphics as a param
            paintBuffer(bufferGraphics);

            //we finaly paint the offscreen image onto the onscreen image
            g.drawImage(bufferImage,0,0,this);
        }

    }

    public void paintBuffer(Graphics2D g){

    }

    private void resetBuffer(){
        // always keep track of the image size
        bufferWidth=getSize().width;
        bufferHeight=getSize().height;

        //    clean up the previous image
        if(bufferGraphics!=null){
            bufferGraphics.dispose();
            bufferGraphics=null;
        }
        if(bufferImage!=null){
            bufferImage.flush();
            bufferImage=null;
        }
        System.gc();

        //    create the new image with the size of the panel
        bufferImage=createImage(bufferWidth,bufferHeight);
        bufferGraphics=(Graphics2D) bufferImage.getGraphics();
    }

}
