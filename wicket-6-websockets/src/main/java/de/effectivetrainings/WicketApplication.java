package de.effectivetrainings;

import de.effectivetrainings.connections.ConnectionRegistry;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see de.effectivetrainings.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
    private ConnectionRegistry registry;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
        registry = new ConnectionRegistry();
        mountPage("/report", OrderReportPage.class);
	}

    public ConnectionRegistry getRegistry(){
        return registry;
    }

    public static WicketApplication get(){
        return (WicketApplication) Application.get();
    }
}
