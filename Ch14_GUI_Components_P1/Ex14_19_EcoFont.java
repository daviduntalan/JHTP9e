package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Exercise 14.19 (Ecofont) Ecofont (www.ecofont.eu/ecofont_en.html)—developed by SPRANQ (a Netherlands-
 * based company)—is a free, open-source computer font designed to reduce by as much as
 * 20% the amount of ink used for printing, thus reducing also the number of ink cartridges used and
 * the environmental impact of the manufacturing and shipping processes (using less energy, less fuel
 * for shipping, and so on). The font, based on sans-serif Verdana, has small circular “holes” in the
 * letters that are not visible in smaller sizes—such as the 9- or 10-point type frequently used. Download
 * Ecofont, then install the font file Spranq_eco_sans_regular.ttf using the instructions from
 * the Ecofont website. Next, develop a GUI-based program that allows you to type in a text string to
 * be displayed in the Ecofont. Create Increase Font Size and Decrease Font Size buttons that allow you
 * to scale up or down by one point at a time. Start with a default font size of 9 points. As you scale
 * up, you’ll be able to see the holes in the lettersmore clearly. As you scale down, the holes will be less
 * apparent. What is the smallest font size at which you begin to notice the holes?
 */
public class Ex14_19_EcoFont {

    public static void main(String[] args) {

        EcoFontFrame ecoFontFrame =  new EcoFontFrame();
        ecoFontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecoFontFrame.setSize(400, 200);
        ecoFontFrame.setLocationRelativeTo(null);
        ecoFontFrame.setVisible(true);
        /*ecoFontFrame.pack();*/
    }
}
