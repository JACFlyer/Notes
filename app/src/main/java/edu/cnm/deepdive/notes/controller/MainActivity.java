package edu.cnm.deepdive.notes.controller;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import edu.cnm.deepdive.notes.R;
import edu.cnm.deepdive.notes.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private ListView notesList;
  private MainViewModel viewModel;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Instantiation of ListView for inflation
    notesList = findViewById(R.id.notes_list);
    notesList.setOnItemClickListener((parent, view, position, id) -> {
      //  TODO Open up alert, to allow editing of Note Instance.

    });
    notesList.setOnItemLongClickListener((parent, view, position, id) -> {
      //  TODO Pop up a context menu, to allow removal of a Note Instance.
      return true;
    });
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener((view) -> {/*  TODO Pop up an allert, which will talk to viewModel to add an item.*/});

    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getAll().observe(this, (notes) -> {
      //  TODO Create and populate an ArrayAdapter and pass it to the notesList.
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
