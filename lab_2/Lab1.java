import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;

public class Lab1
{
	//Read input from console

	public static double getInput()
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String s = br.readLine();
			double d = Double.parseDouble(s);

		return d;
		}

		// Set value 0.0 if theres blank input

		catch (NumberFormatException e) 
		{
                return 0.0;
        }
        
        
		catch (IOException exc)
		{
			return 0.0;
		}



	}

	//Computes are of triangle
	private static double computeArea(Point3d p1, Point3d p2, Point3d p3) 
	{
		//Heron's formula

    	double a = p1.distanceTo(p2);
    	double b = p2.distanceTo(p3);
    	double c = p1.distanceTo(p3);

    	double p = (a + b + c) / 2;

    	double s = sqrt(p * (p - a) * (p - b) * (p - c));

    	return s;
    }

	public static void main(String[] args)
	{	
		//Read values

		System.out.println("Input Point 1's coordinates:");
		double point1X = getInput();
    	double point1Y = getInput();
    	double point1Z = getInput();

    	System.out.println("Input Point 2's coordinates:");
		double point2X = getInput();
    	double point2Y = getInput();
    	double point2Z = getInput();

    	System.out.println("Input Point 3's coordinates:");
		double point3X = getInput();
    	double point3Y = getInput();
    	double point3Z = getInput();

    	//Set values to points

    	Point3d point1 = new Point3d(point1X, point1Y, point1Z);
    	Point3d point2 = new Point3d(point2X, point2Y, point2Z);
    	Point3d point3 = new Point3d(point3X, point3Y, point3Z);

    	//If two points are equal, output error else print area of the triangle

    	if (point1.equals(point2) || point2.equals(point3) || point1.equals(point3))
    	{
    		System.out.println("Two points are equal; not computing area");
    		return;
    	}
    	else
    	{
    		String result = String.format("The area is %f", computeArea(point1, point2, point3));
    		System.out.println(result);
    	}
	}
}