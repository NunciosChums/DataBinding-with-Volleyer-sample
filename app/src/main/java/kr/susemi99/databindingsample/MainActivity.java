package kr.susemi99.databindingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import kr.susemi99.databindingsample.adapters.ClassListAdapter;

public class MainActivity extends AppCompatActivity
{
  private ClassListAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    adapter = new ClassListAdapter();

    ListView list = (ListView) findViewById(android.R.id.list);
    list.setAdapter(adapter);

    load();
  }

  private void load()
  {
    adapter.clear();
    adapter.notifyDataSetChanged();
    
  }
}
