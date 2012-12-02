package de.effectivetrainings;

import de.effectivetrainings.cache.CacheManifest;
import de.effectivetrainings.cache.CacheManifestEntry;
import de.effectivetrainings.cache.CacheManifestKeys;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.util.time.Time;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 13:12
 */
public class CacheManifestModel extends AbstractReadOnlyModel<CacheManifest> {


    @Override
    public CacheManifest getObject() {
        CacheManifest manifest = new CacheManifest();
        manifest.addEntry(new CacheManifestEntry(CacheManifestKeys.CACHE,"/start.html"));
        manifest.addEntry(new CacheManifestEntry(CacheManifestKeys.CACHE, "http://svn.apache.org/repos/asf/wicket/sandbox/dashorst/animation/logo-top.png"));
        manifest.addEntry(new CacheManifestEntry(CacheManifestKeys.FALLBACK,"/online.png","/offline.png"));
        return manifest;
    }
}
