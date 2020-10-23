/*global cordova, module*/

module.exports = {
    getBlackboxData: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "IovationHook", "getBlackboxData", [name]);
    }
};
