package com.example.kmj.decisionthisorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

public class ItemActivity extends AppCompatActivity {

    ImageView img;
    TextView name,major,description;
    Button btn;
    int imgno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        img=(ImageView)findViewById(R.id.imgno);
        name=(TextView)findViewById(R.id.name);
        major=(TextView)findViewById(R.id.major);
        description=(TextView)findViewById(R.id.description);
        btn=(Button)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        Data data= intent.getParcelableExtra("data");
        name.setText(data.Name);
        major.setText(data.Major);
        description.setText(data.Description);
        imgno=data.Imgno;

        switch (imgno){
            case 0:
                img.setImageResource(R.drawable.i0);
                break;
            case 1:
                img.setImageResource(R.drawable.i1);
                break;
            case 2:
                img.setImageResource(R.drawable.i2);
                break;
            case 3:
                img.setImageResource(R.drawable.i3);
                break;
            case 4:
                img.setImageResource(R.drawable.i4);
                break;
            case 5:
                img.setImageResource(R.drawable.i5);
                break;
            case 6:
                img.setImageResource(R.drawable.i6);
                break;
            case 7:
                img.setImageResource(R.drawable.i7);
                break;
            case 8:
                img.setImageResource(R.drawable.i8);
                break;
            case 9:
                img.setImageResource(R.drawable.i9);
                break;
            case 10:
                img.setImageResource(R.drawable.i10);
                break;
            case 11:
                img.setImageResource(R.drawable.i11);
                break;
            case 12:
                img.setImageResource(R.drawable.i12);
                break;
            case 13:
                img.setImageResource(R.drawable.i13);
                break;
            case 14:
                img.setImageResource(R.drawable.i14);
                break;
            case 15:
                img.setImageResource(R.drawable.i15);
                break;
            case 16:
                img.setImageResource(R.drawable.i16);
                break;
            case 17:
                img.setImageResource(R.drawable.i17);
                break;
            case 18:
                img.setImageResource(R.drawable.i18);
                break;
            case 19:
                img.setImageResource(R.drawable.i19);
                break;
            case 20:
                img.setImageResource(R.drawable.i20);
                break;
            case 21:
                img.setImageResource(R.drawable.i21);
                break;
            case 22:
                img.setImageResource(R.drawable.i22);
                break;
            case 23:
                img.setImageResource(R.drawable.i23);
                break;
            case 24:
                img.setImageResource(R.drawable.i24);
                break;
            case 25:
                img.setImageResource(R.drawable.i25);
                break;
            case 26:
                img.setImageResource(R.drawable.i26);
                break;
            case 27:
                img.setImageResource(R.drawable.i27);
                break;
            case 28:
                img.setImageResource(R.drawable.i28);
                break;
            case 29:
                img.setImageResource(R.drawable.i29);
                break;
            case 30:
                img.setImageResource(R.drawable.i30);
                break;
            case 31:
                img.setImageResource(R.drawable.i31);
                break;
            case 32:
                img.setImageResource(R.drawable.i32);
                break;
            case 33:
                img.setImageResource(R.drawable.i33);
                break;
            case 34:
                img.setImageResource(R.drawable.i34);
                break;
            case 35:
                img.setImageResource(R.drawable.i35);
                break;
            case 36:
                img.setImageResource(R.drawable.i36);
                break;
            case 37:
                img.setImageResource(R.drawable.i37);
                break;
            case 38:
                img.setImageResource(R.drawable.i38);
                break;
            case 39:
                img.setImageResource(R.drawable.i39);
                break;
            case 40:
                img.setImageResource(R.drawable.i40);
                break;
            case 41:
                img.setImageResource(R.drawable.i41);
                break;
            case 42:
                img.setImageResource(R.drawable.i42);
                break;
            case 43:
                img.setImageResource(R.drawable.i43);
                break;
            case 44:
                img.setImageResource(R.drawable.i44);
                break;
            case 45:
                img.setImageResource(R.drawable.i45);
                break;
            case 46:
                img.setImageResource(R.drawable.i46);
                break;
            case 47:
                img.setImageResource(R.drawable.i47);
                break;
            case 48:
                img.setImageResource(R.drawable.i48);
                break;
            case 49:
                img.setImageResource(R.drawable.i49);
                break;
            case 50:
                img.setImageResource(R.drawable.i50);
                break;
            case 51:
                img.setImageResource(R.drawable.i51);
                break;
            case 52:
                img.setImageResource(R.drawable.i52);
                break;
            case 53:
                img.setImageResource(R.drawable.i53);
                break;
            case 54:
                img.setImageResource(R.drawable.i54);
                break;
            case 55:
                img.setImageResource(R.drawable.i55);
                break;
            case 56:
                img.setImageResource(R.drawable.i56);
                break;
            case 57:
                img.setImageResource(R.drawable.i57);
                break;
            case 58:
                img.setImageResource(R.drawable.i58);
                break;
            case 59:
                img.setImageResource(R.drawable.i59);
                break;
            case 60:
                img.setImageResource(R.drawable.i60);
                break;
            case 61:
                img.setImageResource(R.drawable.i61);
                break;
            case 62:
                img.setImageResource(R.drawable.i62);
                break;
            case 63:
                img.setImageResource(R.drawable.i63);
                break;
            case 64:
                img.setImageResource(R.drawable.i64);
                break;
            case 65:
                img.setImageResource(R.drawable.i65);
                break;
            case 66:
                img.setImageResource(R.drawable.i66);
                break;
            case 67:
                img.setImageResource(R.drawable.i67);
                break;
            case 68:
                img.setImageResource(R.drawable.i68);
                break;
            case 69:
                img.setImageResource(R.drawable.i69);
                break;
            case 70:
                img.setImageResource(R.drawable.i70);
                break;
            case 71:
                img.setImageResource(R.drawable.i71);
                break;
            case 72:
                img.setImageResource(R.drawable.i72);
                break;
            case 73:
                img.setImageResource(R.drawable.i73);
                break;
            case 74:
                img.setImageResource(R.drawable.i74);
                break;
            case 75:
                img.setImageResource(R.drawable.i75);
                break;
            case 76:
                img.setImageResource(R.drawable.i76);
                break;
            case 77:
                img.setImageResource(R.drawable.i77);
                break;
            case 78:
                img.setImageResource(R.drawable.i78);
                break;
            case 79:
                img.setImageResource(R.drawable.i79);
                break;
            case 80:
                img.setImageResource(R.drawable.i80);
                break;
            case 81:
                img.setImageResource(R.drawable.i81);
                break;
            case 82:
                img.setImageResource(R.drawable.i82);
                break;
            case 83:
                img.setImageResource(R.drawable.i83);
                break;
            case 84:
                img.setImageResource(R.drawable.i84);
                break;
            case 85:
                img.setImageResource(R.drawable.i85);
                break;
            case 86:
                img.setImageResource(R.drawable.i86);
                break;
        }
    }

}
