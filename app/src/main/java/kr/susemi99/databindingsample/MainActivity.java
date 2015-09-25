package kr.susemi99.databindingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.navercorp.volleyextensions.volleyer.Volleyer;

import kr.susemi99.databindingsample.adapters.ClassListAdapter;
import kr.susemi99.databindingsample.items.ParentResourceClassItem;
import kr.susemi99.databindingsample.items.ResourceClassItem;
import kr.susemi99.databindingsample.items.RowItem;

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

    String url = "http://openapi.seoul.go.kr:8088/sample/json/SeoulJungNangWomenResourcesClass/1/5/";

    Volleyer.volleyer().get(url)
            .withTargetClass(ParentResourceClassItem.class)
            .withListener(listener)
            .withErrorListener(errorListener)
            .execute();
  }

  /////////////////////////////////////
  // listener
  ////////////////////////////////////
  private Response.Listener<ParentResourceClassItem> listener = new Response.Listener<ParentResourceClassItem>()
  {
    @Override
    public void onResponse(ParentResourceClassItem item)
    {
      Log.i("MainActivity | onResponse", "|" + item.resourceClassItem.result.code + "|" + item.resourceClassItem.result.message + "|");

      if(!item.resourceClassItem.result.code.equals("INFO-000"))
        return;

      for (RowItem row : item.resourceClassItem.rows)
      {
        adapter.add(row);
      }

      adapter.notifyDataSetChanged();
    }
  };

  private Response.ErrorListener errorListener = new Response.ErrorListener()
  {
    @Override
    public void onErrorResponse(VolleyError error)
    {
      Log.i("MainActivity | onErrorResponse", "|" + error.getLocalizedMessage() + "|");
    }
  };
}
