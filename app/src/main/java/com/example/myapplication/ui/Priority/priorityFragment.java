package com.example.myapplication.ui.Priority;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Category;
import com.example.myapplication.ui.category.CategoryAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link priorityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class priorityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public priorityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment priorityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static priorityFragment newInstance(String param1, String param2) {
        priorityFragment fragment = new priorityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_chung, container, false);
//        AppDatabase db = AppDatabase.getDatabase(getContext());

        RecyclerView categoryView = root.findViewById(R.id.recycle_view);

//        db.getQueryExecutor().execute(() -> {
//            categories = db.categoryDaoDao().getAllCategory();
//            categoryAdapter = new CategoryAdapter(categories);
//            categoryView.setAdapter(categoryAdapter);
//            categoryView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        });


        AlertDialog al = new AlertDialog.Builder(root.getContext()).create();
        View view = getLayoutInflater().inflate(R.layout.dialog_priority, null);
        Button btnAdd = view.findViewById(R.id.btn_category_add);
        EditText edCategory = view.findViewById(R.id.edittext_category);
        al.setView(view);

//        btnAdd.setOnClickListener(v1 -> {
//            Category c = new Category();
//            c.name = edCategory.getText().toString();
//            c.created_date = LocalDateTime.now().toString();
//            AppDatabase.databaseWriteExecutor.execute(()->{
//                if(db.categoryDaoDao().findCategory(c.name) != null)
//                    return;
//                db.categoryDaoDao().insert(c);
//                categoryAdapter.addCategory(c);
//                categoryAdapter.notifyItemInserted(categoryAdapter.getItemCount());
//            });
//            al.cancel();
//        });

        FloatingActionButton fl = root.findViewById(R.id.floating_category);
        fl.setOnClickListener(v -> {
            al.show();
        });
        return root;
    }
}