package my.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DetailNoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Note note = (Note) intent.getSerializableExtra(DetailNoteFragment.ARG_INDEX);
            DetailNoteFragment detailNoteFragment = DetailNoteFragment.newInstance(note);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.layout_container, detailNoteFragment);
            fragmentTransaction.commit();
        }
    }
}
