/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan;

// Concentrate on recursion
public class HTree {




    class Main {
        static public void main( String args[] ) {
            System.out.println( "Practice makes Perfect!" );
        }
    }

/*
DraHtree (x=3, y=3, length=1, depth=1)

DrawLine()

3,3


*/

    public void drawHTree(int x, int y, int length, int depth){
        if(depth==0){
            return;
        }


        int horizontalStartX= x - (length/2);
        int horizontalEndX= horizontalStartX + length;

    /*    int verticalStartDownY= y - (length/2);
        int verticalStartUpY= verticalStartLeftDownY + length;



        drawLine(x1,y1,x1,y2);
        drawLine(x1,y1,x2,y1);
        drawLine(x2,y1,x2,y2);

        length=Math.sqrt(length,2);

        drawHTree(depth--)
        drawHTree()
        drawHTree()
        drawHTree()*/
    }

    public void drawLine(int startX,int startY,int endX,int endY){

        System.out.println(startX + " startX" + startY + " startY" + endX + "endX" + endY+ "endY");
    }

}
