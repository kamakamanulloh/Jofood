package com.jofood.jombangan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jofood.jombangan.Activity.LoginActivity;
import com.jofood.jombangan.Activity.MainActivity;
import com.jofood.jombangan.Activity.RegisterActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.helper.PermissionHelper;

public class SplashActivity extends AppCompatActivity {
    PermissionHelper permissionHelper;
    @BindView(R.id.tvhai)
    TextView tvhai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strDate = "Current Time : " + mdformat.format(calendar.getTime());
        tvhai.setText(strDate);

//        checkAndRequestPermissions();
    }
//    public void getCurrentTime(View view) {
//       ;
//
//    }
//
//    private void display(String num) {
//
//    }
//    private boolean checkAndRequestPermissions() {
//        permissionHelper.permissionListener(new PermissionHelper.PermissionListener() {
//            @Override
//            public void onPermissionCheckDone() {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        permissionHelper.checkAndRequestPermissions();
//
//        return true;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        permissionHelper.onRequestCallBack(requestCode, permissions, grantResults);
//    }
}