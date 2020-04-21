/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Location that = (Location) obj;

        if (xCoord == that.xCoord && yCoord == that.yCoord) return true;
        return false;  
    }

    @Override
    public int hashCode()
    {
        int result = 0;
        
        result = 31 * result + xCoord;
        result = 31 * result + yCoord;

        return result;
    }
}