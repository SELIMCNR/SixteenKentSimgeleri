package com.selimcinar.kentsimgeleri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.selimcinar.kentsimgeleri.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    //Wiew binding eklemek
    //Gizli ActiviteadıBinding binding;
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          //İnflate xml ile kodları bağlar bu aşağıdaki kodları her aktivitede ekle
            binding = ActivityDetailsBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
    //ViewBinding idlere erişimde yeni nesil çözüm
    //Jetpack android kütüphaneler topluluğudur.import ile eklenir
        //CountryText idsinin yazı kısmına ALO yaz.

        Intent intent = getIntent();
        Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.detailsText.setText(selectedLandmark.details);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}