package de.effectivetrainings.cache;

/**
 * @author martindilger
 *         Date: 02.12.12
 *         Time: 16:46
 */
public class CacheManifestEntry {

    private CacheManifestKeys key;
    private String value;
    private String fallback;

    public CacheManifestEntry(CacheManifestKeys key, String value, String fallback) {
        this.key = key;
        this.value = value;
        this.fallback = fallback != null ? fallback : "";
    }

    public CacheManifestEntry(CacheManifestKeys key, String value){
        this(key, value, null);
    }

    public boolean isEnabled() {
        return true;
    }

    public CacheManifestKeys getKey() {
        return key;
    }

    public String getValue() {
        if(CacheManifestKeys.FALLBACK.equals(key)){
            return value + " " + fallback;
        } else {
            return value;
        }
    }

}
