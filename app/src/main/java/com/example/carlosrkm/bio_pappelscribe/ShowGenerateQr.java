package com.example.carlosrkm.bio_pappelscribe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import butterknife.BindView;
import me.ydcool.lib.qrmodule.encoding.QrGenerator;

public class ShowGenerateQr extends AppCompatActivity {


    @BindView(R.id.img_qr_generated) ImageView mImgQrGenerated;
    private PorterDuff.Mode mXfermode = PorterDuff.Mode.SRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_generate_qr);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        mImgQrGenerated.setImageResource(R.drawable.ic_default_qr);


        try {
            Bitmap qrCode = new QrGenerator.Builder()
                        .content("KEVIN")
                        .qrSize(300)
                        .color(Color.BLACK)
                        .bgColor(Color.WHITE)
                        .encode();

            if(mImgQrGenerated != null){

                mImgQrGenerated.setImageBitmap(qrCode);
            }

        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}
