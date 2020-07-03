package student_assignments;

/**
 *
 * @author David
 */
public class AreaAndDistributiveProp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*        
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
        9m  [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x]+[x][x][x][x][x][x][x][x][x][x][x][x]
                        8m                            12m
        */
        int length = 9;
        int width1 = 8;
        int width2 = 12;

        int area1 = length * (width1 + width2);
        int area2 = (length * width1) + (length * width2);

        if (area1 == area2) {
            System.out.printf("Length: %d\n", length);
            System.out.printf("Width1: %d\n", width1);
            System.out.printf("Width2: %d\n", width2);
            System.out.printf("Area: %d\n", area1);
        }

        /*            2m
        Find the    [x][x]
        Area of     [x][x]
        the ff:     [x][x] 5m
                    [x][x]
                    [x][x]
        [x][x][x][x][x][x][x] 2m
        [x][x][x][x][x][x][x]
                 7m           */
        length = 5;
        width1 = 2;
        area1 = length * width1;

        length = 2;
        width2 = 7;
        area2 = length * width2;

        int totalArea = area1 + area2;

        System.out.printf("Total Area %d\n", totalArea);

        /* decomposing shapes to find area                
        
               3m
            [x][x][x]
            [x][x][x]
            [x][x][x]   3m
            [x][x][x][x][x][x] 2m
        9m  [x][x][x][x][x][x]
            [x][x][x]   3m
            [x][x][x][x][x][x]
            [x][x][x][x][x][x]3m
            [x][x][x][x][x][x]   
                    6m                  */
        
        totalArea = 9*3 + 3*2 + 3*3; 
        System.out.printf("Total Area %d\n", totalArea);
        
        /*              9m
            [x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x][x]
            [x][x][x]            [x][x]
            [x][x][x]         4m [x][x]
        8m  [x][x][x]            [x][x]
            [x][x][x]     4m     [x][x]
            [x][x][x][x][x][x][x][x][x]
            [x][x][x][x][x][x][x][x][x] */
        
        totalArea = 9*8 - 4*4;
        System.out.printf("Total Area %d\n", totalArea);
        
        totalArea = 15*25 + 18*(8+20+26) + 20*20 + 15*26;
        System.out.printf("Total Area %d\n", totalArea);
        System.out.printf("Total Area %d\n", 9*8 - 2*4);
    }

}
 