package Ch14_GUI_Components_P1;

import Ch13_ATM_CaseStudy_P2_OOD_Implementation.ATM;

import javax.swing.*;

/**
 * 14.18 (GUI-Based Version of the ATM Case Study) Reimplement the ATM Case Study of
 * Chapters 12–13 as a GUI-based application. Use GUI components to approximate the ATM user
 * interface shown in Fig. 12.1. For the cash dispenser and the deposit slot use JButtons labeled
 * Remove Cash and Insert Envelope. This will enable the application to receive events indicating when
 * the user takes the cash and inserts a deposit envelope, respectively.
 *
 * Command-line Shortcut: "C:\Program Files\AdoptOpenJDK\jdk-11.0.8.10-hotspot\bin\java.exe"
 * -javaagent:C:\IntelliJ-IDEA\lib\idea_rt.jar=62902:C:\IntelliJ-IDEA\bin
 * -Dfile.encoding=UTF-8
 * -classpath F:\temp\repoJava\jHTP9e\javaHTP9e\out\production\javaHTP9e Ch14_GUI_Components_P1.Ex14_18_GUI_Based_ATM
 *
 * or simply: java -classpath F:\temp\repoJava\jHTP9e\javaHTP9e\out\production\javaHTP9e Ch14_GUI_Components_P1.Ex14_18_GUI_Based_ATM
 */
public class Ex14_18_GUI_Based_ATM {

    public static void main(String[] args) {

        new ATM().run();
    }

} // end of Exercise 14.17