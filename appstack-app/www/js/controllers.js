angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {})

.controller('ChatsCtrl', function($scope, Chats) {
  $scope.chats = Chats.all();
  $scope.remove = function(chat) {
    Chats.remove(chat);
  }
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('FriendsCtrl', function($scope, Friends) {
  $scope.friends = Friends.all();
})

.controller('FriendDetailCtrl', function($scope, $stateParams, Friends) {
  $scope.friend = Friends.get($stateParams.friendId);
})

.controller('AccountCtrl', function($scope,$http, DeviceReady) {
  $scope.settings = {
    enableFriends: true
  };
  DeviceReady.waitForDevice();
  
  console.log(DeviceReady.model());
  $scope.model = DeviceReady.model();

  $scope.signUp = function(user_name){
      //get registration id for the first time
      $http.post('http://x-d.link/signup', {'id': user_name,'device_model': $scope.model})
          .success(function(data, status, headers, config){
              console.log('status' + status);
              setTimeout(function(){
                console.log("from controllers: "+DeviceReady.getID());
                $http.get('http://x-d.link/googleid?id='+user_name+"&registration_id="+DeviceReady.getID())
                  .success(function(data, status, headers, config) {
                    console.log(data)
                })
                  .error(function(data, status, headers, config) {
                    console.log(data)
            });
  },5000);
          })
          .error(function (data,status){
              console.log('in error');
              console.log('status' + status);
          });
  }

  //As of now waiting to get google id from its servers on function onNotificationGCM in services method. Should come up with promise approach

});
