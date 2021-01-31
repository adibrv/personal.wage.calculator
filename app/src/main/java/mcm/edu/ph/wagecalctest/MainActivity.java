package mcm.edu.ph.wagecalctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button computePay;

        computePay = findViewById(R.id.computePay);

        computePay.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        EditText workTimeInput, regPayTxt, ovPayTxt;
        TextView totalPay;

        workTimeInput = findViewById(R.id.workTimeInput);
        regPayTxt = findViewById(R.id.regPayTxt);
        ovPayTxt = findViewById(R.id.ovPayTxt);
        totalPay = findViewById(R.id.totalPayText);

        double workingHours = 0.0;
        double regularPay = 0.0;
        double overtimePay = 0.0;
        double totalPayout = 0.0;
        double answer = 0.0;
        double max = 8;


        double regularPayFormula, overtimePayFormula1, overtimePayFormula2, maxRegularPay;

        workingHours = Double.parseDouble(workTimeInput.getText().toString());
        regularPay = Double.parseDouble(regPayTxt.getText().toString());
        overtimePay = Double.parseDouble(ovPayTxt.getText().toString());

        regularPayFormula = workingHours * regularPay;
        overtimePayFormula1 = workingHours - max;
        overtimePayFormula2 = overtimePayFormula1 * overtimePay;
        maxRegularPay = regularPay * max;

        if (workingHours < 8) {
            totalPayout = regularPayFormula;
        }

        if (workingHours == 8 ) {
            totalPayout = maxRegularPay;
        }

        if (workingHours > 8) {
            totalPayout = overtimePayFormula2 + maxRegularPay;
        }

        switch (v.getId()) {
            case R.id.computePay:
                answer = totalPayout;
                totalPay.setText("P"+Double.toString(answer)+ "" );
                break;
        }
    }
}