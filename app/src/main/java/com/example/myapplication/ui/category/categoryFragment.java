package com.example.myapplication.ui.category;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.util.Date;

public class categoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chung, container, false);

        AppDatabase db = AppDatabase.getDatabase(getContext());

        FloatingActionButton fl = (FloatingActionButton) root.findViewById(R.id.floating_category);
        fl.setOnClickListener(v -> {
            AlertDialog al = new AlertDialog.Builder(root.getContext())
                    .setView(R.layout.dialog_category).create();
            Button btnAdd = (Button)al.findViewById(R.id.btn_category_add);
            EditText edCategory = (EditText)al.findViewById(R.id.edittext_category);
            btnAdd.setOnClickListener(v1 -> {
                Category c = new Category();
                c.created_date = LocalDateTime.now().toString();
                c.name = edCategory.getText().toString();

                db.categoryDaoDao().insert(c);
            });
            al.show();
        });
        return root;
    }
}
