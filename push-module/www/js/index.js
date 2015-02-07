/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        console.log('before received event')
        console.log('printing push'+push)
        app.receivedEvent('deviceready');
	    var pushConfig = {
           pushServerURL: "https://aerogear-openbigdata.rhcloud.com/ag-push/",
           android: {
              senderID: "633490653769",
              variantID: "4406c0d4-2d65-4aa1-8446-a0b4a4d4099c",
              variantSecret: "6ad889a5-6caa-4ce4-9667-e293fbd8243c"
           }
        };
        console.log('pushConfig is '+pushConfig)
        push.register(app.onNotification, successHandler, errorHandler, pushConfig);

        function successHandler() {
            console.log('success')
        }

        function errorHandler(message) {
            console.log('error ' + message);
        }
    },
    onNotification: function(event) {
        console.log('in notification '+event)
        alert(event.alert);
    },

    // Update DOM on a Received Event
    receivedEvent: function(id) {
        var parentElement = document.getElementById(id);
        console.log(parentElement)
        var listeningElement = parentElement.querySelector('.listening');
        var receivedElement = parentElement.querySelector('.received');

        listeningElement.setAttribute('style', 'display:none;');
        receivedElement.setAttribute('style', 'display:block;');

        console.log('Received Event: ' + id);
    }
};

app.initialize();
