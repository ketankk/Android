package kk.play.stockmanagement;

import java.util.List;

import kk.play.stockmanagement.adapters.CycleCustomListAdapter;
import kk.play.stockmanagement.database.CyclesItemDBHandler;
import kk.play.stockmanagement.entity.Cycle;
import kk.play.stockmanagement.fragmentscycles.CycleListController;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ShowAllCycles extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cycles);
		
		Bundle extras=getIntent().getExtras();
		String type=extras.getString("type");
		String companyName=extras.getString("compname");
		CyclesItemDBHandler dbHandler = new CyclesItemDBHandler(this);

List<Cycle> cycles = dbHandler.getCyclesByTypeComp(type,companyName);

		Log.d("showall", "jj");
		CycleCustomListAdapter adp = new CycleCustomListAdapter(this, cycles);

		ListView lview = (ListView)findViewById(R.id.list);

		lview.setAdapter(adp);
		

	}

	
}
