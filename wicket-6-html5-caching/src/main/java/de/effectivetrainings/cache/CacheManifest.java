package de.effectivetrainings.cache;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 10:35
 */
public class CacheManifest {

    private Map<CacheManifestKeys, List<String>> manifestEntries = new HashMap<CacheManifestKeys, List<String>>();

    private static final String CACHE_PLACEHOLDER = "#cacheEntries";
    private static final String NETWORK_PLACEHOLDER = "#networkEntries";
    private static final String FALLBACK_PLACEHOLDER = "#fallbackEntries";


    public CacheManifest(){
        manifestEntries.put(CacheManifestKeys.CACHE, new ArrayList<String>());
        manifestEntries.put(CacheManifestKeys.FALLBACK, new ArrayList<String>());
        manifestEntries.put(CacheManifestKeys.NETWORK, new ArrayList<String>());
    }

    public void addEntry(CacheManifestEntry entry){
        if(entry.isEnabled()){
            manifestEntries.get(entry.getKey()).add(entry.getValue());
        }
    }

    public String get(String manifestTemplate){
        manifestTemplate = manifestTemplate.replace(CACHE_PLACEHOLDER,joinString(CacheManifestKeys.CACHE));
        manifestTemplate = manifestTemplate.replace(NETWORK_PLACEHOLDER,joinString(CacheManifestKeys.NETWORK));
        manifestTemplate = manifestTemplate.replace(FALLBACK_PLACEHOLDER,joinString(CacheManifestKeys.FALLBACK));
        return manifestTemplate;
    }

    private String joinString(CacheManifestKeys cacheKey) {
        if(manifestEntries.get(cacheKey).isEmpty()){
            //return just a comment or * in case of network
            return CacheManifestKeys.NETWORK.equals(cacheKey) ? "*" : "#";
        }
        return StringUtils.join(manifestEntries.get(cacheKey).iterator(), '\n');
    }


}
