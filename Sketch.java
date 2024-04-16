import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * @author H. Rahukulan
 *
 */

public class Sketch extends PApplet {

  PImage imgMonkey;

  // x and y coordinates for the monkey image
  float fltMonkeyX = 0;
  float fltMonkeyY = 0;

  // monkey image speed varibles
  float fltXSpeed = 3;
  float fltYSpeed = 5;

  // define colours
  int Black = color(0);

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(210, 255, 173);
    background(Black);
    // load meteor
    imgMonkey = loadImage("monkey-png-25.png");
    // resize meteor
    imgMonkey.resize(50, 50);
  }

  public void draw() {
    background(Black);

    // draw meteor and postion
    image(imgMonkey, fltMonkeyX, fltMonkeyY);

    fltMonkeyX += fltXSpeed;
    fltMonkeyY += fltYSpeed;

    if (fltMonkeyX > width - imgMonkey.width || fltMonkeyX < 0) {
      fltXSpeed *= -1;
      
    }
    if (fltMonkeyY > height - imgMonkey.height || fltMonkeyY < 0) {
      fltYSpeed *= -1;
    }
  }

}