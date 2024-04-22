import processing.core.PApplet;
import processing.core.PImage;

/**
 * A program Sketch.java that draws a background monkey, a circle moving in a circle, and a monkey moving around the screen.
 * @author H. Rahukulan
 *
 */

public class Sketch extends PApplet {

  // Declare Images
  PImage imgMonkey;
  PImage imgBackground;

  // X and Y coordinates for the monkey image
  float fltMonkeyX = 40;
  float fltMonkeyY = 30;

  // Monkey image speed varibles
  float fltXMonkeySpeed = 3;
  float fltYMonkeySpeed = 5;

  // Circle coordinates
  float fltCircleX = 220;
  float fltCircleY = 150;

  // Circle image speed variables
  float fltCircleAngle;
  float fltCircleSpeed = (float) 0.3;

  // Background coordinates
  float fltBackgroundX = 0;
  float fltBackgroundY = 0;

  // Define colours
  int Black = color(0);
  int Pink = color(255, 0, 255);

  /**
  * Called once at the beginning of execution.
  */
  public void settings() {
    size(500, 500);
  }

  /** 
  * Called once at the beginning of execution.  Add initial set up
  * values here i.e background, stroke, fill etc.
  */
  public void setup() {
    background(Black);

    // Load monkey
    imgMonkey = loadImage("monkey-png-25.png");

    // Load Background
    imgBackground = loadImage("Monkey.png");

    // Resize monkey
    imgMonkey.resize(100, 100);

    // Resize Background
    imgBackground.resize(width, height);
  }

  /** 
  * Called repeatedly, anything drawn to the screen goes here
  */
  public void draw() {
    background(Black);

    // Draw background
    image(imgBackground, fltBackgroundX, fltBackgroundY);

    // Draw monkey and postion
    image(imgMonkey, fltMonkeyX, fltMonkeyY);

    fltMonkeyX += fltXMonkeySpeed;
    fltMonkeyY += fltYMonkeySpeed;

    if (fltMonkeyX > width - imgMonkey.width || fltMonkeyX < 0) {
      fltXMonkeySpeed *= -1;
    }

    if (fltMonkeyY > height - imgMonkey.height || fltMonkeyY < 0) {
      fltYMonkeySpeed *= -1;
    }

    // Draw circle and postion
    fill(Pink);

    ellipse(fltCircleX, fltCircleY, 50, 50);
    
    // Move Circle 
    fltCircleX += width / 4 * cos(fltCircleAngle) * fltCircleSpeed;
    fltCircleY += height / 4 * sin(fltCircleAngle) * fltCircleSpeed;
     
    // Make circle stay on the screen.
    fltCircleX = constrain(fltCircleX, 0, width - 25);
    fltCircleY = constrain(fltCircleY, 0, height - 25);
    fltCircleAngle += fltCircleSpeed;
  }
}