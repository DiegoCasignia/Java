package calculatearea;

/**
 *
 * @author Diego Casignia
 */
public class GeometricFigures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean finish = false;
        do {
            System.out.println("""
                             CALCULATE AREA
                             1. Circle
                             2. Rectangle
                             3. Exit""");
           switch (Validation.enterInteger("Option: ")) {
                    case 1:
                        double radius = Validation.enterDecimal("Enter radius: ");
                        Circle circle = new Circle(radius);
                        System.out.println("Area of the circle: " + circle.calculateArea());
                        break;
                    case 2:
                        double length = Validation.enterDecimal("Enter length: ");
                        double width = Validation.enterDecimal("Enter width: ");
                        Rectangle rectangle = new Rectangle(length, width);
                        System.out.println("Area of the rectangle: " + rectangle.calculateArea());
                        break;
                    case 3:
                        finish = true;
                        break;
                    default:
                        break;
                }
        } while (!finish);
    }
}
