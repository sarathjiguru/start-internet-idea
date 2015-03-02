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

.controller('AccountCtrl', function($scope, $http, DeviceReady) {
  $scope.settings = {
    enableFriends: true
  };
  DeviceReady.waitForDevice();
  console.log(DeviceReady.model());
  $scope.model = DeviceReady.model();
  $scope.signUp = function(){
      //get registration id for the first time
      $http.post('http://x-d.link/signup', {'uname': "ur_name",'model': $scope.model})
          .success(function(data, status, headers, config){
              console.log('status' + status);
          })
          .error(function (data,status){
              console.log('in error');
              console.log('status' + status);
          });
  }
});
