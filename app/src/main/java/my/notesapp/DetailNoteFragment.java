package my.notesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailNoteFragment extends Fragment {
    public static final String ARG_INDEX = "arg_index";
    private TextView detailTitle;
    private TextView detailDateCreated;
    private TextView detailDescription;
    private Button detailMenuButton;

    public static DetailNoteFragment newInstance(Note note){
        DetailNoteFragment fragment = new DetailNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_INDEX,note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("DetailNoteFragment onCreateView");
        return inflater.inflate(R.layout.fragment_detail_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initElementView(view);
    }

    private void initElementView(View view) {
        detailTitle = view.findViewById(R.id.detail_title);
        detailMenuButton = view.findViewById(R.id.detail_menu_button);
        detailDateCreated = view.findViewById(R.id.detail_date_created);
        detailDescription = view.findViewById(R.id.detail_description);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null){
            Note note = (Note) getArguments().getSerializable(ARG_INDEX);
            detailTitle.setText(note.getTitle());
            detailDateCreated.setText(note.getDate());
            detailDescription.setText(note.getDescription());
        }
    }
}
