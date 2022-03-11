package com.example.fragmentdt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;


public class ContentFrag extends Fragment {

    GridView gridView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.getRootView().findViewById(R.id.gridview);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            String s = adapterView.getItemAtPosition(i ).toString();
            Intent intent = new Intent(view.getContext(), ViewPhoto.class);
            intent.putExtra("url", s);
            startActivity(intent);
        });
        return view;
    }

    String[] flower = {
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510_960_720.jpg",
            "https://cdn.pixabay.com/photo/2013/07/21/13/00/rose-165819_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/01/mountains-736886_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186_960_720.jpg"
    };
    String[] animal = {
            "https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_960_720.jpg",
            "https://cdn.pixabay.com/photo/2018/02/17/21/56/cute-3161014_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_960_720.jpg",
            "https://cdn.pixabay.com/photo/2014/10/01/10/44/hedgehog-468228_960_720.jpg",
    };
    String[] tree = {
            "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_960_720.jpg",
            "https://cdn.pixabay.com/photo/2021/11/13/23/06/tree-6792528_960_720.jpg",
            "https://cdn.pixabay.com/photo/2018/11/17/22/15/trees-3822149_960_720.jpg",
            "https://cdn.pixabay.com/photo/2014/12/04/14/46/magnolia-trees-556718_960_720.jpg",
    };


    public void updateContent(int position){
        switch (position){
            case 0:
                gridView.setAdapter(new PhotoAdapter(getContext(),flower));
                break;
            case 1:
                gridView.setAdapter(new PhotoAdapter(getContext(),animal));
                break;
            case 2:
                gridView.setAdapter(new PhotoAdapter(getContext(),tree));
                break;
        }
    }
}
