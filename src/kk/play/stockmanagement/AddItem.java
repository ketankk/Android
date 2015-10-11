package kk.play.stockmanagement;

import java.util.ArrayList;
import java.util.List;

import kk.play.stockmanagement.database.CyclesDBHandler;
import kk.play.stockmanagement.entity.Cycles;
import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItem extends Activity {

	EditText name;
	EditText image;
	EditText desc;
	EditText size;
	EditText quantity;
	Spinner type;
	Spinner color;

	Button addButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
		
		addButton=(Button)findViewById(R.id.addButton);
		
		//
		name=(EditText)findViewById(R.id.name);
		image=(EditText)findViewById(R.id.image);
		desc=(EditText)findViewById(R.id.desc);
		size=(EditText)findViewById(R.id.size);
		quantity=(EditText)findViewById(R.id.quantity);

		color=(Spinner)findViewById(R.id.color);

		List<String> colorList=new ArrayList<String>();
		colorList.add("Red");
		colorList.add("Green");
		colorList.add("Black");
		colorList.add("Violet");
		colorList.add("Others");
		
		ArrayAdapter<String> adp1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,colorList);
		adp1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		color.setAdapter(adp1);
		
		type=(Spinner)findViewById(R.id.type);
		List<String> typeList=new ArrayList<String>();
		typeList.add("Gents");
		typeList.add("Ladies");
		typeList.add("Kids");
		typeList.add("Others");
		

		ArrayAdapter<String> adp2=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,typeList);
		adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		type.setAdapter(adp2);
		
		
		addButton.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View arg0) {
				
				Cycles cycle=new Cycles();
				
				cycle.setNAME(name.getText().toString());
				cycle.setQUANTITY(Integer.parseInt(quantity.getText().toString()));
				cycle.setDESCRIPTION(desc.getText().toString());
				cycle.setCOLOR(color.getSelectedItem().toString());
				cycle.setIMAGE(image.getText().toString());
				cycle.setSIZE(Integer.parseInt(size.getText().toString()));
				cycle.setTYPE(type.getSelectedItem().toString());
				Log.d(name.getText().toString(), quantity.getText().toString());
				
				
				CyclesDBHandler handler=new CyclesDBHandler(getApplication());
				if(handler.addNewCycle(cycle))
					Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
				//handler.getCyclesByType(type);
								
			}
		});

		
	}
	

	
}
