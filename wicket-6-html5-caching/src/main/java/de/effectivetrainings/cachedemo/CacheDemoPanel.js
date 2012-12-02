/**
 * Created with IntelliJ IDEA.
 * User: martindilger
 * Date: 02.12.12
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function () {
    if (window.applicationCache) {
        var cache = window.applicationCache;
        $(".cacheEnabled").html("Ihr Browser unterstützt Html5 Caching");

        switch(cache.status){
            case cache.UPDATEREADY:
        }
        var status = cacheStatus();
        $(".cacheStatus").html("Status: " + status);

        var onlineState = navigator.onLine ? "online" : "offline";

        $manifest  = $("html").attr("manifest");

        readManifest($manifest);

        $(".manifestUri").html($manifest);
        $(".manifestUri").click(function(){
            alert(location.host+"/"+$manifest);
        });
    }



});
window.addEventListener('load', function(e) {

    window.applicationCache.addEventListener('updateready', function(e) {
        if (window.applicationCache.status == window.applicationCache.UPDATEREADY) {
            // Browser downloaded a new app cache.
            // Swap it in and reload the page to get the new hotness.
            window.applicationCache.swapCache();
            if (confirm('A new version of this site is available. Load it?')) {
                window.location.reload();
            }
        } else {
            // Manifest didn't changed. Nothing new to server.
        }
    }, false);

}, false);


function readManifest($uri){
    $('.manifest').load($uri);
}

function cacheStatus(){
    var appCache = window.applicationCache;
    switch (appCache.status) {
        case appCache.UNCACHED: // UNCACHED == 0
            return 'nichts gecached';
            break;
        case appCache.IDLE: // IDLE == 1
            return 'nichts zu tun';
            break;
        case appCache.CHECKING: // CHECKING == 2
            return 'prüft';
            break;
        case appCache.DOWNLOADING: // DOWNLOADING == 3
            alert("loading")
            return 'lädt';
            break;
        case appCache.UPDATEREADY:  // UPDATEREADY == 4
            alert("bereit zum update");
            return 'bereit zum update';
            break;
        case appCache.OBSOLETE: // OBSOLETE == 5
            return 'obsolet';
            break;
        default:
            return 'unbekannt';
            break;
    };

}