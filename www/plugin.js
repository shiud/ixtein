
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MainPlugin';

var MainPlugin = {
  echo: function(phrase, cb) {
    exec(cb, null, PLUGIN_NAME, 'echo', [phrase]);
  },
  getDate: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getDate', []);
  },
  main: function(method, params, cb) {
    exec(cb, null, PLUGIN_NAME, 'main', [method, params]);
  },
  device: function(method, params, cb) {
    exec(cb, null, PLUGIN_NAME, 'device', [method, params]);
  },
  directupdate: function(method, params, cb) {
    exec(cb, null, PLUGIN_NAME, 'directupdate', [method, params]);
  },
  security: function(method, params, cb) {
    exec(cb, null, PLUGIN_NAME, 'security', [method, params]);
  }
};

module.exports = MainPlugin;
