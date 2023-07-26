package com.example.ejercicio6m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio6m5.databinding.FragmentImageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {
    FragmentImageBinding binding;

    ArrayList<Item> data = new ArrayList<>();

    AdapterImage adapter = new AdapterImage();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
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
        binding = FragmentImageBinding.inflate(getActivity().getLayoutInflater(), container, false);
        setAdapterImage();

        return binding.getRoot();
    }
    public void setAdapterImage(){
        adapter.setData(createData());
        binding.recyclerView.setAdapter(adapter);
    }

    private List<Item> createData() {
        data.add(new Item("foto1", "https://falabella.scene7.com/is/image/Falabella/gsc_119965461_2550876_2?wid=240&hei=240&qlt=70&fmt=webp"));
        data.add(new Item("foto2", "https://falabella.scene7.com/is/image/Falabella/gsc_120271443_2596964_2?wid=240&hei=240&qlt=70&fmt=webp"));
        data.add(new Item("foto3", "https://falabella.scene7.com/is/image/Falabella/15643829_2?wid=240&hei=240&qlt=70&fmt=webp"));

        return data;
    }
}