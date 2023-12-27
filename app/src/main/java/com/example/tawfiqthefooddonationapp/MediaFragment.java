package com.example.tawfiqthefooddonationapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MediaFragment extends Fragment {
    CardView newsA, newsB, newsC, newsD, newsE,newsF,newsG,newsH,newsI,newsJ,newsK,newsL,newsM,newsN,newsO,newsP,newsQ,newsR,newsS,newsT,newsU,newsV,newsW,newsX,newsY,newsZ;

    ImageView imgA, imgB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_media, container, false);


        newsA = rootView.findViewById(R.id.cardNewsa);
        newsB = rootView.findViewById(R.id.cardNewsb);
        newsC = rootView.findViewById(R.id.cardNewsc);
        newsD = rootView.findViewById(R.id.cardNewsd);
        newsE = rootView.findViewById(R.id.cardNewse);
        newsF = rootView.findViewById(R.id.cardNewsf);
        newsG = rootView.findViewById(R.id.cardNewsg);
        newsH = rootView.findViewById(R.id.cardNewsh);
        newsI = rootView.findViewById(R.id.cardNewsi);
        newsJ = rootView.findViewById(R.id.cardNewsj);
        newsK = rootView.findViewById(R.id.cardNewsk);
        newsL = rootView.findViewById(R.id.cardNewsl);
        newsM = rootView.findViewById(R.id.cardNewsm);
        newsN = rootView.findViewById(R.id.cardNewsn);
        newsO = rootView.findViewById(R.id.cardNewso);
        newsP = rootView.findViewById(R.id.cardNewsp);
        newsQ = rootView.findViewById(R.id.cardNewsq);
        newsR = rootView.findViewById(R.id.cardNewsr);
        newsS = rootView.findViewById(R.id.cardNewss);
        newsT = rootView.findViewById(R.id.cardNewst);
        newsU = rootView.findViewById(R.id.cardNewsu);
        newsV = rootView.findViewById(R.id.cardNewsv);
        newsW = rootView.findViewById(R.id.cardNewsw);
        newsX = rootView.findViewById(R.id.cardNewsx);
        newsY = rootView.findViewById(R.id.cardNewsy);
        newsZ = rootView.findViewById(R.id.cardNewsz);

        imgA = rootView.findViewById(R.id.news_image_1);
        imgB = rootView.findViewById(R.id.news_image_2);



        Glide.with(this).load("https://humnews.pk/wp-content/uploads/2023/07/129179-amysmwudwl-1571201895-1024x538.jpg").into(imgA);
        Glide.with(this).load("https://southasianvoices.org/wp-content/uploads/2023/04/4973650367_eba8751102_o-1095x616.jpg").into(imgB);





        newsA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://humnews.pk/latest/pakistan-stands-at-99-in-global-hunger-index/"));
                startActivity(myWeblink);
            }
        });

        newsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://southasianvoices.org/post-flash-floods-in-pakistan/"));
                startActivity(myWeblink);

            }
        });

        newsC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://policycommons.net/artifacts/4071094/pakistan/4878402/"));
                startActivity(myWeblink);

            }
        });

        newsD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://peoplesdispatch.org/2023/06/19/one-in-five-children-in-pakistan-is-suffering-from-wasting-says-unocha-report/"));
                startActivity(myWeblink);

            }
        });

        newsE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.aljazeera.com/news/2023/7/26/why-is-pakistan-ranked-99th-on-the-global-hunger-index"));
                startActivity(myWeblink);

            }
        });

        newsF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.theguardian.com/global-development/2023/mar/29/lost-jobs-hunger-food-charity-kitchens-feeding-millions-pakistan"));
                startActivity(myWeblink);

            }
        });

        newsG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.arabnews.com/node/2327366"));
                startActivity(myWeblink);

            }
        });

        newsH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.unicef.org/emergencies/devastating-floods-pakistan-2022"));
                startActivity(myWeblink);

            }
        });

        newsI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.reuters.com/markets/asia/pakistan-inflation-hits-record-364-april-highest-region-2023-05-02/"));
                startActivity(myWeblink);

            }
        });

        newsJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.aljazeera.com/news/2023/8/23/floods-force-evacuation-of-almost-100000-in-pakistan"));
                startActivity(myWeblink);

            }
        });

        newsK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://dailytimes.com.pk/1008944/more-than-3-4m-children-in-pakistan-facing-chronic-hunger-report/"));
                startActivity(myWeblink);

            }
        });

        newsL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://gulfnews.com/world/asia/pakistan/wheat-flour-bread-prices-skyrocket-as-food-inflation-grips-pakistan-1.93113443"));
                startActivity(myWeblink);

            }
        });

        newsM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://blogs.worldbank.org/endpovertyinsouthasia/how-are-children-pakistans-2022-floods-faring"));
                startActivity(myWeblink);

            }
        });

        newsN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.arabnews.pk/node/2345801/pakistan"));
                startActivity(myWeblink);

            }
        });

        newsO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.dawn.com/news/1724745"));
                startActivity(myWeblink);

            }
        });

        newsP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://time.com/6247300/pakistan-food-crisis-climate-change-inflation/"));
                startActivity(myWeblink);

            }
        });

        newsQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://blog.strive2thrive.earth/food-insecurity-in-pakistan-challenges-and-opportunities/"));
                startActivity(myWeblink);

            }
        });

        newsR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.pakistantoday.com.pk/2023/09/08/a-crisis-of-malnutrition-and-starvation-in-pakistan/"));
                startActivity(myWeblink);

            }
        });

        newsS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://thefridaytimes.com/20-Aug-2023/explaining-hunger-in-pakistan-food-security-in-historical-and-contemporary-perspective"));
                startActivity(myWeblink);

            }
        });

        newsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5977042/"));
                startActivity(myWeblink);

            }
        });

        newsU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.nation.com.pk/12-Jun-2023/exacerbating-food-insecurity-in-pakistan"));
                startActivity(myWeblink);

            }
        });

        newsV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.dawn.com/news/1729644"));
                startActivity(myWeblink);

            }
        });

        newsW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://propakistani.pk/2023/01/11/pakistans-cost-of-living-crisis-can-result-in-hunger-and-distress-for-millions-report/"));
                startActivity(myWeblink);

            }
        });

        newsX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.pakistantoday.com.pk/2023/06/04/global-south-debt-distress-and-food-shortages/"));
                startActivity(myWeblink);

            }
        });

        newsY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.pakistantoday.com.pk/2023/01/01/impact-of-climate-change-on-food-security-in-pakistan/"));
                startActivity(myWeblink);

            }
        });

        newsZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("https://www.ctvnews.ca/world/pakistani-traders-strike-countrywide-against-high-inflation-and-utility-bills-1.6545757"));
                startActivity(myWeblink);

            }
        });





        return rootView;
    }
}