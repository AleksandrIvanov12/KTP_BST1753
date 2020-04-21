import static java.lang.Math.*;

public class Point3d
{
	//Coordinates X Y Z
	private double xCoord;
	private double yCoord;
	private double zCoord;

	//Constructor
	public Point3d (double x, double y, double z)
	{
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}

	//Default constructor
	public Point3d ()
	{
		this(0.0, 0.0, 0.0);
	}

	//Returns X
	public double getX()
	{
		return xCoord;
	}

	//Returns Y
	public double getY()
	{
		return yCoord;
	}

	//Returns Z
	public double getZ()
	{
		return zCoord;
	}

	//Sets X new value
	public void setX(double val)
	{
		xCoord = val;
	}

	//Sets Y new value
	public void setY(double val)
	{
		yCoord = val;
	}

	//Sets Z new value
	public void setZ(double val)
	{
		zCoord = val;
	}

	//Compares two points
	public boolean equals(Object obj)
	{
		if (obj.getClass() == Point3d.class)
		{
			Point3d pt = (Point3d) obj;
			return (xCoord == pt.getX() && yCoord == pt.getY() && zCoord == pt.getZ());
		}

		return false;
	}

	//Distance between points
	public double distanceTo(Point3d pt)
	{
		double distance = 0;

		double deltaX = xCoord - pt.getX();
		double deltaY = yCoord - pt.getY();
		double deltaZ = zCoord - pt.getZ();

		distance = sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

		distance = floor(distance * 100) / 100;

		return distance;
	}
}