cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/android.applist/www/hello.js",
        "id": "android.applist.hello",
        "clobbers": [
            "hello"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "android.applist": "0.1.0"
}
// BOTTOM OF METADATA
});