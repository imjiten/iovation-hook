package com.jestro.iovation;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.content.Context;
import org.json.JSONException;
import com.iovation.mobile.android.FraudForceConfiguration;
import com.iovation.mobile.android.FraudForceManager;

public class IovationHook extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getBlackboxData")) {

            Context context = this.cordova.getActivity().getApplicationContext();

            FraudForceConfiguration configuration = new FraudForceConfiguration.Builder()
                .subscriberKey("STRING")
                .enableNetworkCalls(true) // Defaults to false if left out of configuration
                .build();

            FraudForceManager fraudForceManager = FraudForceManager.getInstance();
            
            fraudForceManager.initialize(configuration, context);

            String blackbox = FraudForceManager.getInstance().getBlackbox(context);
            callbackContext.success(blackbox);

            return true;

        } else {
            
            return false;

        }
    }
}
