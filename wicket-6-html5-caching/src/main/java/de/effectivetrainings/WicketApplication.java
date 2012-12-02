package de.effectivetrainings;

import de.effectivetrainings.cache.Html5CacheAwarePackageResourceGuard;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.time.Time;

import java.util.Date;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 */
public class WicketApplication extends WebApplication
{

    private static final Date APPLICATION_START_TIME = Time.now().toDate();
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
        mountPage(HomePage.MOUNT_PATH, HomePage.class);
        mountPage(Another.MOUNT_PATH, Another.class);
        getResourceSettings().setPackageResourceGuard(new Html5CacheAwarePackageResourceGuard());
	}

    public static WicketApplication get(){
        return (WicketApplication) Application.get();
    }

    public Date getApplicationStartTime(){
        return APPLICATION_START_TIME;
    }
}
