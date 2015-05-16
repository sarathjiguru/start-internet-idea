angular.module('starter.services', [])

.factory('Chats', function() {
    // Might use a resource here that returns a JSON array

    // Some fake testing data
    var chats = [{
        id: 0,
        name: 'Ben Sparrow',
        lastText: 'You on your way?',
        face: 'https://pbs.twimg.com/profile_images/514549811765211136/9SgAuHeY.png'
    }, {
        id: 1,
        name: 'Max Lynx',
        lastText: 'Hey, it\'s me',
        face: 'https://avatars3.githubusercontent.com/u/11214?v=3&s=460'
    }, {
        id: 2,
        name: 'Andrew Jostlin',
        lastText: 'Did you get the ice cream?',
        face: 'https://pbs.twimg.com/profile_images/491274378181488640/Tti0fFVJ.jpeg'
    }, {
        id: 3,
        name: 'Adam Bradleyson',
        lastText: 'I should buy a boat',
        face: 'https://pbs.twimg.com/profile_images/479090794058379264/84TKj_qa.jpeg'
    }, {
        id: 4,
        name: 'Perry Governor',
        lastText: 'Look at my mukluks!',
        face: 'https://pbs.twimg.com/profile_images/491995398135767040/ie2Z_V6e.jpeg'
    }];

    return {
        all: function() {
            return chats;
        },
        remove: function(chat) {
            chats.splice(chats.indexOf(chat), 1);
        },
        get: function(chatId) {
            for (var i = 0; i < chats.length; i++) {
                if (chats[i].id === parseInt(chatId)) {
                    return chats[i];
                }
            }
            return null;
        }
    }
})

/**
 * A simple example service that returns some data.
 */
.factory('Friends', function() {
    // Might use a resource here that returns a JSON array

    // Some fake testing data
    // Some fake testing data
    var friends = [{
        id: 0,
        name: 'Ben Sparrow',
        notes: 'Enjoys drawing things',
        face: 'https://pbs.twimg.com/profile_images/514549811765211136/9SgAuHeY.png'
    }, {
        id: 1,
        name: 'Max Lynx',
        notes: 'Odd obsession with everything',
        face: 'https://avatars3.githubusercontent.com/u/11214?v=3&s=460'
    }, {
        id: 2,
        name: 'Andrew Jostlen',
        notes: 'Wears a sweet leather Jacket. I\'m a bit jealous',
        face: 'https://pbs.twimg.com/profile_images/491274378181488640/Tti0fFVJ.jpeg'
    }, {
        id: 3,
        name: 'Adam Bradleyson',
        notes: 'I think he needs to buy a boat',
        face: 'https://pbs.twimg.com/profile_images/479090794058379264/84TKj_qa.jpeg'
    }, {
        id: 4,
        name: 'Perry Governor',
        notes: 'Just the nicest guy',
        face: 'https://pbs.twimg.com/profile_images/491995398135767040/ie2Z_V6e.jpeg'
    }];


    return {
        all: function() {
            return friends;
        },
        get: function(friendId) {
            // Simple index lookup
            return friends[friendId];
        }
    }
})

.factory('DeviceReady', function() {
    var device_model = 'model was not fetched';
    var push_id = "<dummy registration id to be fetched from gcm>";
    var pushSuccessHandler = function(result) {
        console.log("push success: "+result);
    };
    var pushErrorHandler = function(error) {
        console.log("error: " + error);
    };
    registerDevice = function() {
        try {
            var pushNotification = window.plugins.pushNotification;
            if (window.device.platform == 'android' || device.platform == 'Android') {
                pushNotification.register(
                    pushSuccessHandler,
                    pushErrorHandler, {
                        "senderID": "633490653769",
                        "ecb": "onNotificationGCM"
                    }
                );
            }
        } catch (err) {
            console.log("error: " + err);
        }
    };

    return {
        waitForDevice: function() {
            document.addEventListener("deviceready", this.ready, false);
        },
        ready: function() {
            registerDevice();
            device_model = device.model;
        },
        model: function() {
            return device_model;
        },
        getID: function(){
            return push_id;
        },
        registerID: function(id) {
            push_id = id;
            //Insert code here to store the user's ID on your notification server. 
            //You'll probably have a web service (wrapped in an Angular service of course) set up for this.  
            //For example:
            //console.log("from registerId: "+ id);
            
        },
    }
});

window.onNotificationGCM = function(e) {
    switch (e.event) {
        case 'registered':
            {
                push_id = e.regid;
                var elem = angular.element(document.querySelector('[ng-app]'));
                var injector = elem.injector();
                var myService = injector.get('DeviceReady');
                myService.registerID(e.regid);
                break;
            }
    }
};
