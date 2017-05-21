package pune.com.devicesensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sm;
    List<Sensor> ls;
    ListView lv;
    ArrayList<String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item=new ArrayList<String>();
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        lv=(ListView) findViewById(R.id.lv);
        ls=sm.getSensorList(Sensor.TYPE_ALL);
        Toast.makeText(this, "Your Device Has "+ls.size()+" Sensors", Toast.LENGTH_SHORT).show();
        for (int i=0; i<ls.size(); i++)
        {
            item.add(ls.get(i).getName().toString());
            ArrayAdapter<String> ad=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,item);
            lv.setAdapter(ad);


        }
    }
}
