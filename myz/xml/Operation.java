package myz.xml;

import java.util.Vector;
import org.xml.sax.Attributes;

/**
 * @author Zaid
 */

public class Operation extends MYZXmlObject
{
    //Constructor
    public Operation()
    {
        m_vPoint = new Vector< Point >();
    }
    
    //Statics
     //Type
    public static final String TYPE_DISTANCE_BETWEEN_TWO_POINTS                   = "MYZDistanceBetweenTwoPoints";
    public static final String TYPE_DISTANCE_BETWEEN_TWO_LINES                    = "MYZDistanceBetweenTwoLines";
    public static final String TYPE_DISTANCE_BETWEEN_LINE_AND_POINT               = "MYZDistanceBetweenLineAndPoint";
    public static final String TYPE_DISTANCE_BETWEEN_TWO_PROJECTED_POINTS_ON_LINE = "MYZDistanceBetweenTwoProjectedPointsOnLine";
    public static final String TYPE_ANGEL_BETWEEN_THREE_POINTS                    = "MYZAngelBetweenThreePoints";
    public static final String TYPE_ANGEL_BETWEEN_TWO_LINES                       = "MYZAngelBetweenTwoLines";
    public static final String TYPE_RATIO_BETWEEN_TWO_LINES                       = "MYZRatioBetweenTwoLines";

     //Classification
    public static final String CLASSIFICATION_SKELETON = "Skeleton";
    public static final String CLASSIFICATION_1        = "1";
    
    //Members
    String m_name;
    String m_description;
    String m_classification;
    String m_type;
    double m_correctValue;
    //m_errorRange
    Vector< Point > m_vPoint;
    
    //Methods

    @Override
    public void initialize( Attributes attributes )
    {
        m_name           = getAttributeAsString( attributes , "name" );
        m_description    = getAttributeAsString( attributes , "description" );
        m_type           = getAttributeAsString( attributes , "type" );
        m_correctValue   = getAttributeAsDobule( attributes , "correctValue" );
        m_classification = getAttributeAsString( attributes , m_classification );
    }

    @Override
    public void append( MYZXmlObject xmlObject ) 
    {
        if( xmlObject instanceof Point )
            m_vPoint.addElement( (Point) xmlObject );        
    }
    
    @Override
    public String toXml()
    {
        String XML = "<Operation "
                   + setAttribute( "name" , m_name )
                   + setAttribute( "description" , m_description )
                   + setAttribute( "type" , m_type )
                   + setAttribute( "correctValue" , m_correctValue )
                   + setAttribute( "classification" , m_classification )
                   + " > ";
        for( Point point : m_vPoint )
            XML += point.toXml();
        XML += "</Operation>";
        return XML;
    }
}
