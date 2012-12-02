package de.effectivetrainings.cache;

import org.apache.wicket.markup.html.PackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;

import java.util.Set;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 10:09
 */
public class Html5CacheAwarePackageResourceGuard extends SecurePackageResourceGuard {

    public Html5CacheAwarePackageResourceGuard() {
       addPattern("+*.manifest");
    }
}
