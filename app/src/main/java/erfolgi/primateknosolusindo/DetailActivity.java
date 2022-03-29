package erfolgi.primateknosolusindo;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import erfolgi.primateknosolusindo.GMailSender;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nama ;
    EditText alamat ;
    EditText ktp ;
    EditText jumlah ;
    Button sent;
    String n,a,k,j;
    public static String EXTRA_BARANG="Barang";
    TextView NP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        EXTRA_BARANG=getIntent().getStringExtra(EXTRA_BARANG);

        NP=findViewById(R.id.TVPRODUK);

        NP.setText(EXTRA_BARANG);
        nama=findViewById(R.id.NameCust);
        alamat=findViewById(R.id.AlamatCust);
        ktp=findViewById(R.id.KTPCust);
        jumlah=findViewById(R.id.CountCust);

        sent =findViewById(R.id.Pesan);
        sent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Pesan){
            n=nama.getText().toString();
            a=alamat.getText().toString();
            k=ktp.getText().toString();
            j=jumlah.getText().toString();
                erfolgi.primateknosolusindo.GMailSender sender = new erfolgi.primateknosolusindo.GMailSender("emailofdummy@gmail.com", "fortestingpurpose");
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
                if(sender!=null){
                    Log.d("SendMail", "hlooo");
                    try {
                sender.sendMail("Pemesanan "+EXTRA_BARANG,
                        "Nama : "+n+"\nAlamat : "+a+"\nKTP : "+k+"\nJumlah yang dipesan: "+j,
                        "emailofdummy@gmail.com",
                        "firzaprima@gmail.com");

                        Log.d("SendMail", "hlol");
                        Toast.makeText(this, "Pemesanan Sedang Dikirim", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
                }
                Log.d("SendMail", "hlooo");

//            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//            emailIntent.setType("text/plain");
//            emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"erfolgi827@gmail.com"});
//            emailIntent.putExtra(Intent.EXTRA_CC, new String[]{""});
//            emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{""});
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Pemesanan "+EXTRA_BARANG);
//            emailIntent.putExtra(Intent.EXTRA_TEXT, "Nama : "+n+"\nAlamat : "+a+"\nKTP : "+k+"\nJumlah yang dipesan: "+j);
//            startActivity(emailIntent);
        }
    }
}
