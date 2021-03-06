package com.takisoft.colorpicker.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.takisoft.colorpicker.ColorPickerDialog;
import com.takisoft.colorpicker.OnColorSelectedListener;
import com.takisoft.colorpicker.ColorPickerDialogFragment;

public class MainActivity extends AppCompatActivity implements OnColorSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ColorPickerDialog.Params params = new ColorPickerDialog.Params.Builder(getApplicationContext())
                //.setSize(ColorPickerDialog.SIZE_SMALL)
                //.setColumns(5)
                //.setSortColors(true)
                .setSelectedColor(getResources().getColor(R.color.deep_orange))
                //.setColorContentDescriptions()
                //.setColors(getResources().getIntArray(R.array.color_picker_default_colors))
                .build();

        findViewById(R.id.color_picker_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog dialog = new ColorPickerDialog(MainActivity.this, MainActivity.this, params);
                dialog.show();
            }
        });

        findViewById(R.id.color_picker_support_fragment_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogFragment dialogFragment = ColorPickerDialogFragment.newInstance(R.string.color_picker_default_title, params);
                dialogFragment.show(getSupportFragmentManager(), "supportDialog");
            }
        });
    }

    @Override
    public void onColorSelected(int color) {
        Toast.makeText(this, "0x" + Integer.toHexString(color).toUpperCase(), Toast.LENGTH_SHORT).show();
    }
}
