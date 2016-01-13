// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('papperandplastic', ['ionic'])

  .run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      if (window.cordova && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      }
      if (window.StatusBar) {
        // org.apache.cordova.statusbar required
        StatusBar.styleDefault();
      }
    });
  })

  .config(function ($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider

      .state('tab', {
        url: '/tabs',
        templateUrl: 'paperandplastic.html'
      })

      .state('tab.history', {
        url: '/history',
        templateUrl: 'history-tab.html'
      })

      .state('tab.schedule', {
        url: '/schedule',
        templateUrl: 'book-tab.html'
      })

      .state('profile', {
        url: '/profile',
        templateUrl: 'profile.html'
      })

      .state('signup', {
        url: '/signup',
        templateUrl: 'signup.html'
      })

      .state('booked', {
        url: '/booked',
        templateUrl: 'bookinginfo.html'
      })
    ;

    // if none of the above states are matched, use this as the fallback

    $urlRouterProvider.otherwise('/tabs');


  })

  .config(['$ionicConfigProvider', function ($ionicConfigProvider) {

    $ionicConfigProvider.tabs.position('bottom'); // other values: top

  }]);

