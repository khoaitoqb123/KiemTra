package cntt61.a61133985.baitho;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cntt61.a61133985.baitho.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listData;
    ArrayAdapter adapter;
    TextView textView;
    Button button, sua;
    EditText editText;
    int vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvlist);
        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.btnNhap);
        editText = (EditText) findViewById(R.id.edt);
        sua = (Button) findViewById(R.id.btnSua);
        listData = new ArrayList<>();
        listData.add("Sóng");
        listData.add("Bài thơ về tiểu đội xe không kính");
        listData.add("Đồng Chí");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString();
                listData.add(item);
                adapter.notifyDataSetChanged();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String val = (String) listView.getItemAtPosition(i);
                textView.setText("position: " + i + "\t" + ";" + "\t" + "value: " + val);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(listData.get((int) i));
                vt = i;
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = editText.getText().toString();
                listData.set(vt, ten);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn muốn xóa hay không");
                dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int vt) {
                        listData.remove(vt);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    }
}
