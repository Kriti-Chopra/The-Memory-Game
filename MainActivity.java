package kriti.somevalue.com.rollthedice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.security.SecureRandom;


public class MainActivity extends AppCompatActivity {

    private int answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt1=(TextView)findViewById(R.id.txt1);
        final TextView txt2=(TextView)findViewById(R.id.txt2);
        final TextView txt3=(TextView)findViewById(R.id.txt3);
        final TextView txt4=(TextView)findViewById(R.id.txt4);
        final TextView txt5=(TextView)findViewById(R.id.txt5);
        final TextView txt6=(TextView)findViewById(R.id.txt6);

       //  int answer;

        final EditText edtNumber=(EditText) findViewById(R.id.edtNumber);
        final TextView txtResult=(TextView) findViewById(R.id.txtResult);

        Button btnGo=(Button)findViewById(R.id.btnGo);
        ImageButton btnDice=(ImageButton) findViewById(R.id.btnDice);


       btnDice.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SecureRandom randomNum=new SecureRandom();
               int int1=0,int2=0,int3=0,int4=0,int5=0,int6=0;
               //boolean firstTime=false;
               for(int i=0;i<6;++i){
                   int num=1+randomNum.nextInt(6);
                  // log.i("LOG",num);
                   switch(num){
                       case 1: ++int1;
                           break;
                       case 2: ++int2;
                           break;
                       case 3: ++int3;
                           break;
                       case 4: ++int4;
                           break;
                       case 5: ++int5;
                           break;
                       case 6: ++int6;
                           break;
                   }
               }
               txt1.setText(int1+"");
               txt2.setText(int2+"");
               txt3.setText(int3+"");
               txt4.setText(int4+"");
               txt5.setText(int5+"");
               txt6.setText(int6+"");

               answer=100000*int1+10000*int2+1000*int3+100*int4+10*int5+int6;

               txt1.postDelayed(new Runnable() {
                   public void run() {
                       txt1.setVisibility(View.INVISIBLE);
                   }
               },1000);
               txt2.postDelayed(new Runnable() {
                   public void run() {
                       txt2.setVisibility(View.INVISIBLE);
                   }
               },3000);
               txt3.postDelayed(new Runnable() {
                   public void run() {
                       txt3.setVisibility(View.INVISIBLE);
                   }
               },1000);
               txt4.postDelayed(new Runnable() {
                   public void run() {
                       txt4.setVisibility(View.INVISIBLE);
                   }
               },3000);
               txt5.postDelayed(new Runnable() {
                   public void run() {
                       txt5.setVisibility(View.INVISIBLE);
                   }
               },1000);
               txt6.postDelayed(new Runnable() {
                   public void run() {
                       txt6.setVisibility(View.INVISIBLE);
                   }
               },2000);

           }
       });

       btnGo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int num=Integer.parseInt(edtNumber.getText().toString());
               if(num==answer){
                    txtResult.setText("Winner winner,chicken dinner");
               }
               else{
                   txtResult.setText("Oops! Next time:(");
               }
               txt1.setVisibility(View.VISIBLE);
               txt2.setVisibility(View.VISIBLE);
               txt3.setVisibility(View.VISIBLE);
               txt4.setVisibility(View.VISIBLE);
               txt5.setVisibility(View.VISIBLE);
               txt6.setVisibility(View.VISIBLE);

           }
       });



    }
}
