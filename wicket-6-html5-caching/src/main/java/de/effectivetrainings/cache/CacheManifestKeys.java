package de.effectivetrainings.cache;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 10:37
 */
public enum CacheManifestKeys {

    CACHE("CACHE"),NETWORK("NETWORK"),FALLBACK("FALLBACK");
    private String key;

    private CacheManifestKeys(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }
}
