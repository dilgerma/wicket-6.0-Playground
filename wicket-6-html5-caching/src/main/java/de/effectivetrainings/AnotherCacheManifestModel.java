package de.effectivetrainings;

import de.effectivetrainings.cache.CacheManifest;
import de.effectivetrainings.cache.CacheManifestEntry;
import de.effectivetrainings.cache.CacheManifestKeys;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 18:07
 */
public class AnotherCacheManifestModel extends AbstractReadOnlyModel<CacheManifest> {


    @Override
    public CacheManifest getObject() {
        CacheManifest manifest = new CacheManifest();
        return manifest;
    }
}
