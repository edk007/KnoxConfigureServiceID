package com.edtest.knoxconfigureserviceid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.samsung.android.knox.EnterpriseDeviceManager;
import com.samsung.android.knox.deviceinfo.DeviceInventory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView;
        textView = findViewById(R.id.textView);

        EnterpriseDeviceManager edm = EnterpriseDeviceManager.getInstance(this);
        DeviceInventory deviceInventoryPolicy = edm.getDeviceInventory();

        String a = deviceInventoryPolicy.getDeviceOS();
        Log.w("SERViCE_ID", "DEVICE_OS: " + a);
        a = deviceInventoryPolicy.getDeviceOSVersion();
        Log.w("SERViCE_ID", "OS_VERSION: " + a);
        a = deviceInventoryPolicy.getSalesCode();
        Log.w("SERViCE_ID", "SALES_CODE: " + a);

        String id = deviceInventoryPolicy.getKnoxServiceId();
        Log.w("SERVICE_ID", "SERVICE_ID: " + id);
        
        if (!TextUtils.isEmpty(id)) {
            // Knox Service ID is set
            textView.setText(id);
        } else {
            textView.setText("EMPTY_ID");
        }


    }
}