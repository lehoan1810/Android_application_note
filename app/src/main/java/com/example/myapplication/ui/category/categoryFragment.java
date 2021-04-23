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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class categoryFragment extends Fragment {
    List<Category> categories;
    CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chung, container, false);

        AppDatabase db = AppDatabase.getDatabase(getContext());

        RecyclerView categoryView = root.findViewById(R.id.recycle_view);

        db.getQueryExecutor().execute(() -> {
            categories = db.categoryDaoDao().getAllCategory();
            categoryAdapter = new CategoryAdapter(categories);
            categoryView.setAdapter(categoryAdapter);
            categoryView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        });


        AlertDialog al = new AlertDialog.Builder(root.getContext()).create();
        View view = getLayoutInflater().inflate(R.layout.dialog_category, null);
        Button btnAdd = view.findViewById(R.id.btn_category_add);
        EditText edCategory = view.findViewById(R.id.edittext_category);
        al.setView(view);

        btnAdd.setOnClickListener(v1 -> {
            Category c = new Category();
            c.name = edCategory.getText().toString();
            c.created_date = LocalDateTime.now().toString();
            AppDatabase.databaseWriteExecutor.execute(()->{
                if(db.categoryDaoDao().findCategory(c.name) != null)
                    return;
                db.categoryDaoDao().insert(c);
                categoryAdapter.addCategory(c);
                categoryAdapter.notifyItemInserted(categoryAdapter.getItemCount());
            });
            al.cancel();
        });

        FloatingActionButton fl = root.findViewById(R.id.floating_category);
        fl.setOnClickListener(v -> {
            al.show();
        });
        return root;
    }
}
