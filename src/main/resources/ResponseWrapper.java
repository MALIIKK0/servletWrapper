import javax.servlet.*;
import java.util.*;
class ResponseWrapper extends ServletResponseWrapper
{
    public ResponseWrapper(ServletResponse res)
    {
        //Calling the ServletResponseWrapper superclass constructor i.e. ServletResponse interface.
        super (res);
    }

    public Locale getLocale ()
    {
        System.out.println ("Wrapper class called by Filter");

        //Calling the superclass method i.e. ServletResponse's getLocale() method.
        Locale loc = super.getLocale ();

        String country = loc.getCountry ();
        String language = loc.getLanguage ();

        if (!country.equals ("US"))
        {
            Locale loc1 = new Locale ("English, US");
            loc = loc1;
        }

        System.out.println (country);
        System.out.println (language);
        return loc;
    }
}