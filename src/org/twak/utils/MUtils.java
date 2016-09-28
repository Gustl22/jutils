package org.twak.utils;

import java.awt.Color;
import java.awt.geom.Point2D;
import javax.vecmath.Point2d;
import javax.vecmath.Tuple2d;
import javax.vecmath.Vector2d;
import static java.lang.Math.*;

/**
 *
 * @author twak
 */
public class MUtils
{

    public static Color[] rainbow = new Color[]
    {
        Color.red,
        Color.orange,
        Color.yellow,
        Color.green,
        Color.cyan,
        Color.blue,
        Color.magenta
    };

    public static double clamp( double a, double min, double max )
    {
        return a < min ? min : a > max ? max : a;
    }
    
    public static float clamp( float a, float min, float max )
    {
    	return a < min ? min : a > max ? max : a;
    }

    public static int clamp( int a, int min, int max )
    {
        return a < min ? min : a > max ? max : a;
    }

    public static double interiorAngle( Vector2d a, Vector2d b )
    {
        if ( cross( b, a ) >= -10E-15 )
            return PI - a.angle( b );
        else
            return 2 * PI - a.angle( b );
    }

    public static double interiorAngleBetween( Tuple2d a, Tuple2d b, Tuple2d c )
    {
        Vector2d left = new Vector2d( b );
        Vector2d right = new Vector2d( c );
        left.sub( a );
        right.sub( b );
//        left.normalize();
//        right.normalize();
        return interiorAngle( left, right );
    }

    public static double cross( Tuple2d a, Tuple2d b )
    {
        return a.x * b.y - a.y * b.x;
    }

    public static boolean inRange( double query, double min, double max )
    {
        return query >= min && query <= max;
    }

    public static double min (double ... vals)
    {
        double min = Double.MAX_VALUE;
        for (double v : vals)
        {
                min = Math.min (v, min);
        }
        return min;
    }
    
    public static double max (double ... vals)
    {
        double max = -Double.MAX_VALUE;
        for (double v : vals)
        {
                max = Math.max (v, max);
        }
        return max;
    }
    
    public static int min (int ... vals)
    {
        int min = Integer.MAX_VALUE;
        for (int v : vals)
        {
                min = Math.min (v, min);
        }
        return min;
    }
    
     public static int max (int ... vals)
    {
        int max = Integer.MIN_VALUE;
        for (int v : vals)
        {
                max = Math.max (v, max);
        }
        return max;
    }

    public static Integer clip( int a, int min, int max )
    {
        return a < min ? null : a > max ? null : a;
    }

    public static Point2D.Double toAWT(Point2d pt)
    {
        return new Point2D.Double ( pt.x, pt.y );
    }

    public static Point2d toVecmath(Point2D.Double pt)
    {
        return new Point2d ( pt.x, pt.y );
    }
}
