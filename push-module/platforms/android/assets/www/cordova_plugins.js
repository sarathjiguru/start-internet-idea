cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/org.jboss.aerogear.cordova.push/www/aerogear.ajax.js",
        "id": "org.jboss.aerogear.cordova.push.AeroGear.ajax",
        "clobbers": [
            "ajax"
        ]
    },
    {
        "file": "plugins/org.jboss.aerogear.cordova.push/www/aerogear-push.js",
        "id": "org.jboss.aerogear.cordova.push.AeroGear.UnifiedPush",
        "clobbers": [
            "push"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.device/www/device.js",
        "id": "org.apache.cordova.device.device",
        "clobbers": [
            "device"
        ]
    },
    {
        "file": "plugins/com.vladstirbu.cordova.promise/www/promise.js",
        "id": "com.vladstirbu.cordova.promise.Promise",
        "clobbers": [
            "Promise"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "org.jboss.aerogear.cordova.push": "1.0.2",
    "org.apache.cordova.device": "0.2.13",
    "com.vladstirbu.cordova.promise": "1.0.0",
    "android.support.v4": "1.0.0",
    "com.google.playservices": "19.0.0"
}
// BOTTOM OF METADATA
});