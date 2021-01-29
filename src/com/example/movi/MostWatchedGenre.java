package com.example.movi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostWatchedGenre {
    public static void mostwatchedgenre() throws IOException {
        List<Integer> genreids = new ArrayList<>();
        for (int i = 0; i < 19; i++)
            genreids.add(0);
        List<Rating> ra =new ArrayList<Rating>() ;
        ParseFromFile.parsing_rating(ra);

        List<Movie> mo =new ArrayList<Movie>() ;
        ParseFromFile.parsing_movie(mo);

        for(int i=0;i<ra.size();i++){
            int currmovieid=ra.get(i).ItemId;

            List<Integer> genid = mo.get(currmovieid-1).genre;


            for(int j=0;j<genid.size();j++){
                if(genid.get(j)==1){
                    genreids.set(j,genreids.get(j)+1);
                }
            }
        }


        int mostwatchedgenreid=-1;
        int maxx=-1;
        for(int i=0;i<genreids.size();i++){
             //   System.out.println(genreids.get(i));
            if(maxx<genreids.get(i)){
                maxx=genreids.get(i);
                mostwatchedgenreid=i;
            }
        }

        System.out.println("Most Watched Genre Id: "+ mostwatchedgenreid);



    }
}
