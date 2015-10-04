angular.module('starter.services', [])

    .factory('Chats', function ($q) {
        // Might use a resousrce here that returns a JSON array
        var chats = []
        // Some fake testing data
        return {
            all: function () {
                var deffered = $q.defer();
                var success = function (message) {
                    console.log("message: "+ message);
                    deffered.resolve(message);
                    console.log("deffered:" +Object.getOwnPropertyNames(deffered.promise))
                    return deffered.promise;
                }

                var failure = function () {
                    message= "Error calling Hello Plugin";
                    console.log(message);
                    deffered.reject(message);
                    return deffered.promise;
                }

                hello.greet("World", success, failure);
                return deffered.promise;

            },
            remove: function (chat) {
                chats.splice(chats.indexOf(chat), 1);
            },
            get: function (chatId) {
                for (var i = 0; i < chats.length; i++) {
                    if (chats[i].id === parseInt(chatId)) {
                        return chats[i];
                    }
                }
                return null;
            }
        };
    });
