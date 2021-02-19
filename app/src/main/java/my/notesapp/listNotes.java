package my.notesapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class listNotes extends Fragment {
    LinkedList<Note> notesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getNotesList();
        initView(view);
    }

    private void getNotesList() {
        notesList= new LinkedList<Note>();
        String s=getString(R.string.notes_mock);
        try {
            JSONArray jsonNotesList= new JSONArray(s);
            for (int i = 0; i < jsonNotesList.length() ; i++) {
                JSONObject jsonNote = jsonNotesList.getJSONObject(i);
                Note note = new Note(jsonNote);
                notesList.add(note);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView(View view){
        LinearLayout list_note_body = (LinearLayout) view;
        Iterator<Note> it = notesList. iterator() ;
        while(it.hasNext()) {
            Note note = it.next();
            View rowNoteView = HelperNoteView.getRowNoteFromListView(note,view.getContext());
            list_note_body.addView(rowNoteView);
        }
    }
}