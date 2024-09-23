package com.example.lab3bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    EditText edtA, edtB;
    TextView txtA, txtB, txtResult;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initControl()
    {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        txtResult = findViewById(R.id.txtResult);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Tổng");
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Hiệu");
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Tích");
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Thương");
            }
        });
        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("UCLN");
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Reset");
            }
        });
    }

    private void performOperation (String operator) {
        try {
            int a = Integer.parseInt(edtA.getText().toString()); // Use edtA for input
            int b = Integer.parseInt(edtB.getText().toString()); // Use edtB for input
            int result = 0;

            switch (operator) {
                case "Tổng":
                    result = a + b;
                    break;
                case "Hiệu":
                    result = a - b;
                    break;
                case "Tích":
                    result = a * b;
                    break;
                case "Thương":
                    if (b != 0) {
                        result = a / b;
                    } else {
                        txtResult.setText("B phải khác 0");
                        return;
                    }
                    break;
                case "UCLN":
                    result = gcd(a, b);
                    break;
                case "Reset":
                    edtA.setText("");
                    edtB.setText("");
                    txtResult.setText("");
                    return;
                default:
                    return;
            }
            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtResult.setText("Vui lòng nhập số");
        }
    }

    private int gcd ( int a, int b){
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
}

    
