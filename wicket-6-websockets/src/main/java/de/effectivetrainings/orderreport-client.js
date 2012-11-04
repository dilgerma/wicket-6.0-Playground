$(document).ready(function() {


    Wicket.Event.subscribe("/websocket/open", function(jqEvent) {

    });



    Wicket.Event.subscribe("/websocket/message", function(jqEvent, message) {
        var json = JSON.parse(message);
        for(i in json){
            $('#'+json[i].name).html(json[i].value);
        }
        $('.visualize').trigger('visualizeRefresh');
    })


});