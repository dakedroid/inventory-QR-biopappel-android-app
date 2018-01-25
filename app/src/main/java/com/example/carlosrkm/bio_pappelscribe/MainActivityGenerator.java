package com.example.carlosrkm.bio_pappelscribe;

/**
 * Creado por dakedroid el 17/12/17.
 */

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;
import me.ydcool.lib.qrmodule.activity.QrScannerActivity;

public class MainActivityGenerator extends AppCompatActivity {

    @BindView(R.id.txt_scan_result) TextView mTxtScanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_generator);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.Main_btn_scan)
    void onScanBtnClick() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        100);

            }else {
                startActivityForResult(
                        new Intent(MainActivityGenerator.this, QrScannerActivity.class),
                        QrScannerActivity.QR_REQUEST_CODE);
            }
        }else {

            startActivityForResult(
                    new Intent(MainActivityGenerator.this, QrScannerActivity.class),
                    QrScannerActivity.QR_REQUEST_CODE);
        }


    }

    @OnClick(R.id.Main_btn_generate)
    void onGenerateBtnClick() {
        startActivity(new Intent(MainActivityGenerator.this, DemoGeneratorActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == QrScannerActivity.QR_REQUEST_CODE) {
            mTxtScanResult.setText(
                    resultCode == RESULT_OK
                            ? data.getExtras().getString(QrScannerActivity.QR_RESULT_STR)
                            : "Scanned Nothing!");
        }
    }
}